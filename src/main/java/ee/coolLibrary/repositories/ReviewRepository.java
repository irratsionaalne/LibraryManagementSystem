package ee.coolLibrary.repositories;

import ee.coolLibrary.entities.Author;

public class ReviewRepository extends DAO <Author, Integer>  {
    public ReviewRepository(Class<Author> authorClass) {
        super(authorClass);
    }
}
