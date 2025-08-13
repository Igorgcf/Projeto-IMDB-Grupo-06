import repository.DbLocal;
import service.CatalogService;

public class Main {
    public static void main(String[] args) {

        DbLocal dbLocal = new DbLocal();
        CatalogService catalogService = new CatalogService(dbLocal);
        catalogService.menu();
    }
}