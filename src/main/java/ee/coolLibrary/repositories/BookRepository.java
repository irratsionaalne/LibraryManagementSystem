package ee.coolLibrary.repositories;

import ee.coolLibrary.entities.Book;

public class BookRepository extends DAO <Book, Integer>  {
    public BookRepository(Class<Book> bookClass) {
        super(bookClass);
    }
}
