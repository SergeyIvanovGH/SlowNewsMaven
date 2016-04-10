package ua.com.univerpulse.model;

<<<<<<< HEAD
=======
/**
 * Created by svivanov on 28.03.16.
 */
>>>>>>> 287e58700abc6d8c58f69a7e56e090314014f39d
public class News {
    private String date;
    private String title;
    private String description;
    private String image;

    public News(String date, String title, String description, String image) {
        this.date = date;
        this.description = description;
        this.title = title;
        this.image = image;
    }

    public News() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
