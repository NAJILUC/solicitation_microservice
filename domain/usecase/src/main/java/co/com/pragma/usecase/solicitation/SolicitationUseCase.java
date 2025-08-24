package co.com.pragma.usecase.solicitation;

import co.com.pragma.model.solicitation.Solicitation;
import co.com.pragma.model.solicitation.gateways.SolicitationRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SolicitationUseCase {
    private final SolicitationRepository solicitationRepository;

    public Mono<Solicitation> createSolicitation(Solicitation solicitation) {
        return solicitationRepository.save(solicitation);
    }

    public Flux<Solicitation> getAllSolicitations() {
        return solicitationRepository.findAll();
    }

    public Mono<Solicitation> getSolicitationById(Long id) {
        return solicitationRepository.findById(id);
    }
}
