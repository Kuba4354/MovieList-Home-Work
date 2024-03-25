package service.serviceImpl;

import models.Database;
import models.Movie;
import models.Producer;
import service.MovieSortableService;

import java.util.Comparator;

public class MovieSortableServiceImpl implements MovieSortableService {
    @Override
    public void sortMovieByName(String ascOrDesc) {
        Comparator<Movie> compareByName = Comparator.comparing(Movie::getName);
        Database.movies.sort(ascOrDesc.equalsIgnoreCase("asc") ? compareByName : compareByName.reversed());
    }

    @Override
    public void sortByYear(String ascOrDesc) {
        Comparator<Movie> compareByYear = Comparator.comparing(Movie::getYear);
        Database.movies.sort(ascOrDesc.equalsIgnoreCase("asc") ? compareByYear : compareByYear.reversed());
    }

    @Override
    public void sortByProducer(String nameOrLastName) {
        Comparator<Movie> compareByProducer = Comparator.comparing(movie -> {
            Producer producer = movie.getProducer();
            return nameOrLastName.equalsIgnoreCase("lastName") ? producer.getLastName() : producer.getFirstName();
        });
        Database.movies.sort(compareByProducer);
    }
}
