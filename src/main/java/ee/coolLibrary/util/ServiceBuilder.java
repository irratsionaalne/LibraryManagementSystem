package ee.coolLibrary.util;

import ee.coolLibrary.repositories.AuthorRepository;
import ee.coolLibrary.repositories.BookRepository;
import ee.coolLibrary.repositories.ReviewRepository;
import ee.coolLibrary.services.AuthorServiceImpl;
import ee.coolLibrary.services.BookServiceImpl;
import ee.coolLibrary.services.ReviewServiceImpl;
import ee.coolLibrary.services.contracts.AuthorService;
import ee.coolLibrary.services.contracts.BookService;
import ee.coolLibrary.services.contracts.ReviewService;

public class ServiceBuilder {
    private static BookService bookService;
    private static AuthorService authorService;
    private static ReviewService reviewService;

    public static BookService getBookService() {
        if (bookService == null) {
            BookRepository bookRepository = RepositoryBuilder.getBookRepository();
            bookService = new BookServiceImpl(bookRepository);
        }
        return bookService;
    }


    public static AuthorService getAuthorService() {
        if (authorService == null) {
            AuthorRepository authorRepository = RepositoryBuilder.getAuthorRepository();
            authorService = new AuthorServiceImpl(authorRepository, getBookService());
        }
        return authorService;
    }

    public static ReviewService getReviewService() {
        if (reviewService == null) {
            ReviewRepository reviewRepository = RepositoryBuilder.getReviewRepository();
            reviewService = new ReviewServiceImpl(reviewRepository);
        }
        return reviewService;
    }
}
