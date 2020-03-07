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

public class Main {
    public static void main(String[] args) {
        DatabaseUtil.init();
        BookService bookService = ServiceBuilder.getBookService();
        AuthorService authorService = ServiceBuilder.getAuthorService();
        ReviewService reviewService = ServiceBuilder.getReviewService();
        AuthorAPI authorAPI = new AuthorAPI();

        System.out.println(authorAPI.findById("100"));
        String author = new AuthorDTO(new Author("hello", "helloooooo")).getJson();
        System.out.println(authorAPI.save(author));
        DatabaseUtil.shutdown();
    }


}
