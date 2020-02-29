package ee.coolLibrary;

import ee.coolLibrary.controllers.AuthorControllerToCMD;
import ee.coolLibrary.entities.Author;
import ee.coolLibrary.repositories.AuthorRepository;
import ee.coolLibrary.services.AuthorService;

public class Main {
    public static void main(String[] args) {
        DatabaseUtil.getSessionFactory();
   AuthorRepository authorRepository = new AuthorRepository(Author.class);
        AuthorService authorService = new AuthorService(authorRepository);
        AuthorControllerToCMD authorControllerToCMD = new AuthorControllerToCMD(authorService);
        authorControllerToCMD.newAuthor();
        DatabaseUtil.shutdown();
    }




}
