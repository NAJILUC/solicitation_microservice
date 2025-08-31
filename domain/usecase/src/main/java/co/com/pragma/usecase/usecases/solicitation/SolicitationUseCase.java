package co.com.pragma.usecase.usecases.solicitation;

import co.com.pragma.model.credittype.CreditType;
import co.com.pragma.model.solicitation.Solicitation;
import co.com.pragma.model.solicitation.SolicitationWthData;
import co.com.pragma.model.solicitation.gateways.SolicitationRepository;
import co.com.pragma.model.status.Status;
import co.com.pragma.usecase.enums.status.StatusEnum;
import co.com.pragma.usecase.usecases.credittype.CreditTypeUseCase;
import co.com.pragma.usecase.usecases.status.StatusUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

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
                                                .map(saved -> toSolicitationWithData(saved, status, creditType))
                                )
                );
    }

    private SolicitationWthData toSolicitationWithData(Solicitation solicitation, Status status, CreditType creditType) {
        log.info("Mapping to response");
        return new SolicitationWthData(
                solicitation.getId(),
                solicitation.getAmount(),
                solicitation.getTerm(),
                solicitation.getEmail(),
                status.getDescription(),
                status.getId(),
                creditType.getName(),
                creditType.getId(),
                solicitation.getApplicantDocument()
        );
    }
}
