package co.com.pragma.api.routerrest.solicitations;

import co.com.pragma.api.dto.request.solicitations.CreateSolicitationRequest;
import co.com.pragma.api.dto.response.solicitations.SolicitationResponse;
import co.com.pragma.api.handlers.solicitations.SolicitationHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SolicitationRouterRest {
    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/api/v1/solicitations",
                    method = RequestMethod.POST,
                    operation = @Operation(
                            operationId = "createSolicitation",
                            summary = "Create a new solicitation",
                            tags = {"Solicitation"},
                            requestBody = @RequestBody(
                                    description = "Solicitation data",
                                    required = true,
                                    content = @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = CreateSolicitationRequest.class)
                                    )
                            ),
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "Created solicitation",
                                            content = @Content(
                                                    mediaType = "application/json",
                                                    schema = @Schema(implementation = SolicitationResponse.class)
                                            )
                                    ),
                                    @ApiResponse(responseCode = "400", description = "Bad request"),
                                    @ApiResponse(responseCode = "500", description = "Internal server error")
                            }
                    )
            )
    })
    public RouterFunction<ServerResponse> routerFunction(SolicitationHandler solicitationHandler) {
        return route(POST("/api/v1/solicitations"), solicitationHandler::listenCreateSolicitation);
    }
}
