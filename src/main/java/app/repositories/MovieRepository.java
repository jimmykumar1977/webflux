package app.repositories;

import app.domain.Movie;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MovieRepository extends ReactiveMongoRepository<Movie,String> {

    @Query("{'title' : ?0}")
    Mono<Movie> findByTitle(String title);
}
