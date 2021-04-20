package app.handler;

import app.domain.Movie;
import app.services.MovieService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class MovieHandler {
    private final MovieService movieService;

    public MovieHandler(MovieService movieService) {
        this.movieService = movieService;
    }

    public Mono<ServerResponse> get(ServerRequest request) {
                        return   getUUID(request)
                                   .flatMap(movieService::findById)
                                   .flatMap(result -> ServerResponse.ok().contentType(APPLICATION_JSON).bodyValue(result))
                                   .switchIfEmpty( ServerResponse.notFound().build() )
                                   .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()) );
    }

    public Mono<ServerResponse> all(ServerRequest request) {
        return ok().contentType(APPLICATION_JSON)
                .body(fromPublisher(movieService.finalAll(), Movie.class));
    }

    private Mono<UUID> getUUID(ServerRequest request) {
        try {
            System.out.println("Logger : id value "+request.pathVariable("id"));
            return Mono.just(UUID.fromString(request.pathVariable("id")));
        } catch (Exception err) {
            System.out.println("Logger : exception occurred"+err.getMessage());
            return Mono.error(new Exception("Bad Input"));
        }
    }

}
