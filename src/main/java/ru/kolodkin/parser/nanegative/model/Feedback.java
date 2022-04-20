package ru.kolodkin.parser.nanegative.model;

public class Feedback {
    private String name;
    private String pro;
    private String contra;
    private String reviewBody;

    public Feedback(String name, String pro, String contra, String reviewBody) {
        this.name = name;
        this.pro = pro;
        this.contra = contra;
        this.reviewBody = reviewBody;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getReviewBody() {
        return reviewBody;
    }

    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
    }


    @Override
    public String toString() {
        return "Feedback{" +
                "name='" + name + '\'' +
                ", pro='" + pro + '\'' +
                ", contra='" + contra + '\'' +
                ", reviewBody='" + reviewBody + '\'' +
                '}' + "\n\n";
    }
}
