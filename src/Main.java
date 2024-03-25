import enums.Genre;
import service.MovieFindableService;
import service.MovieService;
import service.MovieSortableService;
import service.serviceImpl.MovieFindableServiceImpl;
import service.serviceImpl.MovieServiceImpl;
import service.serviceImpl.MovieSortableServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerLn = new Scanner(System.in);

        MovieService movieService = new MovieServiceImpl();
        MovieFindableService movieFindableService = new MovieFindableServiceImpl();
        MovieSortableService movieSortableService = new MovieSortableServiceImpl();

        while (true) {
            System.out.println("""
                    ╔══════════════════════════════════════════════════════╗
                    ║                  СПИСОК ЗАДАЧ (Todos)                ║
                    ╠══════════════════════════════════════════════════════╣
                    ║                Что вы хотите сделать?                ║
                    ║                                                      ║
                    ║ 1. Добавить фильм                                    ║
                    ║ 2. Обновить информацию о фильме                      ║
                    ║ 3. Удалить фильм                                     ║
                    ║ 4. Получить список всех фильмов                      ║
                    ║ 5. Найти фильм по параметрам                         ║
                    ║ 6. Отсортировать фильмы по параметрам                ║
                    ║                                                      ║
                    ╚══════════════════════════════════════════════════════╝
                                       
                        """);
            switch (scannerNum.nextInt()) {
                case 1:
                    System.out.println(movieService.addMovie());
                    break;
                case 2:
                    movieService.updateMovie();
                    break;
                case 3:
                    movieService.deleteMovie();
                    break;
                case 4:
                    System.out.println(movieFindableService.getAllMovies());
                    break;
                case 5:
                    while (true) {
                        System.out.println("""
                                ╔══════════════════════════════════════════════════════════╗
                                ║               ПОИСК ФИЛЬМА ПО ПАРАМЕТРАМ                 ║
                                ╠══════════════════════════════════════════════════════════╣
                                ║                 По какому параметру искать?              ║
                                ║                                                          ║
                                ║ 1. Найти фильм по полному или частичному названию        ║
                                ║ 2. Найти фильм по имени актера                           ║
                                ║ 3. Найти фильм по году выпуска                           ║
                                ║ 4. Найти фильм по режиссеру                              ║
                                ║ 5. Найти фильм по жанру                                  ║
                                ║ 6. Найти фильм по роли                                   ║
                                ║ 7. Выйти из поисковой строки                             ║
                                ║                                                          ║
                                ╚══════════════════════════════════════════════════════════╝
                                                              
                                    """);

                        int command = scannerNum.nextInt();

                        if (command == 7) {
                            break;
                        }

                        switch (command) {
                            case 1:
                                System.out.println("Write movie full name or part name: ");

                                String fullOrPartName = scannerLn.nextLine();
                                System.out.println(movieFindableService.findMovieByFullNameOrPartName(fullOrPartName));
                                break;
                            case 2:
                                System.out.println("Write actor name: ");

                                String actorName = scannerLn.nextLine();
                                System.out.println(movieFindableService.findMovieByActorName(actorName));
                                break;
                            case 3:
                                System.out.println("Write movie year: ");
                                int year = scannerNum.nextInt();

                                System.out.println("Write the month of cinema digitally: ");
                                int month = scannerNum.nextInt();

                                System.out.println("Write movie day: ");
                                int day = scannerNum.nextInt();

                                LocalDate date = LocalDate.of(year, month, day);
                                System.out.println(movieFindableService.findMovieByYear(date));
                                break;
                            case 4:
                                System.out.println("Write producer name: ");

                                String producerName = scannerLn.nextLine();
                                System.out.println(movieFindableService.findMovieByProducer(producerName));
                                break;
                            case 5:
                                System.out.println("Write movie genre: ");

                                Genre genre = Genre.FANTASTIC;
                                System.out.println(movieFindableService.findMovieByGenre(genre));
                                break;
                            case 6:
                                System.out.println("Write movie role: ");

                                String role = scannerLn.nextLine();
                                System.out.println(movieFindableService.findMovieByRole(role));
                                break;
                            default:
                                System.out.println("Wrong action!");
                        }
                    }
                    break;
                case 6:
                    while (true) {
                        System.out.println("""
                                What parameters do you want to sort by  ?
                                1. Sort movie by name
                                2. Sort movie by Вот стилизованное меню для выбора параметра сортировки фильмов:
                                             
                                             ```
                                             ╔══════════════════════════════════════════════════════════╗
                                             ║               СОРТИРОВКА ФИЛЬМОВ ПО ПАРАМЕТРАМ           ║
                                             ╠══════════════════════════════════════════════════════════╣
                                             ║                 По какому параметру сортировать?         ║
                                             ║                                                          ║
                                             ║ 1. Сортировать фильмы по названию                        ║
                                             ║ 2. Сортировать фильмы по году выпуска                    ║
                                             ║ 3. Сортировать фильмы по режиссеру                       ║
                                             ║ 4. Выйти из меню сортировки                              ║
                                             ║                                                          ║
                                             ╚══════════════════════════════════════════════════════════╝
                                             ```
                                             
                                             Надеюсь, этот дизайн соответствует вашим ожиданиям!ear
                                3. Sort movie by producer
                                4. Exit sort bar
                                """);

                        int command = scannerNum.nextInt();

                        if (command == 4) {
                            break;
                        }

                        switch (command) {
                            case 1:
                                System.out.println("Select asc or desc?");
                                movieSortableService.sortMovieByName(scannerLn.nextLine());
                                break;
                            case 2:
                                System.out.println("Select asc or desc?");
                                movieSortableService.sortByYear(scannerLn.nextLine());
                                break;
                            case 3:
                                System.out.println("Sort by name or last name? (firstname/lastname)");
                                movieSortableService.sortByProducer(scannerLn.nextLine());
                            default:
                                System.out.println("Wrong action!");
                        }
                    }
                default:
                    System.out.println("Wrong action!");
            }
        }
    }
}
