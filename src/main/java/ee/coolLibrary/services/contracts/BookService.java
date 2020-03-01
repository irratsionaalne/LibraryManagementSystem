package ee.coolLibrary.services.contracts;

import ee.coolLibrary.entities.Book;
import ee.coolLibrary.entities.Review;

public interface BookService extends SimpleService<Book, Integer> {
    Book addReview (Book book, Review review);
    Book deleteReview (Book book, Review review);
}
