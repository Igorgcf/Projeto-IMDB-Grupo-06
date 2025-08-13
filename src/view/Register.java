package view;

import models.Movie;
import models.Review;
import models.Series;
import models.User;

import java.sql.Time;
import java.util.Scanner;

public class Register {

    static Scanner scanner = new Scanner(System.in);

    /*
    public User registerUser () {


    }

    public Review registerReview() {


    }
    */
    public Movie registerMovie(){

        System.out.print("Nome do filme: ");
        String name = scanner.nextLine();
        System.out.print("Descrição: ");
        String description = scanner.nextLine();
        System.out.println("Duração");
        Time duration = Time.valueOf(scanner.nextLine());

        Movie movie = new Movie(name, description, duration);

        System.out.println("Série " + movie.getName() + " cadastrada!");

        return movie;
    }

    public Series registerSeries() {

        System.out.print("Nome da Série: ");
        String name = scanner.nextLine();
        System.out.print("Número de Temporadas: ");
        int seasons = Integer.parseInt(scanner.nextLine());
        System.out.print("Descrição: ");
        String description = scanner.nextLine();
        System.out.println("Orçamento");
        double budget = Double.parseDouble(scanner.nextLine());

        Series Series = new Series(name, description, seasons);
        Series.setBudget(budget);

        System.out.println("Série " + Series.getName() + " cadastrada!");

        return Series;
    }

}
