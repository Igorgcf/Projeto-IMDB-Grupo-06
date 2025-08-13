package service;

import models.*;
import repository.DbLocal;

import java.sql.Time;
import java.util.Scanner;

public class CatalogService {

    private DbLocal dbLocal;

    public CatalogService(DbLocal dbLocal) {
        this.dbLocal = dbLocal;
    }

    static Scanner scanner = new Scanner(System.in);

    public void menu() {

        int opcao;
        do {
            System.out.println("\n===== Catálogo de Obras Audiovisuais =====");
            System.out.println("1. Cadastrar Filme");
            System.out.println("2. Cadastrar Série");
            System.out.println("3. Atualizar Série");
            System.out.println("4. Associar Atores e Diretor (Filme)");
            System.out.println("5. Associar Atores e Diretor (Série)");
            System.out.println("6. Pesquisar Filme por Nome");
            System.out.println("7. Pesquisar Série por Nome");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> registerMovie();
                case 2 -> registerSeries();
                case 3 -> updateSeries();
                case 4 -> associateMovie();
                case 5 -> associateSeries();
                case 6 -> searchMovie();
                case 7 -> searchSeries();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void registerSeries() {
        //chamar view
        System.out.print("Nome da Série: ");
        String name = scanner.nextLine();
        System.out.print("Número de Temporadas: ");
        int seasons = Integer.parseInt(scanner.nextLine());
        System.out.print("Descrição: ");
        String description = scanner.nextLine();
        System.out.println("Orçamento");
        double budget = Double.parseDouble(scanner.nextLine());

        Series serie = new Series(name, description, seasons);
        serie.setBudget(budget);
        dbLocal.addSerie(serie);

        //chamar view System.out.println("Série " + dbLocal.getSeriesByName(serie.getName()).getName() + " cadastrada!");
    }

    private void registerMovie() {
        //chamar view
        System.out.print("Nome do filme: ");
        String name = scanner.nextLine();
        System.out.print("Descrição: ");
        String description = scanner.nextLine();
        System.out.println("Duração");
        Time duration = Time.valueOf(scanner.nextLine());

        Movie movie = new Movie(name, description, duration);
        dbLocal.addMovie(movie);

        //chamar view System.out.println("Série " + dbLocal.getSeriesByName(serie.getName()).getName() + " cadastrada!");
    }

    public void updateSeries(){
        //chamar view System.out.println("Atualização de Série");
        Series serie = selectSeries();
        //chamar view System.out.print("Novo nome (deixe em branco para não alterar): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            serie.setName(name);
        }
        //chamar view System.out.print("Nova data de lançamento (deixe em branco para não alterar): ");
        String date = scanner.nextLine();
        if (!date.isEmpty()) {
            //serie.setCreationDate(date);
        }
        //chamar view System.out.print("Número de temporadas (deixe em branco para não alterar): ");
        String seasonsInput = scanner.nextLine();
        if (!seasonsInput.isEmpty()) {
            int seasons = Integer.parseInt(seasonsInput);
            serie.setSeasons(seasons);
        }
        //chamar view System.out.print("Nova descrição (deixe em branco para não alterar): ");
        String description = scanner.nextLine();
        if (!description.isEmpty()) {
            serie.setDescription(description);
        }

        //chamar view System.out.println("Série atualizada com sucesso!");
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

    private Series selectSeries() {


        //chamar view System.out.println("Selecione uma série:");
        //this.dbLocal.getAllSeries())
        //chamar viu de seleção de serie

        //dummy
        return new Series(" ", " ");
    }

    private Movie selectMovie() {


        //chamar view System.out.println("Selecione uma série:");
        //this.dbLocal.getAllSeries())
        //chamar viu de seleção de serie

        //dummy
        return new Movie(" ", " ", new Time(2));
    }

    private void searchSeries() {
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

    private void searchMovie() {
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

    private void associateSeries() {
        if (this.dbLocal.getAllSeries().isEmpty()) {
            System.out.println("Nenhuma série cadastrada.");
            return;
        }
        Series series = selectSeries();
        associateWork(series);
    }

    private void associateMovie() {
        if (this.dbLocal.getAllMovies().isEmpty()) {
            System.out.println("Nenhuma série cadastrada.");
            return;
        }
        Movie movie = selectMovie();
        associateWork(movie);
    }

    private void associateWork(ItemCatalog work) {
        if (work.getAllDirectors().isEmpty()) {
            //chamar view System.out.println("Nenhum diretor cadastrado.");
            return;
        }
        //chamar view System.out.println("Selecione um diretor:");
        for (Director director : work.getAllDirectors()) {
            //chamar view
            //return selected
        }

        if (work.getAllActors().isEmpty()) {
            //chamar view System.out.println("Nenhum ator cadastrado.");
            return;
        }

        //chamar view System.out.println("Adicione atores (digite o número, -1 para encerrar):");
        //chamar view de adição para retornar selecionado

        //chamar view  System.out.println("Associação feita com sucesso!");
    }

}

