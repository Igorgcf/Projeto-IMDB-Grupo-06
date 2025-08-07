package service;

import models.Actor;
import models.ItemCatalog;
import models.Series;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogService {

    private static List<Series> series = new ArrayList<>();
    private static List<Actor> actors = new ArrayList<>();
    private static List<Director> directors = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    public void menu() {

        int opcao;
        do {
            System.out.println("\n===== Catálogo de Obras Audiovisuais =====");
            System.out.println("1. Cadastrar Filme");
            System.out.println("2. Cadastrar Série");
            System.out.println("3. Cadastrar Ator");
            System.out.println("4. Cadastrar Diretor");
            System.out.println("5. Associar Atores e Diretor (Filme)");
            System.out.println("6. Associar Atores e Diretor (Série)");
            System.out.println("7. Pesquisar Filme por Nome");
            System.out.println("8. Pesquisar Série por Nome");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> registerMovie();
                case 2 -> registerSeries();
                case 3 -> updateSeries();
                case 4 -> registerActor();
                case 5 -> registerDirector();
                case 6 -> associateMovie();
                case 7 -> associateSeries();
                case 8 -> searchMovie();
                case 9 -> searchSeries();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void registerSeries() {
        System.out.print("Nome da Série: ");
        String name = scanner.nextLine();
        System.out.print("Data de Lançamento: ");
        String date = scanner.nextLine();
        System.out.print("Número de Temporadas: ");
        int seasons = Integer.parseInt(scanner.nextLine());
        System.out.print("Descrição: ");
        String description = scanner.nextLine();

        series.add(new Series(name, date, seasons, description));
        System.out.println("Série cadastrada!");
    }

    public static void updateSeries(){
        System.out.println("Atualização de Série");
        Series serie = selectSeries();
        System.out.print("Novo nome (deixe em branco para não alterar): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            serie.setName(name);
        }
        System.out.print("Nova data de lançamento (deixe em branco para não alterar): ");
        String date = scanner.nextLine();
        if (!date.isEmpty()) {
            serie.setReleaseDate(date);
        }
        System.out.print("Número de temporadas (deixe em branco para não alterar): ");
        String seasonsInput = scanner.nextLine();
        if (!seasonsInput.isEmpty()) {
            int seasons = Integer.parseInt(seasonsInput);
            serie.setSeasons(seasons);
        }
        System.out.print("Nova descrição (deixe em branco para não alterar): ");
        String description = scanner.nextLine();
        if (!description.isEmpty()) {
            serie.setDescription(description);
        }

        System.out.println("Série atualizada com sucesso!");
    }

    public void findAllSeries() {
        if (series.isEmpty()) {
            System.out.println("Nenhuma série cadastrada.");
            return;
        }
        System.out.println("Séries cadastradas:");
        for (Series serie : series) {
            serie.viewBase();
        }
    }

    private static Series selectSeries() {
        System.out.println("Selecione uma série:");
        for (int i = 0; i < series.size(); i++) {
            System.out.println(i + " - " + series.get(i).getName());
        }
        int idx = Integer.parseInt(scanner.nextLine());
        return series.get(idx);
    }

    private static void searchSeries() {
        System.out.print("Digite o nome da série: ");
        String term = scanner.nextLine();
        boolean encontrado = false;
        for (Series serie : series) {
            if (serie.nameContains(term)) {
                serie.viewBase();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhuma série encontrada com esse nome.");
        }
    }

    private static void associateSeries() {
        if (series.isEmpty()) {
            System.out.println("Nenhuma série cadastrada.");
            return;
        }
        Series series = selectSeries();
        associateWork(series);
    }

    private static void associateWork
            (ItemCatalog work) {
        if (directors.isEmpty()) {
            System.out.println("Nenhum diretor cadastrado.");
            return;
        }
        System.out.println("Selecione um diretor:");
        for (int i = 0; i < directors.size(); i++) {
            System.out.println(i + " - " + directors.get(i).getName());
        }
        int idxDiretor = Integer.parseInt(scanner.nextLine());
        work.setDirector(directors.get(idxDiretor));

        if (actors.isEmpty()) {
            System.out.println("Nenhum ator cadastrado.");
            return;
        }
        System.out.println("Adicione atores (digite o número, -1 para encerrar):");
        for (int i = 0; i < actors.size(); i++) {
            System.out.println(i + " - " + actors.get(i).getName());
        }
        int idxAtor;
        while ((idxAtor = Integer.parseInt(scanner.nextLine())) != -1) {
            if (idxAtor >= 0 && idxAtor < actors.size()) {
                work.addActor(actors.get(idxAtor));
            } else {
                System.out.println("Índice inválido.");
            }
        }

        System.out.println("Associação feita com sucesso!");
    }

    private static void registerActor() {
        System.out.println();
        System.out.print("Nome do Ator: ");
        String name = scanner.nextLine();
        System.out.print("Data de Nascimento: ");
        String date = scanner.nextLine();

        actors.add(new Actor(name, date));
        System.out.println("Ator cadastrado!");
    }

    private static void registerDirector() {
        System.out.println();
        System.out.print("Nome do Diretor: ");
        String name = scanner.nextLine();
        System.out.print("Data de Nascimento: ");
        String date = scanner.nextLine();

        directors.add(new Director(name, date));
        System.out.println("Diretor cadastrado!");
    }
}

