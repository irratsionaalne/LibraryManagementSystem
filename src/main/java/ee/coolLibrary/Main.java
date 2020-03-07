package ee.coolLibrary;

import ee.coolLibrary.api.AuthorDTO;
import ee.coolLibrary.api.BookDTO;
import ee.coolLibrary.entities.Author;
import ee.coolLibrary.entities.Book;
import ee.coolLibrary.entities.Review;
import ee.coolLibrary.repositories.AuthorRepository;
import ee.coolLibrary.repositories.BookRepository;
import ee.coolLibrary.repositories.DatabaseUtil;
import ee.coolLibrary.services.AuthorServiceImpl;
import ee.coolLibrary.services.BookServiceImpl;
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

        DatabaseUtil.shutdown();
    }


}
