package view;

import models.Movie;
import models.Review;
import models.Series;
import models.User;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        System.out.println("Duração em minutos");
        String duration = scanner.nextLine();
        System.out.print("Nova data de lançamento (Ex: 09-04-2025) (deixe em branco para não alterar): ");
        String inputDate = scanner.nextLine();
        Movie movie = new Movie(name, description, duration);
        if (!inputDate.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(inputDate, formatter);
            movie.setReleaseDate(date);
        }

        System.out.println("Filme " + movie.getName() + " cadastrado!");

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
        System.out.print("Nova data de lançamento (Ex: 09-04-2025) (deixe em branco para não alterar): ");
        String inputDate = scanner.nextLine();
        if (!inputDate.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(inputDate, formatter);
            registerSeries().setReleaseDate(date);
        }

        Series Series = new Series(name, description, seasons);
        Series.setBudget(budget);


        System.out.println("Série " + Series.getName() + " cadastrada!");

        return Series;
    }

}
