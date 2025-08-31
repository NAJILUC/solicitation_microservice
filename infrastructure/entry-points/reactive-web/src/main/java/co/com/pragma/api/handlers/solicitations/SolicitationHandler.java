package co.com.pragma.api.handlers.solicitations;

import co.com.pragma.api.dto.request.solicitations.CreateSolicitationRequest;
import co.com.pragma.api.dto.response.solicitations.SolicitationResponse;
import co.com.pragma.api.handlers.utils.GenericHandler;
import co.com.pragma.api.mapper.solicitations.SolicitationMapper;
import co.com.pragma.model.solicitation.Solicitation;
import co.com.pragma.model.status.Status;
import co.com.pragma.usecase.usecases.solicitation.SolicitationUseCase;
import lombok.RequiredArgsConstructor;
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
}
