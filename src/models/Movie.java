package models;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Movie extends ItemCatalog {

    private Time duration;
    private Boolean inTheater = false;

    public Movie(String name, String description, Time duration) {
        super(name, description);
        this.duration = duration;
    }

    public Boolean isInTheater() {
        return inTheater;
    }

    public void setInTheater(Boolean inTheater) {
        this.inTheater = inTheater;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }
}
