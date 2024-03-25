package models;

import enums.Genre;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Database {
    public static List<Movie> movies = new LinkedList<>(
            List.of(
                    new Movie(1, "harry potter",
                            LocalDate.of(1992, 8, 27),
                            Genre.FANTASTIC, new Producer("Harry", "Potter"),
                            new LinkedList<>(Arrays.asList(new Actor("Harry Potter", "glavnyi geroy"),
                                    new Actor("My Jerry", "vtorostepennyi")))),
                    new Movie(2, "Tom and Jerry",
                            LocalDate.of(2018, 4, 23),
                            Genre.COMEDY, new Producer("Beknazar", "Zholdoshbekov"),
                            new LinkedList<>(Arrays.asList(new Actor("Djeyms Gosling", "drug"),
                                    new Actor("Hello world", "glavnyi geroy")))),
                    new Movie(3, "One Piece",
                            LocalDate.of(2024, 12, 10),
                            Genre.HORROR, new Producer("Jeyms", "Berry"),
                            new LinkedList<>(Arrays.asList(new Actor("Andjelina Djoly", "background"),
                                    new Actor("java", "antogonist")))),
                    new Movie(4, "Sixte crows",
                            LocalDate.of(1999, 1, 15),
                            Genre.DRAMA, new Producer("Rus Akun", "Potter"),
                            new LinkedList<>(Arrays.asList(new Actor("Harry Potter", "antogonist"),
                                    new Actor("rest and varargs", "Skala"))))
            )
    );
}
