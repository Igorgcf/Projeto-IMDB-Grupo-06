package service;

import models.*;
import repository.DbLocal;
import view.Register;
import view.Select;
import view.Update;

import java.sql.Time;
import java.util.Scanner;

public class CatalogService {

    private DbLocal dbLocal;
    private Register register = new Register();
    private Update update =  new Update();
    private Select select =  new Select();

    public CatalogService(DbLocal dbLocal) {
        this.dbLocal = dbLocal;
    }

    static Scanner scanner = new Scanner(System.in);

    public void registerSeries() {

        dbLocal.addSerie(this.register.registerSeries());

    }

    public void registerMovie() {

        dbLocal.addMovie(this.register.registerMovie());

    }

    public void updateSeries(){

        Series series = select.selectSeries(this.dbLocal.getAllSeries());
        if (series != null) {
            update.updateSeries(series);
        }

    }

    public void updateMovie(){

        Movie movie = select.selectMovie(this.dbLocal.getAllMovies());
        if (movie != null) {
            update.updateMovie(movie);
        }

    }


    public void showAllSeries() {

        if (this.dbLocal.getAllSeries().isEmpty()) {
            System.out.println("Nenhuma série cadastrada.");
            return;
        }
        System.out.println("Séries cadastradas:");
        for (Series serie : this.dbLocal.getAllSeries()) {
            System.out.println(serie.getName());
        }

    }

    public void showAllMovies() {

        if (this.dbLocal.getAllMovies().isEmpty()) {
            System.out.println("Nenhum filme cadastrada.");
            return;
        }
        System.out.println("Filmes cadastradas:");
        for (Movie movie : this.dbLocal.getAllMovies()) {
            System.out.println(movie.getName());
        }

    }

    public void searchSeries() {
        System.out.print("Digite o nome da série: ");
        String name = scanner.nextLine();
        if (this.dbLocal.getAllSeries().isEmpty()) {
            System.out.println("Nenhuma série cadastrada.");
            return;
        }
        for (Series serie : this.dbLocal.getAllSeries()) {
            if (serie.getName().contains(name)) {
                System.out.println(serie.getName());
                return;
            }
        }
        System.out.println("Nenhuma série encontrada.");
    }

    public void searchMovie() {
        System.out.print("Digite o nome do filme: ");
        String name = scanner.nextLine();
        if (this.dbLocal.getAllMovies().isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }
        for (Movie movie : this.dbLocal.getAllMovies()) {
            if (movie.getName().contains(name)) {
                System.out.println(movie.getName());
                return;
            }
        }
        System.out.println("Nenhuma série encontrada.");

    }

    public void associateSeriesDirector() {
        Series series = select.selectSeries(this.dbLocal.getAllSeries());
        if (series == null) {
            return;
        }
        associateWorkSeriesDirector(series);
    }

    public void associateMovieDirector() {
        Movie movie = select.selectMovie(this.dbLocal.getAllMovies());
        if (movie == null) {
            return;
        }
        associateWorkSeriesDirector(movie);
    }

    public void associateSeriesActor() {
        Series series = select.selectSeries(this.dbLocal.getAllSeries());
        if (series == null) {
            return;
        }
        associateWorkMovieActor(series);
    }

    public void associateMovieActor() {
        Movie movie = select.selectMovie(this.dbLocal.getAllMovies());
        if (movie == null) {
            return;
        }
        associateWorkMovieActor(movie);
    }

    public void associateWorkSeriesDirector(ItemCatalog work) {

        if (work.getAllDirectors().isEmpty()) {
            System.out.println("Nenhum diretor cadastrado.");
            return;
        }
        System.out.println("Adicione um direto (digite o número, -1 para encerrar):");
        for (int i = 0; i < work.getAllDirectors().size(); i++) {
            System.out.println(i + " - " + work.getAllDirectors().get(i).getName());
        }

        int idxDire;

        while ((idxDire = Integer.parseInt(scanner.nextLine())) != -1) {

            if (idxDire >= 0 && idxDire < work.getAllDirectors().size()) {
                work.addDirector(work.getAllDirectors().get(idxDire));
            } else {
                System.out.println("Índice inválido.");
            }
        }

    }

    public void associateWorkMovieActor(ItemCatalog work) {

        if (work.getAllActors().isEmpty()) {
            System.out.println("Nenhum ator cadastrado.");
            return;
        }
        System.out.println("Adicione atores (digite o número, -1 para encerrar):");
        for (int i = 0; i < work.getAllActors().size(); i++) {
            System.out.println(i + " - " + work.getAllActors().get(i).getName());
        }

        int idxAtor;

        while ((idxAtor = Integer.parseInt(scanner.nextLine())) != -1) {

            if (idxAtor >= 0 && idxAtor < work.getAllActors().size()) {
                work.addActor(work.getAllActors().get(idxAtor));
            } else {
                System.out.println("Índice inválido.");
            }
        }
        System.out.println("Associação feita com sucesso!");
    }


}

