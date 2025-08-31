package co.com.pragma.api.handlers.solicitations;

import co.com.pragma.api.handlers.utils.GenericHandler;
import co.com.pragma.api.mapper.solicitations.CreditTypeMapper;
import co.com.pragma.usecase.usecases.credittype.CreditTypeUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class CreditTypeHandler extends GenericHandler {

    private final CreditTypeUseCase creditTypeUseCase;

    protected CreditTypeHandler(Validator validator, CreditTypeUseCase creditTypeUseCase) {
        super(validator);
        this.creditTypeUseCase = creditTypeUseCase;
    }

    public Mono<ServerResponse> listenGetAllUsers(ServerRequest serverRequest) {
        return creditTypeUseCase.getAllCreditTypes()
                .map(CreditTypeMapper::toResponse)
                .collectList()
                .flatMap(this::okResponse);
    }
}
