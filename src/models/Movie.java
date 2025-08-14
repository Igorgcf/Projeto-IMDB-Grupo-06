package models;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Movie extends ItemCatalog {

    private String duration;
    private Boolean inTheater = false;

    public Movie(String name, String description, String duration) {
        super(name, description);
        this.duration = duration;
    }

    public Boolean isInTheater() {
        return inTheater;
    }

    public void setInTheater(Boolean inTheater) {
        this.inTheater = inTheater;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
