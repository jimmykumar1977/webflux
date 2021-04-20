package app;

import app.handler.MovieHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;


@Configuration
public class MovieRouter {

    @Bean
    public RouterFunction<ServerResponse> route(MovieHandler movieHandler) {
        return RouterFunctions.route(GET("/movies/{id}").and(accept(APPLICATION_JSON)), movieHandler::get)
                .andRoute(GET("/movies").and(accept(APPLICATION_JSON)), movieHandler::all);

    }
}
