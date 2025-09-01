package co.com.pragma.r2dbc;

import co.com.pragma.r2dbc.entity.SolicitationEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.Set;

// TODO: This file is just an example, you should delete or modify it
public interface SolicitationEntityRepository extends ReactiveCrudRepository<SolicitationEntity, Long>, ReactiveQueryByExampleExecutor<SolicitationEntity> {

    @Query("SELECT * FROM solicitations WHERE status_id IN (:statusIds)")
    Flux<SolicitationEntity> findByStatusIds(Set<Long> statusIds);
}
