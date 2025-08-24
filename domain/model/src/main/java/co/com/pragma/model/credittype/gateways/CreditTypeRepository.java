package co.com.pragma.model.credittype.gateways;

import co.com.pragma.model.credittype.CreditType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditTypeRepository {

    Mono<CreditType> save(CreditType solicitationType);

    Flux<CreditType> findAll();

    Mono<CreditType> findById(Long id);
}
