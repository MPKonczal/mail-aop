package pl.edu.utp.wtie.homeworkweek6.service;

import org.springframework.stereotype.Service;
import pl.edu.utp.wtie.homeworkweek6.model.Movie;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private List<Movie> movieList;

    public MovieService() {
        this.movieList = new ArrayList<>();
        movieList = initMovieList();
    }

    private List<Movie> initMovieList() {
        movieList.add(new Movie(1L, "The Shawshank Redemption", 1994, "Frank Darabont"));
        movieList.add(new Movie(2L, "The Green Mile", 1999, "Frank Darabont"));
        movieList.add(new Movie(3L, "Forrest Gump", 1994, "Robert Zemeckis"));
        movieList.add(new Movie(4L, "Django Unchained", 2012, "Quentin Tarantino"));
        movieList.add(new Movie(5L, "Hacksaw Ridge", 2016, "Mel Gibson"));
        return movieList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public boolean addNewMovie(Movie movie) {
        return movieList.add(movie);
    }
}
