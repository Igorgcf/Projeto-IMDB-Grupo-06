package repository;

import models.*;

import java.util.ArrayList;
import java.util.List;

public class DbLocal {

    private  List<ItemCatalog> itemsCatalog = new ArrayList<>();
    private  List<Review> reviews = new ArrayList<>();
    private  List<User> users = new ArrayList<>();

    public List<Review> getAllReviews() {
        return this.reviews;
    }

    public List<ItemCatalog> getAllItemCatalog() {
        return itemsCatalog;
    }

    public List<User> geAllUsers() {
        return users;
    }

    public void addItemCatalog(ItemCatalog itemCatalog) {
        this.itemsCatalog.add(itemCatalog);
    }

    public void removeItemCatalog(ItemCatalog itemCatalog) {
        this.itemsCatalog.remove(itemCatalog);
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }
}
