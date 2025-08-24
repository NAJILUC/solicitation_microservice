package co.com.pragma.usecase.status;

import co.com.pragma.model.status.Status;
import co.com.pragma.model.status.gateways.StatusRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class StatusUseCase {

    private final StatusRepository statusRepository;

    public Mono<Status> createStatus(Status status) {
        return statusRepository.save(status);
    }

    public Flux<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    public Mono<Status> getStatusById(Long id) {
        return statusRepository.findById(id);
    }
}
