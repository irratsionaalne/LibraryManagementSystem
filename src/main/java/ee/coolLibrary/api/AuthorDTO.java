package ee.coolLibrary.api;


import com.google.gson.Gson;
import ee.coolLibrary.entities.Author;

import java.util.HashMap;
import java.util.Map;


public class AuthorDTO {

 private String name;
 private Map <Integer, String> books;

    public AuthorDTO(Author author) {
        this.name = author.getFirstName() + " " + author.getLastName();
        this.books = new HashMap<>();
        author.getBooks().forEach(book -> books.put(book.getId(), book.getTitle()));
    }



    public String getJson () {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
