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
    private Register register;
    private Update update;
    private Select select;

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


    public void findAllSeries() {

        if (this.dbLocal.getAllSeries().isEmpty()) {
            //chamar view System.out.println("Nenhuma série cadastrada.");
            return;
        }
        //chamar view System.out.println("Séries cadastradas:");
        for (Series serie : this.dbLocal.getAllSeries()) {
            //chamar view
            //return selected
        }

    }

    public void searchSeries() {
        //chamar view System.out.print("Digite o nome da série: ");
        String name = scanner.nextLine();
        if (this.dbLocal.getAllSeries().isEmpty()) {
            //chamar view System.out.println("Nenhuma série cadastrada.");
            return;
        }
        for (Series serie : this.dbLocal.getAllSeries()) {
            if (serie.getName().contains(name)) {
                //chamar view
                //return selected
            }
        }
        //chamar view System.out.println("Nenhuma série encontrada.");

    }

    public void searchMovie() {
        //chamar view System.out.print("Digite o nome do filme: ");
        String name = scanner.nextLine();
        if (this.dbLocal.getAllMovies().isEmpty()) {
            //chamar view System.out.println("Nenhum filme cadastrado.");
            return;
        }
        for (Movie movie : this.dbLocal.getAllMovies()) {
            if (movie.getName().contains(name)) {
                //chamar view
                //return selected
            }
        }
        //chamar view System.out.println("Nenhuma série encontrada.");

    }

    public void associateSeries() {
        if (this.dbLocal.getAllSeries().isEmpty()) {
            System.out.println("Nenhuma série cadastrada.");
            return;
        }
        Series series = select.selectSeries(this.dbLocal.getAllSeries());
        associateWork(series);
    }

    public void associateMovie() {
        if (this.dbLocal.getAllMovies().isEmpty()) {
            System.out.println("Nenhuma série cadastrada.");
            return;
        }
        Movie movie = select.selectMovie(this.dbLocal.getAllMovies());
        associateWork(movie);
    }

    public void associateWork(ItemCatalog work) {

    }

}

