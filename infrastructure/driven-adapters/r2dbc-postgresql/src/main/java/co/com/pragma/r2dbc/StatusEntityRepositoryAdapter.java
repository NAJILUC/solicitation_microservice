package co.com.pragma.r2dbc;

import co.com.pragma.model.status.Status;
import co.com.pragma.model.status.gateways.StatusRepository;
import co.com.pragma.r2dbc.entity.StatusEntity;
import co.com.pragma.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class StatusEntityRepositoryAdapter extends ReactiveAdapterOperations<
        Status/* change for domain model */,
        StatusEntity/* change for adapter model */,
        Long,
        StatusEntityRepository
        > implements StatusRepository {
    public StatusEntityRepositoryAdapter(StatusEntityRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Status.class/* change for domain model */));
    }

    @Override
    public Mono<Status> findById(Long id) {
        return super.findById(id);
    }
}
