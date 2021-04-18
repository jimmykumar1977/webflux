package app.services;

import app.domain.Movie;
import app.repositories.MovieRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Mono<Movie> save(Movie movie){
        return movieRepository.save(movie);
    }

    public Mono<Movie> findById(UUID id){
        return movieRepository.findById(id.toString());
    }

    public Flux<Movie> finalAll() {
        return movieRepository.findAll();
    }
}
