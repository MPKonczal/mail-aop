package pl.edu.utp.wtie.homeworkweek6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.utp.wtie.homeworkweek6.aspect.EmailAspect;
import pl.edu.utp.wtie.homeworkweek6.model.Movie;
import pl.edu.utp.wtie.homeworkweek6.service.MovieService;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieApi {

    private MovieService movieService;

    @Autowired
    public MovieApi(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<>(movieService.getMovieList(), HttpStatus.OK);
    }

    @PostMapping
    @EmailAspect
    public ResponseEntity addMovie(@RequestBody Movie movie) {
        if (movieService.addNewMovie(movie)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
