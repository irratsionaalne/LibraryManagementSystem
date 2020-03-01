package ee.coolLibrary.services.contracts;

import ee.coolLibrary.entities.Author;
import ee.coolLibrary.entities.Book;

public interface AuthorService extends SimpleService<Author, Integer> {
     Author deleteBook (Author author, Book book);
     Author addBook (Author author, Book book);
}
