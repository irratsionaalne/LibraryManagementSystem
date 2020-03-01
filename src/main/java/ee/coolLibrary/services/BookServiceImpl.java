package ee.coolLibrary.services;

import com.google.common.base.Strings;
import ee.coolLibrary.entities.Author;
import ee.coolLibrary.entities.Book;
import ee.coolLibrary.entities.Review;
import ee.coolLibrary.repositories.BookRepository;
import ee.coolLibrary.services.contracts.BookService;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BookServiceImpl extends AbstractService<BookRepository, Book, Integer> implements BookService {
    public BookServiceImpl(BookRepository repository) {
        super(repository);
    }

    @Override
    public Book save(Book book) {
        if (Objects.isNull(book)) throw new RuntimeException("Book is null");
        if (Strings.isNullOrEmpty(book.getTitle())) throw new RuntimeException("Book needs a title");
        if (Strings.isNullOrEmpty(book.getGenre())) throw new RuntimeException("Book needs a genre");
        if (Objects.isNull(book.getPublishYear())) throw new RuntimeException("Book needs a publishing year");
        return repository.save(book);
    }

    @Override
    public Book findById(Integer id) {
        if (Objects.isNull(id) || id < 0) throw new RuntimeException("Invalid ID");
        return repository.findById(id);
    }

    @Override
    public Book delete(Book book) {
        if (Objects.isNull(book)) throw new RuntimeException("Book is null");
        if (Objects.isNull(book.getId())) throw new RuntimeException("Invalid ID");
        return repository.delete(book);
    }

    @Override
    public Book update(Book book) {
        if (Objects.isNull(book)) throw new RuntimeException("Book is null");
        if (Objects.isNull(book.getId())) throw new RuntimeException("Invalid ID");
        return repository.update(book);
    }

    @Override
    public Iterable<Book> findAll() {
        Set<Book> bookSet = new HashSet<>();
        for (Book book : repository.findAll()) {
            bookSet.add(book);
        }
        return bookSet;
    }

    @Override
    public Book addReview(Book book, Review review) {
        if (book == null || review == null) throw new IllegalArgumentException("Book or review can't be null");
        book.addReview(review);
        return repository.save(book);
    }

    @Override
    public Book deleteReview(Book book, Review review) {
        if (book == null || review == null) throw new IllegalArgumentException("Book or review can't be null");
        book.deleteReview(review);
        return repository.delete(book);
    }
}
