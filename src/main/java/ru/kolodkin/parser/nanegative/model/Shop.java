package ru.kolodkin.parser.nanegative.model;

import java.util.ArrayList;

public class Shop {
    private String title;
    private int averageRating;
    private String link;
    private ArrayList<Feedback> feedbacks;

    public Shop(String title, int averageRating, String link, ArrayList<Feedback> feedbacks) {
        this.title = title;
        this.averageRating = averageRating;
        this.link = link;
        this.feedbacks = feedbacks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return averageRating;
    }

    public void setRating(int rating) {
        this.averageRating = rating;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ArrayList<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(ArrayList<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "title='" + title + '\'' +
                ", averageRating=" + averageRating +
                ", link='" + link + '\'' +
                ", feedbacks=" + feedbacks +
                '}';
    }
}
