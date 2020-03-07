package ee.coolLibrary.api;


import com.google.gson.Gson;
import ee.coolLibrary.entities.Author;

import java.util.HashMap;
import java.util.Map;


public class AuthorDTO {

 private String firstName, lastName;
 private Map <Integer, String> books;

    public AuthorDTO(Author author) {
        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();
        this.books = new HashMap<>();
        author.getBooks().forEach(book -> books.put(book.getId(), book.getTitle()));
    }



    public String getJson () {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
