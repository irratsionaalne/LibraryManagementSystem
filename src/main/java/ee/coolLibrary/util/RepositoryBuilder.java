package ee.coolLibrary.util;

import ee.coolLibrary.repositories.AuthorRepository;
import ee.coolLibrary.repositories.BookRepository;
import ee.coolLibrary.repositories.ReviewRepository;

public class RepositoryBuilder {
    private static BookRepository bookRepository;
    private static ReviewRepository reviewRepository;
    private static AuthorRepository authorRepository;

    public static BookRepository getBookRepository () {
        if (bookRepository==null) {
            bookRepository=new BookRepository();
        }
        return bookRepository;
    }

    public static ReviewRepository getReviewRepository () {
        if (reviewRepository==null) {
            reviewRepository=new ReviewRepository();
        }
        return reviewRepository;
    }


    public static AuthorRepository getAuthorRepository () {
        if (authorRepository==null) {
            authorRepository=new AuthorRepository();
        }
        return authorRepository;
    }
}
