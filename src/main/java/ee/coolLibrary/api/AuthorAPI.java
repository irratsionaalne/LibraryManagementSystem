package ee.coolLibrary.api;

import com.google.gson.Gson;
import ee.coolLibrary.api.DTO.AuthorDTO;
import ee.coolLibrary.api.contracts.LibraryAPI;
import ee.coolLibrary.entities.Author;
import ee.coolLibrary.services.contracts.AuthorService;
import ee.coolLibrary.util.ServiceBuilder;

public class AuthorAPI implements LibraryAPI <String> {

    AuthorService authorService;

    public AuthorAPI() {
        this.authorService = ServiceBuilder.getAuthorService();
    }

    @Override
    public String save(String s) {
        Gson gson = new Gson();
      AuthorDTO authorDTO =  gson.fromJson(s, AuthorDTO.class);
      String [] flName = authorDTO.getName().split(" ");
      Author author = new Author(flName[0], flName[1]);
      authorService.save(author);
        return findById(author.getId().toString());
    }

    @Override
    public String findById(String s) {
        int id = Integer.parseInt(s);
        Author author = authorService.findById(id);
        return new AuthorDTO(author).getJson();
    }

    @Override
    public String delete(String s) {
        return null;
    }

    @Override
    public String update(String s) {
        return null;
    }

    @Override
    public String findAll() {
        return null;
    }


}
