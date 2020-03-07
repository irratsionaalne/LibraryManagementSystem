package ee.coolLibrary.api;

import com.google.gson.Gson;
import ee.coolLibrary.entities.Book;

import java.util.HashMap;
import java.util.Map;

public class BookDTO {
    int id;
    String title;
    String genre;
    String description;
    int publishYear;
    Map<Integer, String> listOfAuthors;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.genre = book.getGenre();
        this.description = book.getDescription();
        this.publishYear = book.getPublishYear();
        this.listOfAuthors = new HashMap<>();
        book.getAuthors().forEach(author -> listOfAuthors.put(author.getId(), author.getFirstName()+ " "+ author.getLastName()));
    }

    public String getJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
