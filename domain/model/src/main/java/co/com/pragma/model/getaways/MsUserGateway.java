package co.com.pragma.model.getaways;

import reactor.core.publisher.Mono;

public interface MsUserGateway {
    Mono<Boolean> getUserByDocument(String identificationNumber);
}