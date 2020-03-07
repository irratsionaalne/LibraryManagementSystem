package ee.coolLibrary;

import ee.coolLibrary.api.AuthorAPI;
import ee.coolLibrary.api.DTO.AuthorDTO;
import ee.coolLibrary.api.DTO.BookDTO;
import ee.coolLibrary.entities.Author;
import ee.coolLibrary.repositories.DatabaseUtil;
import ee.coolLibrary.services.contracts.AuthorService;
import ee.coolLibrary.services.contracts.BookService;
import ee.coolLibrary.services.contracts.ReviewService;
import ee.coolLibrary.util.ServiceBuilder;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DatabaseUtil.init();
        BookService bookService = ServiceBuilder.getBookService();
        AuthorService authorService = ServiceBuilder.getAuthorService();
        ReviewService reviewService = ServiceBuilder.getReviewService();
        AuthorAPI authorAPI = new AuthorAPI();
Author author = new Author(999, "fnme", "lname", new ArrayList<>());
        System.out.println(authorAPI.delete(new AuthorDTO(author).getJson()));
        System.out.println(authorAPI.findAll());
        Author author1 = authorService.findById(100);
        author1.setFirstName("434tthtgrd");
        author1.setLastName("#$%#$%TYTRGERTGH");
        String changedAuthor = new AuthorDTO(author1).getJson();
        System.out.println(authorAPI.update(changedAuthor));
        DatabaseUtil.shutdown();
    }


}
