package co.com.pragma.model.solicitation.gateways;

import co.com.pragma.model.solicitation.Solicitation;
import co.com.pragma.model.utils.PaginationObj;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Set;

public interface SolicitationRepository {
    Mono<Solicitation> save(Solicitation solicitation);

    Flux<Solicitation> findAll();

    Mono<Solicitation> findById(Long id);

    Flux<Solicitation> findAllByStatusIdIn(List<Long> statusId, PaginationObj pageable);

    Mono<Long> countByStatusIdIn(List<Long> statusIds);
}
