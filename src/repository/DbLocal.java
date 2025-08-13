package repository;

import models.*;

import java.util.ArrayList;
import java.util.List;

public class DbLocal {

    private  List<ItemCatalog> itemsCatalog = new ArrayList<>();
    private  List<Movie> movies = new ArrayList<>();
    private  List<Series> series = new ArrayList<>();
    private  List<Review> reviews = new ArrayList<>();
    private  List<User> users = new ArrayList<>();

    public List<ItemCatalog> getAllItemsCatalog() {
        return this.itemsCatalog;
    }

    public List<Review> getAllReviews() {
        return this.reviews;
    }

    public List<Movie> getAllMovies() {
        return this.movies;
    }

    public List<Series> getAllSeries() {
        return this.series;
    }

    public List<User> geAllUsers() {
        return users;
    }

    public Review getReview(User user) {
        return this.reviews.stream().filter(u -> u.getUser().equals(user)).findFirst().orElse(null);
    }

    public Series getSeriesByName(String name) {
        return this.series.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }

    public Movie getIMoviesByName(String name) {
        return this.movies.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }

    public User getUser(String document) {
        return this.users.stream().filter(s -> s.getDocument().equals(document)).findFirst().orElse(null);
    }

    public void addSerie(Series series) {
        if (this.series.stream().filter(s -> s.getName().equals(series.getName())).findFirst().orElse(null) != null){
            //avisa que ja existee
        }else {
            this.series.add(series);
            this.itemsCatalog.add(series);
        }
    }

    public void removeSerie(Series series) {
        this.series.remove(series);
        this.itemsCatalog.remove(series);
    }

    public void addMovie(Movie movie) {
        if (this.movies.stream().filter(s -> s.getName().equals(movie.getName())).findFirst().orElse(null) != null){
            //avisa que ja existee
        }else {
            this.movies.add(movie);
            this.itemsCatalog.add(movie);
        }
    }

    public void removeMovie(Movie movie) {
        this.movies.remove(movie);
        this.itemsCatalog.remove(movie);
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    public void addUser(User user) {
        if (this.users.stream().filter(s -> s.getName().equals(user.getName())).findFirst().orElse(null) != null){
            //avisa que ja existee
        }else {
            this.users.add(user);
        }
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }
}
