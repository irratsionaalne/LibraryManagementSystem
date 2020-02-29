package ee.coolLibrary;

import ee.coolLibrary.entities.Author;
import ee.coolLibrary.entities.Book;
import ee.coolLibrary.entities.Review;
import ee.coolLibrary.repositories.AuthorRepository;
import ee.coolLibrary.repositories.BookRepository;
import ee.coolLibrary.repositories.ReviewRepository;

public class Main {
    public static void main(String[] args) {
        DatabaseUtil.getSessionFactory();
        AuthorRepository authorRepository = new AuthorRepository(Author.class);
        Author author = new Author("saeed", "Saeed");
        Book book = new Book("Sipsik", "Childrens book",2020, "Just a test");
        BookRepository bookRepository = new BookRepository(Book.class);
        bookRepository.save(book);
        ReviewRepository reviewRepository = new ReviewRepository(Review.class);
        Review review = new Review(book,5,"It was good");
        book.addReview(review);
        reviewRepository.save(review);

        DatabaseUtil.shutdown();

    }
}
