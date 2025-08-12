package models;

import java.util.ArrayList;
import java.util.List;

public abstract class ItemCatalog {

    private String name;
    private String creationDate;
    private String description;
    private double budget;

    private List<Actor> actors =  new ArrayList<>();

    public ItemCatalog(String name, String creationDate, String description, double budget) {
        this.name = name;
        this.creationDate = creationDate;
        this.description = description;
        this.budget = budget;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public void viewBase() {
        System.out.println("Nome: " + name);
        System.out.println("Data de Lançamento: " + creationDate);
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

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
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

    public List<Actor> getActors() {
        return actors;
    }

    public void setDirector(Director director) {
    }

    public boolean nameContains(String term) {
        return name.toLowerCase().contains(term.toLowerCase());
    }

}
