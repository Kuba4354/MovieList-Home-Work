package service.serviceImpl;

import enums.Genre;
import models.Actor;
import models.Database;
import models.Movie;
import service.MovieFindableService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieFindableServiceImpl implements MovieFindableService {
    @Override
    public List<Movie> getAllMovies() {
        if (!Database.movies.isEmpty()) {
            return Database.movies;
        } else {
            System.out.println("You don't have any films yet");
        }
        return new ArrayList<>();
    }

    @Override
    public Movie findMovieByFullNameOrPartName(String name) {
        for (Movie movie : Database.movies) {
            if (movie.getName().toLowerCase().contains(name.toLowerCase())) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByActorName(String actorName) {
        for (Movie movie : Database.movies) {
            for (Actor actor : movie.getActors()) {
                if (actor.getActorFullName().toLowerCase().contains(actorName.toLowerCase())) {
                    return movie;
                }
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByYear(LocalDate year) {
        for (Movie movie : Database.movies) {
            if (movie.getYear().toString().toLowerCase().contains(year.toString().toLowerCase())) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByProducer(String producerFullName) {
        for (Movie movie : Database.movies) {
            if ((movie.getProducer().getFirstName() + " " + movie.getProducer().getLastName()).toLowerCase().contains(producerFullName.toLowerCase())) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByGenre(Genre genre) {
        for (Movie movie : Database.movies) {
            if (movie.getGenre().toString().toLowerCase().contains(genre.toString().toLowerCase())) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByRole(String role) {
        for (Movie movie : Database.movies) {
            for (Actor actor : movie.getActors()) {
                if (actor.getRole().toLowerCase().contains(role.toLowerCase())) {
                    return movie;
                }
            }
        }
        return null;
    }
}
