package models;

public class Series extends ItemCatalog  {
  private int seasons;

    public Series(String name,  String creationDate, int seasons, String description, double budget) {
        super(name, creationDate, description, budget);

    this.seasons = seasons;

    }


    public void setSeasons(int seasons) {
    }

    public void getSeasons(int seasons) {

    }


}
