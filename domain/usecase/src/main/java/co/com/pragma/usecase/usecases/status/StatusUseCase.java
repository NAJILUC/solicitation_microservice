package co.com.pragma.usecase.usecases.status;

import co.com.pragma.model.status.Status;
import co.com.pragma.model.status.gateways.StatusRepository;
import co.com.pragma.usecase.errorcodes.ErrorCodeEnum;
import co.com.pragma.usecase.exception.NotFoundValidationException;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.logging.Logger;

@RequiredArgsConstructor
public class StatusUseCase {

    private final StatusRepository statusRepository;

    private static final Logger log = Logger.getLogger(StatusUseCase.class.getName());

    public Mono<Status> createStatus(Status status) {
        return statusRepository.save(status);
    }

    public Flux<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    public Mono<Status> getStatusById(Long id) {
        log.info("Search status type by id");
        return statusRepository.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundValidationException(
                        List.of(ErrorCodeEnum.C01STAT01))));
    }
}
