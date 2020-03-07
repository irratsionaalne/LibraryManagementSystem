package ee.coolLibrary.api;


import com.google.gson.Gson;
import ee.coolLibrary.entities.Author;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AuthorDTO {

 private String firstName, lastName;

    public AuthorDTO(Author author) {
        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();
    }

    public String getJson () {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
