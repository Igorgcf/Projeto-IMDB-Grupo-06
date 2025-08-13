package view;

import models.Movie;
import models.Review;
import models.Series;
import models.User;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Update{

static Scanner scanner = new Scanner(System.in);

    public void updateUser () {


    }

    public void updateReview() {


    }

    public void updateMovie(){



    }

    public void updateSeries(Series series) {

        System.out.println("Atualização de Série");

        System.out.print("Novo nome (deixe em branco para não alterar): ");
        String name = scanner.nextLine();

        if (!name.isEmpty()) {
            series.setName(name);
        }

        System.out.print("Nova data de lançamento (Ex: 09-04-2025) (deixe em branco para não alterar): ");
        String inputDate = scanner.nextLine();
        if (!inputDate.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(inputDate, formatter);
            series.setReleaseDate(date);
        }

        System.out.print("Número de temporadas (deixe em branco para não alterar): ");
        String seasonsInput = scanner.nextLine();
        if (!seasonsInput.isEmpty()) {
            int seasons = Integer.parseInt(seasonsInput);
            series.setSeasons(seasons);
        }

        System.out.print("Nova descrição (deixe em branco para não alterar): ");
        String description = scanner.nextLine();
        if (!description.isEmpty()) {
            series.setDescription(description);
        }

        System.out.println("Série atualizada com sucesso!");
    }

}
