package co.com.pragma.r2dbc;

import co.com.pragma.model.solicitation.Solicitation;
import co.com.pragma.model.solicitation.gateways.SolicitationRepository;
import co.com.pragma.model.utils.PaginationObj;
import co.com.pragma.r2dbc.entity.SolicitationEntity;
import co.com.pragma.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

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

    @Override
    public Flux<Solicitation> findAllByStatusIdIn(List<Long> statusId, PaginationObj paginationObj) {

        return repository.findByStatusIds(statusId, paginationObj.getSize(), paginationObj.getPage())
                .map(solicitationEntity -> super.mapper.map(solicitationEntity, Solicitation.class));
    }

    @Override
    public Mono<Long> countByStatusIdIn(List<Long> statusIds) {
        return repository.countByStatusIdIn(statusIds);
    }

    public static Pageable createPageAndSort(PaginationObj paginationObj) {
        paginationObj.setPage((paginationObj.getPage()) > 0 ? paginationObj.getPage() - 1 : paginationObj.getPage());
        Pageable pageable;
        if (paginationObj.getColumn() == null || paginationObj.getColumn().isEmpty()) {
            pageable = PageRequest.of(paginationObj.getPage(), paginationObj.getSize());
        } else {
            pageable = PageRequest.of(paginationObj.getPage(), paginationObj.getSize(),
                    createSort(paginationObj.getOrder(), paginationObj.getColumn()));
        }
        return pageable;
    }

    private static Sort createSort(String order, String column) {
        if ("desc".equalsIgnoreCase(order)) {
            return Sort.by(Sort.Direction.DESC, column);
        } else {
            return Sort.by(Sort.Direction.ASC, column);
        }
    }
}
