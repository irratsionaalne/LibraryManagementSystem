package ee.coolLibrary.services;

import com.google.common.base.Strings;
import ee.coolLibrary.entities.Book;
import ee.coolLibrary.repositories.BookRepository;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BookService extends AbstractService<BookRepository, Book, Integer> {
    public BookService(BookRepository repository) {
        super(repository);
    }

    @Override
    public Book save(Book book) {
        if (Objects.isNull(book)) throw new RuntimeException("Book can't be null");
        if (Strings.isNullOrEmpty(book.getTitle())) throw new RuntimeException("Book has to have a title");
        return repository.save(book);
    }

    @Override
    public Book findById(Integer id) {
        if (Objects.isNull(id)||id<0) throw new RuntimeException("Invalid ID");
        return repository.findById(id);
    }

    @Override
    public Book delete(Book book) {
        if (Objects.isNull(book)) throw new RuntimeException("Book can't be null");
        if (Objects.isNull(book.getId())) throw new RuntimeException("Invalid ID");
        return repository.delete(book);
    }

    @Override
    public Book update(Book book) {
        if (Objects.isNull(book)) throw new RuntimeException("Book can't be null");
        if (Objects.isNull(findById(book.getId()))) throw new RuntimeException("Invalid ID");
        if (Strings.isNullOrEmpty(book.getTitle())) throw new RuntimeException("Book needs a title");
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
}
