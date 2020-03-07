package ee.coolLibrary.api.DTO;


import com.google.gson.Gson;
import ee.coolLibrary.entities.Author;

import java.util.HashMap;
import java.util.Map;


public class AuthorDTO {

    private int id;
    private String name;
    private Map<Integer, String> books;

    public AuthorDTO(Author author) {
        this.id=author.getId();
        this.name = author.getFirstName() + " " + author.getLastName();
        this.books = new HashMap<>();
        author.getBooks().forEach(book -> books.put(book.getId(), book.getTitle()));
    }


    public String getJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
