package ee.coolLibrary.repositories;

import ee.coolLibrary.entities.Author;

public class AuthorRepository extends DAO<Author, Integer> {
    public AuthorRepository() {
        super(Author.class);
    }

}
