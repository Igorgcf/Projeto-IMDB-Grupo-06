package view;

import repository.DbLocal;
import service.CatalogService;

import java.util.Scanner;

public class Menu {

    static Scanner scanner = new Scanner(System.in);

    private CatalogService catalogService;

    private DbLocal dbLocal = new DbLocal();

    public Menu() {
        this.catalogService = new CatalogService(this.dbLocal);
    }

    public void menu() {

        int opcao;
        do {
            System.out.println("\n===== Catálogo de Obras Audiovisuais =====");
            System.out.println("1. Cadastrar Filme");
            System.out.println("2. Cadastrar Série");
            System.out.println("3. Atualizar Série");
            System.out.println("4. Atualizar Filme");
            System.out.println("5. Pesquisar Filme por Nome");
            System.out.println("6. Pesquisar Série por Nome");
            System.out.println("7. Exibir todos as series");
            System.out.println("8. Exibir todos os filmes");
            System.out.println("9. Associar diretores");
            System.out.println("10. Associar atores");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> catalogService.registerMovie();
                case 2 -> catalogService.registerSeries();
                case 3 -> catalogService.updateSeries();
                case 4 -> catalogService.updateMovie();
                case 5 -> catalogService.searchMovie();
                case 6 -> catalogService.searchSeries();
                case 7 -> catalogService.showAllSeries();
                case 8 -> catalogService.showAllMovies();
                case 9 -> catalogService.associateSeries();
                case 10 -> catalogService.associateMovie();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

}
