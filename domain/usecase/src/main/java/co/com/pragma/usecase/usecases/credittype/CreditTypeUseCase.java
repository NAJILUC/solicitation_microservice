package co.com.pragma.usecase.usecases.credittype;

import co.com.pragma.model.credittype.CreditType;
import co.com.pragma.model.credittype.gateways.CreditTypeRepository;
import co.com.pragma.usecase.errorcodes.ErrorCodeEnum;
import co.com.pragma.usecase.exception.NotFoundValidationException;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.logging.Logger;

@RequiredArgsConstructor
public class CreditTypeUseCase {

    private final CreditTypeRepository creditTypeRepository;

    private static final Logger log = Logger.getLogger(CreditTypeUseCase.class.getName());

    public Mono<CreditType> createCreditType(CreditType creditType) {
        return creditTypeRepository.save(creditType);
    }

    public Flux<CreditType> getAllCreditTypes() {
        return creditTypeRepository.findAll();
    }

    public Mono<CreditType> getCreditTypeById(Long id) {
        log.info("Search credit type by id");
        return creditTypeRepository.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundValidationException(List.of(ErrorCodeEnum.C01CRTY01))));
    }
}
