package ee.coolLibrary;

import ee.coolLibrary.entities.Author;
import ee.coolLibrary.repositories.AuthorRepository;

public class Main {
    public static void main(String[] args) {
        DatabaseUtil.getSessionFactory();
        AuthorRepository authorRepository = new AuthorRepository(Author.class);
        Author author = new Author("saeed", "Saeed");
        authorRepository.save(author);




        DatabaseUtil.shutdown();

    }
}
