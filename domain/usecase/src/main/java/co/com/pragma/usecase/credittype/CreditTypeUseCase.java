package co.com.pragma.usecase.credittype;

import co.com.pragma.model.credittype.CreditType;
import co.com.pragma.model.credittype.gateways.CreditTypeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreditTypeUseCase {

    private final CreditTypeRepository creditTypeRepository;

    public Mono<CreditType> createCreditType(CreditType creditType) {
        return creditTypeRepository.save(creditType);
    }

    public Flux<CreditType> getAllCreditTypes() {
        return creditTypeRepository.findAll();
    }

    public Mono<CreditType> getCreditTypeById(Long id) {
        return creditTypeRepository.findById(id);
    }
}
