package models;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public abstract class ItemCatalog {

    private String name;
    private LocalDate releaseDate;
    private String description;
    private double budget;
    private double collected;
    private List<Actor> actors = new ArrayList<>();
    private List<Director> directors = new ArrayList<>();
    private double rating;

    public ItemCatalog(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ItemCatalog(String name, String description, LocalDate releaseDate) {
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public void viewBase() {
        System.out.println("Nome: " + name);
        System.out.println("Data de Lançamento: " + releaseDate.toString());
        System.out.println("Descrição: " + description);
        System.out.println("Orçamento: R$ " + budget);
        System.out.println("Atores:");
        for (Actor actor : actors) {
            System.out.println(" - " + actor.getName());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getCollected() {
        return collected;
    }

    public void setCollected(double collected) {
        this.collected = collected;
    }

    public List<Actor> getAllActors() {
        return actors;
    }

    public List<Director> getAllDirectors() {
        return directors;
    }

    public Actor getActorByDocument(String actorDocument) {
        return (Actor) actors.stream().filter(actor -> Objects.equals(actor.getDocument(), actorDocument)).findFirst().orElse(null);
    }

    public Director getDirectorByDocument(String directorDocument) {
        return (Director) directors.stream().filter(director -> Objects.equals(director.getDocument(), directorDocument)).findFirst().orElse(null);
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public void addDirector(Director director) {
        directors.add(director);
    }

    public void removeActor(Director director) {
        directors.remove(director);
    }

    public void removeActor(String directorDocument) {
        actors.removeIf(actor -> Objects.equals(actor.getDocument(), directorDocument));
    }

    public void removeDirector(Director director) {
        directors.remove(director);
    }

    public void removeDirector(String directorDocument) {
        actors.removeIf(actor -> Objects.equals(actor.getDocument(), directorDocument));
    }


}
