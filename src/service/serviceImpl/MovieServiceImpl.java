package service.serviceImpl;

import enums.Genre;
import models.Actor;
import models.Database;
import models.Movie;
import models.Producer;
import service.MovieService;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MovieServiceImpl implements MovieService {
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerLn = new Scanner(System.in);

    @Override
    public String addMovie() {
        System.out.println("Write movie id: ");
        int id = scannerNum.nextInt();

        for (Movie movie : Database.movies) {
            if (movie.getId() == id) {
                return "A movie with the same id already exists";
            }
        }

        System.out.println("Write movie name: ");
        String name = scannerLn.nextLine();

        System.out.println("Write movie year: ");
        int year = scannerNum.nextInt();

        System.out.println("Write the month of cinema digitally: ");
        int month = scannerNum.nextInt();

        System.out.println("Write movie day: ");
        int day = scannerNum.nextInt();

        LocalDate date = LocalDate.of(year, month, day);

        System.out.println("Write movie genre: ");
        Genre genre = Genre.FANTASTIC;

        System.out.println("Write producer first name: ");
        String producerFirstName = scannerLn.nextLine();

        System.out.println("Write producer last name: ");
        String producerLastName = scannerLn.nextLine();

        Producer producer = new Producer(producerFirstName, producerLastName);

        System.out.println("Write actor full name: ");
        String fullName = scannerLn.nextLine();

        System.out.println("Write actor role: ");
        String role = scannerLn.nextLine();

        List<Actor> actors = new LinkedList<>();

        actors.add(new Actor(fullName, role));
        String answer;
        do {
            System.out.println("Want to add another actor? (yes/no)");
            answer = scannerLn.nextLine();

            if (answer.equalsIgnoreCase("yes")) {
                System.out.println("Write actor full name: ");
                String actorFullName = scannerLn.nextLine();

                System.out.println("Write actor role: ");
                String actorRole = scannerLn.nextLine();

                actors.add(new Actor(actorFullName, actorRole));
            }
        } while (answer.equalsIgnoreCase("yes"));

        Database.movies.add(new Movie(id, name, date, genre, producer, actors));
        return "Movie successfully added";
    }

    @Override
    public void updateMovie() {
        if (!Database.movies.isEmpty()) {
            System.out.println("Write the id of the movie you want to update: ");
            int id = scannerNum.nextInt();
            int count = 0;

            for (Movie movie : Database.movies) {
                if (movie.getId() == id) {
                    count++;
                }
            }

            if (count != 0) {
                System.out.println("Write a new movie name: ");
                String name = scannerLn.nextLine();

                System.out.println("Write a new movie year: ");
                int year = scannerNum.nextInt();

                System.out.println("Write a new the month of cinema digitally: ");
                int month = scannerNum.nextInt();

                System.out.println("Write a new movie day: ");
                int day = scannerNum.nextInt();

                LocalDate date = LocalDate.of(year, month, day);

                System.out.println("Write a new a new movie genre: ");
                Genre genre = Genre.FANTASTIC;

                System.out.println("Write a new producer first name: ");
                String producerFirstName = scannerLn.nextLine();

                System.out.println("Write a new producer last name: ");
                String producerLastName = scannerLn.nextLine();

                Producer producer = new Producer(producerFirstName, producerLastName);

                System.out.println("Write a new actor full name: ");
                String fullName = scannerLn.nextLine();

                System.out.println("Write a new actor role: ");
                String role = scannerLn.nextLine();

                List<Actor> actors = new LinkedList<>();

                actors.add(new Actor(fullName, role));
                String answer;
                do {
                    System.out.println("Want to add another actor? (yes/no)");
                    answer = scannerLn.nextLine();

                    if (answer.equalsIgnoreCase("yes")) {
                        System.out.println("Write a new actor full name: ");
                        String actorFullName = scannerLn.nextLine();

                        System.out.println("Write a new actor role: ");
                        String actorRole = scannerLn.nextLine();

                        actors.add(new Actor(actorFullName, actorRole));
                    }
                } while (answer.equalsIgnoreCase("yes"));

                Database.movies.set(id, new Movie(id, name, date, genre, producer, actors));
                System.out.println("Movie successfully updated!");
            } else {
                System.out.println("There is no movie with this id");
            }
        } else {
            System.out.println("You don't have any films yet");
        }
    }

    @Override
    public void deleteMovie() {
        if (!Database.movies.isEmpty()) {
            System.out.println("Write the id of the movie you want to delete: ");
            int id = scannerNum.nextInt();
            int count = 0;

            for (Movie movie : Database.movies) {
                if (movie.getId() == id) {
                    Database.movies.remove(movie);
                    count++;
                }
            }
            if (count != 0) {
                System.out.println("Movie successfully deleted!");
            } else {
                System.out.println("There is no movie with this id");
            }
        } else {
            System.out.println("You don't have any films yet");
        }
    }
}
