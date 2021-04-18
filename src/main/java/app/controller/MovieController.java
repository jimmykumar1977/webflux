package app.controller;

import app.domain.Movie;
import app.dto.MovieDTO;
import app.services.MovieService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;

@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies/{id}")
    public Mono<Movie> getMovieDetails(@PathVariable String id) {
            return movieService.findById(UUID.fromString(id));
    }

    @PostMapping("/movies")
    public Mono<ResponseEntity<Movie>> createMovie(@RequestBody MovieDTO movie) {
        return Mono.just(movie)
                .map(m -> new Movie(UUID.randomUUID().toString(), m.getTitle(), m.getYear()))
                .flatMap(movieService::save)
                .map(m -> ResponseEntity.created(URI.create("/movies/" + m.getId())).contentType(MediaType.APPLICATION_JSON).build());

    }
}
