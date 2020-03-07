package ee.coolLibrary.api;

import com.google.gson.Gson;
import ee.coolLibrary.entities.Author;

public class AuthorDTO implements DTOContract <Author> {




    @Override
    public String get(Author entity) {
        Gson gson = new Gson();
        return gson.toJson(entity);
    }




}
