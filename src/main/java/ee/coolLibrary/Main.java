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
        BookRepository bookRepository = new BookRepository(Book.class);
        ReviewRepository reviewRepository = new ReviewRepository(Review.class);
        Author author = new Author("saeed", "Saeed");
        authorRepository.save(author);
        Book book = new Book("Sipsik", "Childrens book",2020, "Just a test");
      book.addAuthor(author);
       Book saved = bookRepository.save(book);
        Review review = new Review(book, 5, "fdfdf");
        reviewRepository.save(review);
        book.addReview(review);
        bookRepository.save(book);

        System.out.println(saved);



        DatabaseUtil.shutdown();

    }
}
