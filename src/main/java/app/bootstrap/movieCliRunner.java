package app.bootstrap;

import app.domain.Movie;
import app.repositories.MovieRepository;
import app.services.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;


public class movieCliRunner implements CommandLineRunner {
    private final MovieRepository movieRepository;

    private final MovieService movieService;

    public movieCliRunner(MovieRepository movieRepository, MovieService movieService) {
        this.movieRepository = movieRepository;
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(" ------- ");
        Flux<Integer> flux = Flux.just(1,2,3,4,5,6,7);

        /*
         Flux.just("One","Two","Four","Five")
                .map(s -> new Movie(UUID.randomUUID().toString(),s,1989))
                .flatMap(movieRepository::save)
                .subscribe(null,null,()->{
                    movieRepository.findAll().subscribe(System.out::println);
                });

         */

        /*flux.map(s-> s.toUpperCase())
               // .doOnError(t-> System.out.println(t+"happended breaking flow"))
               .subscribe(s-> System.out.println("got "+s),null,()-> System.out.println("completed..."));
*/

    /*  flux
             // .flatMap(a->  (a < 3 ) ? Mono.just(a) : Mono.error(new RuntimeException("sample error")))
              .doOnError(t-> System.out.println("exception happended"+t))
               .subscribe(a->System.out.println(" got "+a),t->System.out.println("error consumer"));*/

       /* Flux.just("One","Two","Four","Five")
                .map(s -> new Movie(UUID.randomUUID().toString(),s,1989))
                .flatMap(movieService::save)
                .subscribe(null,null,()->{
                    movieRepository.findAll().subscribe(System.out::println);
                });*/

       /* Mono.just("Last Movie")
                .map(s -> new Movie(UUID.randomUUID().toString(),s,1991))
                .flatMap(movieService::save)
                .subscribe(null,null,() -> {
                    movieService.finalAll().subscribe(System.out::println);
                });*/

    }


}
