package ee.coolLibrary.repositories;

import ee.coolLibrary.entities.Author;

public class BookRepository extends DAO <Author, Integer>  {
    public BookRepository(Class<Author> authorClass) {
        super(authorClass);
    }
}
