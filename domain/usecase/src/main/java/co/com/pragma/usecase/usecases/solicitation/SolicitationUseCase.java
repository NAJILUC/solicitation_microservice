package co.com.pragma.usecase.usecases.solicitation;

import co.com.pragma.model.solicitation.Solicitation;
import co.com.pragma.model.solicitation.SolicitationWthData;
import co.com.pragma.model.solicitation.gateways.SolicitationRepository;
import co.com.pragma.model.utils.PaginationObj;
import co.com.pragma.usecase.enums.status.StatusEnum;
import co.com.pragma.usecase.objects.solicitations.SolicitationFilterObj;
import co.com.pragma.usecase.objects.utils.GenericPagModelResponse;
import co.com.pragma.usecase.usecases.credittype.CreditTypeUseCase;
import co.com.pragma.usecase.usecases.status.StatusUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@RequiredArgsConstructor
public class SolicitationUseCase {

    private final SolicitationRepository solicitationRepository;
    private final CreditTypeUseCase creditTypeUseCase;
    private final StatusUseCase statusUseCase;

    private static final Logger log = Logger.getLogger(SolicitationUseCase.class.getName());

    public Mono<SolicitationWthData> createSolicitation(Solicitation solicitation) {
        log.info("Init create solicitation");
        Long statusId = StatusEnum.PENDING.getId();
        solicitation.setStatusId(statusId);

        return creditTypeUseCase.getCreditTypeById(solicitation.getCreditTypeId())
                .flatMap(creditType ->
                        statusUseCase.getStatusById(solicitation.getStatusId())
                                .flatMap(status ->
                                        solicitationRepository.save(solicitation)
                                                .map(saved -> new SolicitationWthData(saved, status, creditType))
                                )
                );
    }

    public Mono<GenericPagModelResponse<SolicitationWthData>> getSolicitationsByStatusId(
            PaginationObj paginationObj, SolicitationFilterObj solicitationFilterObj) {

        List<Long> validStatusId = List.of(
                StatusEnum.PENDING.getId(),
                StatusEnum.REJECTED.getId(),
                StatusEnum.MANUAL_REVISION.getId()
        );

        Mono<Long> totalItems = solicitationRepository.countByStatusIdIn(validStatusId);

        Flux<SolicitationWthData> items = solicitationRepository.findAllByStatusIdIn(validStatusId, paginationObj)
                .flatMap(solicitation ->
                        creditTypeUseCase.getCreditTypeById(solicitation.getCreditTypeId())
                                .flatMap(creditType ->
                                        statusUseCase.getStatusById(solicitation.getStatusId())
                                                .map(status -> new SolicitationWthData(solicitation, status, creditType))
                                )
                );

        return totalItems.flatMap(total ->
                items.collectList()
                        .map(list -> new GenericPagModelResponse<>(
                                list,
                                paginationObj.getPage(),
                                paginationObj.getSize(),
                                total
                        ))
        );
    }
}
