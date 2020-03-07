package ee.coolLibrary.services;

import ee.coolLibrary.entities.Book;
import ee.coolLibrary.entities.Review;
import ee.coolLibrary.repositories.BookRepository;
import ee.coolLibrary.repositories.ReviewRepository;
import ee.coolLibrary.services.contracts.BookService;
import ee.coolLibrary.services.contracts.ReviewService;
import ee.coolLibrary.util.RepositoryBuilder;
import ee.coolLibrary.util.ServiceBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class ReviewServiceImplTest {
    private ReviewRepository reviewRepository;
    private ReviewService reviewService;
    private BookRepository bookRepository;
    private BookService bookService;
    private Book book;
    private Review review;
    private Review review1;

    @Before
    public void init() {
        reviewRepository = RepositoryBuilder.getReviewRepository();
        reviewService = ServiceBuilder.getReviewService();
        bookRepository = RepositoryBuilder.getBookRepository();
        bookService = ServiceBuilder.getBookService();
        book = new Book("test title", "est genre", 1999, "testdesc");
        bookRepository.save(book);
        review = new Review(book, 5, "great book");
        review1 = new Review(book, 13, "shit book");
    }

    @After
    public void clear() {
        if (reviewService.findAll().contains(review))
            reviewRepository.delete(review);
        if (reviewService.findAll().contains(review1))
            reviewRepository.delete(review1);
        if (bookService.findAll().contains(book))
            bookRepository.delete(book);
    }

    @Test
    public void save() {
        Review test = reviewService.save(review);
        Review test1 = reviewService.save(review1);
        Assert.assertEquals(test, review);
        Assert.assertEquals(test1, review1);
        test = reviewService.findById(review.getId());
        test1 = reviewService.findById(review1.getId());
        Assert.assertEquals(test, review);
        Assert.assertEquals(test1, review1);
    }

    @Test
    public void findById() {
        reviewService.save(review);
        reviewService.save(review1);
        Review test = reviewService.findById(review.getId());
        Review test1 = reviewService.findById(review1.getId());
        Assert.assertEquals(test, review);
        Assert.assertEquals(test1, review1);
    }

    @Test
    public void delete() {
        reviewService.save(review);
        reviewService.save(review1);
        reviewService.delete(review);
        reviewService.delete(review1);
        Set<Review> bookSet = reviewService.findAll();
        Assert.assertFalse(bookSet.contains(review) && bookSet.contains(review1));
    }

    @Test
    public void update() {
        Review test = reviewService.save(review);
        String updatedComment = "Testname2";
        test.setComment(updatedComment);
        Review updated = reviewService.update(review);
        Assert.assertEquals(review, updated);
        Assert.assertEquals(updated.getComment(), updatedComment);
    }

    @Test
    public void findAll() {
        reviewService.save(review);
        reviewService.save(review1);
        Set<Review> bookSet = reviewService.findAll();
        Assert.assertTrue(bookSet.contains(review) && bookSet.contains(review1));
    }


}