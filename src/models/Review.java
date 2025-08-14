package models;

import java.util.Date;
import java.util.List;

public class Review {

    private Date reviewDate;
    private String review;
    private User user;
    private double rate;

    public Review(User user, String review, double rate) {
        this.reviewDate = new Date();
        this.review = review;
        this.user = user;
        this.rate = rate;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

}
