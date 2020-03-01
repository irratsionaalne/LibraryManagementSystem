package ee.coolLibrary.services;

import ee.coolLibrary.entities.Book;
import ee.coolLibrary.entities.Review;
import ee.coolLibrary.repositories.BookRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class BookServiceImplTest {

    private BookRepository bookRepository;
    private BookServiceImpl bookService;
    private Book book;
    private Book book1;


    @Before
    public void init() {
        bookRepository = new BookRepository();
        bookService = new BookServiceImpl(bookRepository);
        book = new Book("Test title", "Test genre", 2020, "Test description");
        book1 = new Book("Test title 1", "Test genre 1", 2020, "Test description 1");
    }

    @After
    public void clear() {
        if (bookService.findAll().contains(book))
            bookRepository.delete(book);
        if (bookService.findAll().contains(book1))
            bookRepository.delete(book1);
    }

    @Test
    public void save() {
        Book test = bookService.save(book);
        Book test1 = bookService.save(book1);
        Assert.assertEquals(test, book);
        Assert.assertEquals(test1, book1);
        test = bookService.findById(book.getId());
        test1 = bookService.findById(book1.getId());
        Assert.assertEquals(test, book);
        Assert.assertEquals(test1, book1);
    }

    @Test
    public void findById() {
        bookService.save(book);
        bookService.save(book1);
        Book test = bookService.findById(book.getId());
        Book test1 = bookService.findById(book1.getId());
        Assert.assertEquals(test, book);
        Assert.assertEquals(test1, book1);
    }

    @Test
    public void delete() {
        Set<Book> bookSet = bookService.findAll();
        bookService.save(book);
        bookService.save(book1);
        bookService.delete(book);
        bookService.delete(book1);
        Set<Book> bookSet1 = bookService.findAll();
        Assert.assertEquals(bookSet,bookSet1);
    }

    @Test
    public void update() {
        bookService.save(book);
        String updatedName = "Testname";
        book.setTitle(updatedName);
        Book updated = bookService.update(book);
        Assert.assertEquals(book,updated);
        Assert.assertEquals(updated.getTitle(),updatedName);
    }

    @Test
    public void findAll() {
        bookService.save(book);
        bookService.save(book1);
        Set<Book> bookSet = bookService.findAll();
        Assert.assertTrue(bookSet.contains(book) && bookSet.contains(book1));
    }

    @Test
    public void addReview() {
        bookService.save(book);
        Review review = new Review(book,5,"testcomment");
        bookService.addReview(book,review);
        Book test = bookService.findById(book.getId());
        Assert.assertTrue(test.getReviews().contains(review));
        bookService.deleteReview(book,review);
    }

    @Test
    public void deleteReview() {
        bookService.save(book);
        Review review = new Review(book,5,"testcomment");
        bookService.addReview(book,review);
        Book test = bookService.findById(book.getId());
        List<Review> reviews = test.getReviews();
        bookService.deleteReview(book,review);
        List<Review> reviews1 = test.getReviews();
        Assert.assertEquals(reviews,reviews1);
    }
}