package ee.coolLibrary.services;

import ee.coolLibrary.entities.Book;
import ee.coolLibrary.repositories.BookRepository;
import ee.coolLibrary.services.contracts.BookService;

public class BookServiceImpl extends AbstractService<BookRepository, Book, Integer> implements BookService {
    public BookServiceImpl(BookRepository repository) {
        super(repository);
    }

    @Override
    public Book save(Book entity) {
        return null;
    }

    @Override
    public Book findById(Integer integer) {
        return null;
    }

    @Override
    public Book delete(Book entity) {
        return null;
    }

    @Override
    public Book update(Book entity) {
        return null;
    }

    @Override
    public Iterable<Book> findAll() {
        return null;
    }
}
