package co.com.pragma.r2dbc;

import co.com.pragma.model.credittype.CreditType;
import co.com.pragma.model.credittype.gateways.CreditTypeRepository;
import co.com.pragma.model.status.Status;
import co.com.pragma.model.status.gateways.StatusRepository;
import co.com.pragma.r2dbc.entity.CreditTypeEntity;
import co.com.pragma.r2dbc.entity.StatusEntity;
import co.com.pragma.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class CreditTypeEntityRepositoryAdapter extends ReactiveAdapterOperations<
        CreditType/* change for domain model */,
        CreditTypeEntity/* change for adapter model */,
        Long,
        CreditTypeEntityRepository
        > implements CreditTypeRepository {
    public CreditTypeEntityRepositoryAdapter(CreditTypeEntityRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, CreditType.class/* change for domain model */));
    }

    @Override
    public Mono<CreditType> findById(Long id) {
        return super.findById(id);
    }
}
