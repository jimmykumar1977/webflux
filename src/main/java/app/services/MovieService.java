package app.services;

import app.domain.Movie;
import app.dto.MovieDTO;
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

    public Mono<Movie> save(MovieDTO movie){
      return movieRepository.findByTitle(movie.getTitle())
               .switchIfEmpty(Mono.just(new Movie(movie.getTitle(),movie.getYear())))
              .flatMap(m-> {
                  if (m.getId() == null) {
                      m.setId(UUID.randomUUID().toString());
                      return  movieRepository.save(m);
                  } else {
                      return Mono.just(m);
                  }
              });
    }

    public Mono<Movie> findById(UUID id){
        return movieRepository.findById(id.toString());
    }

    public Mono<Movie> findByTitle(String title){
        return movieRepository.findByTitle(title);
    }

    public Flux<Movie> finalAll() {
        return movieRepository.findAll();
    }
}
