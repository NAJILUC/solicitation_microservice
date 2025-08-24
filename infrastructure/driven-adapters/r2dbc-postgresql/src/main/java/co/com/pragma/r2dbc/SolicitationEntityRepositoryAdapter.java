package co.com.pragma.r2dbc;

import co.com.pragma.model.credittype.CreditType;
import co.com.pragma.model.credittype.gateways.CreditTypeRepository;
import co.com.pragma.model.solicitation.Solicitation;
import co.com.pragma.model.solicitation.gateways.SolicitationRepository;
import co.com.pragma.r2dbc.entity.CreditTypeEntity;
import co.com.pragma.r2dbc.entity.SolicitationEntity;
import co.com.pragma.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class SolicitationEntityRepositoryAdapter extends ReactiveAdapterOperations<
        Solicitation/* change for domain model */,
        SolicitationEntity/* change for adapter model */,
        Long,
        SolicitationEntityRepository
        > implements SolicitationRepository {
    public SolicitationEntityRepositoryAdapter(SolicitationEntityRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Solicitation.class/* change for domain model */));
    }

    @Override
    public Mono<Solicitation> save(Solicitation solicitation) {
        return super.save(solicitation);
    }

    @Override
    public Flux<Solicitation> findAll() {
        return super.findAll();
    }

    @Override
    public Mono<Solicitation> findById(Long id) {
        return super.findById(id);
    }
}
