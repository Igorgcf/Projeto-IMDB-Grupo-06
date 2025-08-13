package models;

import java.util.List;

public class Series extends ItemCatalog  {

  private int seasons;

    public Series(String name, String description, int seasons) {
        super(name, description);
        this.seasons = seasons;
    }

  public Series(String name, String description) {
    super(name, description);
  }

    public void setSeasons(int seasons) {
      this.seasons = seasons;
    }

    public void getSeasons(int seasons) {
      this.seasons = seasons;
    }


}
