package co.com.pragma.api.routerrest.solicitations;

import co.com.pragma.api.dto.response.solicitations.CreditTypeResponse;
import co.com.pragma.api.handlers.solicitations.CreditTypeHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreditTypeRouterRest {
    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/api/v1/credit-types",
                    method = RequestMethod.GET,
                    operation = @Operation(
                            operationId = "findAllCreditType",
                            summary = "Create a new solicitation",
                            tags = {"CreditType"},
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "Credit types",
                                            content = @Content(
                                                    mediaType = "application/json",
                                                    schema = @Schema(implementation = CreditTypeResponse.class)
                                            )
                                    ),
                                    @ApiResponse(responseCode = "400", description = "Bad request"),
                                    @ApiResponse(responseCode = "500", description = "Internal server error")
                            }
                    )
            )
    })
    public RouterFunction<ServerResponse> creditTypeRouterFunction(CreditTypeHandler creditTypeHandler) {
        return route(GET("/api/v1/credit-types"), creditTypeHandler::listenGetAllUsers);
    }
}
