package ee.coolLibrary.api;

import com.google.gson.Gson;
import ee.coolLibrary.api.DTO.AuthorDTO;
import ee.coolLibrary.api.contracts.LibraryAPI;
import ee.coolLibrary.entities.Author;
import ee.coolLibrary.services.contracts.AuthorService;
import ee.coolLibrary.services.contracts.BookService;
import ee.coolLibrary.util.ServiceBuilder;

import java.util.HashSet;
import java.util.Set;

public class AuthorAPI implements LibraryAPI<String> {

    AuthorService authorService;
    BookService bookService;

    public AuthorAPI() {
        this.authorService = ServiceBuilder.getAuthorService();
        this.bookService = ServiceBuilder.getBookService();
    }

    @Override
    public String save(String s) {
        Gson gson = new Gson();
        AuthorDTO authorDTO;
        try {
            authorDTO = gson.fromJson(s, AuthorDTO.class);
        } catch (Exception e) {
            return "wrong format";
        }
        String[] flName = authorDTO.getName().split(" ");
        if (flName.length != 2) {
            return "error: need First name and last name";
        }
        Author author = new Author(flName[0], flName[1]);
        authorService.save(author);
        return findById(author.getId().toString());
    }

    @Override
    public String findById(String s) {
        int id;
        try {
            id = Integer.parseInt(s);
        } catch (Exception e) {
            return "error: Id need to be integer";
        }
        Author author = authorService.findById(id);
        if (author == null) {
            return "author not found";
        }
        return new AuthorDTO(author).getJson();
    }

    @Override
    public String delete(String s) {
        AuthorDTO authorDTO = null;
        Gson gson = new Gson();
        try {
            authorDTO = gson.fromJson(s, AuthorDTO.class);
        } catch (Exception e) {

        }
        Author author = authorService.findById(authorDTO.getId());
        if (author == null) {
            return "author not found";
        }
        authorService.delete(author);
        return "deleted";
    }

    @Override
    public String update(String s) {
        Gson gson = new Gson();
        AuthorDTO authorDTO = null;
        try {
            authorDTO = gson.fromJson(s, AuthorDTO.class);
        } catch (Exception e) {
            return "wrong format";
        }
        Author author = authorService.findById(authorDTO.getId());
        if (author == null) {
            return "author not found";
        }
        String[] flName = authorDTO.getName().split(" ");
        if (flName.length != 2) {
            return "wrong format of name";
        }
        author.setFirstName(flName[0]);
        author.setLastName(flName[1]);
        Author saved = authorService.update(author);
        return new AuthorDTO(saved).getJson();
    }

    @Override
    public String findAll() {
        Gson gson = new Gson();
        Set<AuthorDTO> authorDTOS = new HashSet<>();
        authorService.findAll().forEach(author -> authorDTOS.add(new AuthorDTO(author)));
        return gson.toJson(authorDTOS);
    }

    public String addBookToAuthor(String authorId, String bookId) {
        int authorIdInt, bookIdInt;
        try {
            authorIdInt = Integer.parseInt(authorId);
            bookIdInt = Integer.parseInt(bookId);
        } catch (Exception e) {
            return "Wrong parameters";
        }
        authorService.addBook(authorService.findById(authorIdInt), bookService.findById(bookIdInt));
        return "added";
    }

    public String deleteBookFromAuthor(String authorId, String bookId) {
        int authorIdInt, bookIdInt;
        try {
            authorIdInt = Integer.parseInt(authorId);
            bookIdInt = Integer.parseInt(bookId);
        } catch (Exception e) {
            return "Wrong parameters";
        }
        authorService.deleteBook(authorService.findById(authorIdInt), bookService.findById(bookIdInt));
        return "deleted";
    }


}
