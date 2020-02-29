package ee.coolLibrary.services;

import ee.coolLibrary.entities.Book;
import ee.coolLibrary.repositories.BookRepository;

public class BookService extends AbstractService<BookRepository, Book, Integer> {
    public BookService(BookRepository repository) {
        super(repository);
    }

    @Override
    public String save(Book entity) {
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
