package ee.coolLibrary.api.DTO;

import com.google.gson.Gson;
import ee.coolLibrary.entities.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDTO {
    int id;
    String title;
    String genre;
    String description;
    int publishYear;
    Map<Integer, String> listOfAuthors;
    List<ReviewDTO> reviews;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.genre = book.getGenre();
        this.description = book.getDescription();
        this.publishYear = book.getPublishYear();
        this.listOfAuthors = new HashMap<>();
        book.getAuthors().forEach(author -> listOfAuthors.put(author.getId(), author.getFirstName() + " " + author.getLastName()));
        this.reviews = new ArrayList<>();
        book.getReviews().forEach(review -> reviews.add(new ReviewDTO(review)));

    }

    public String getJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public Map<Integer, String> getListOfAuthors() {
        return listOfAuthors;
    }

    public List<ReviewDTO> getReviews() {
        return reviews;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }
}
