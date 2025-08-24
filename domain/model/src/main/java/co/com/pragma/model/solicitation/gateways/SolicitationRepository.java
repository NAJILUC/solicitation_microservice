package co.com.pragma.model.solicitation.gateways;

import co.com.pragma.model.solicitation.Solicitation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SolicitationRepository {
    Mono<Solicitation> save(Solicitation solicitation);

    Flux<Solicitation> findAll();

    Mono<Solicitation> findById(Long id);
}
