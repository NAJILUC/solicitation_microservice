package co.com.pragma.api.handlers.solicitations;

import co.com.pragma.api.dto.request.solicitations.CreateSolicitationRequest;
import co.com.pragma.api.dto.response.solicitations.SolicitationResponse;
import co.com.pragma.api.handlers.utils.GenericHandler;
import co.com.pragma.api.mapper.solicitations.SolicitationMapper;
import co.com.pragma.api.mapper.utils.PaginationObjMapper;
import co.com.pragma.model.solicitation.Solicitation;
import co.com.pragma.usecase.objects.solicitations.SolicitationFilterObj;
import co.com.pragma.model.utils.PaginationObj;
import co.com.pragma.usecase.usecases.solicitation.SolicitationUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class SolicitationHandler extends GenericHandler {

    private final SolicitationUseCase solicitationUseCase;

    protected SolicitationHandler(Validator validator, SolicitationUseCase solicitationUseCase) {
        super(validator);
        this.solicitationUseCase = solicitationUseCase;
    }

    public Mono<ServerResponse> listenCreateSolicitation(ServerRequest request) {
        return request.bodyToMono(CreateSolicitationRequest.class)
                .flatMap(this::validate)
                .flatMap(dto -> {
                    Solicitation solicitation = SolicitationMapper.toModel(dto);
                    return solicitationUseCase.createSolicitation(solicitation);
                })
                .flatMap(solicitationWthData -> {
                    SolicitationResponse userResponse = SolicitationMapper.toResponse(solicitationWthData);
                    return this.okResponse(userResponse);
                });
    }

    public Mono<ServerResponse> listenGetAllSolByStatusId(ServerRequest serverRequest) {
        int page = serverRequest.queryParam("page").map(Integer::parseInt).orElse(1);
        int size = serverRequest.queryParam("size").map(Integer::parseInt).orElse(10);
        String column = serverRequest.queryParam("column").orElse("id");
        String order = serverRequest.queryParam("order").orElse("DESC");

        PaginationObj paginationObj = PaginationObjMapper.toObj(page, size, column, order);

        Long creditTypeId = serverRequest.queryParam("creditTypeId").map(Long::parseLong).orElse(null);
        Long statusId = serverRequest.queryParam("statusId").map(Long::parseLong).orElse(null);
        SolicitationFilterObj solicitationFilterObj = SolicitationMapper.solicitationFilterObj(creditTypeId, statusId);

        return solicitationUseCase.getSolicitationsByStatusId(paginationObj, solicitationFilterObj)
                .flatMap(response -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(response)
                );
    }
}
