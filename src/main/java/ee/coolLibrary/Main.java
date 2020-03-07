package ee.coolLibrary;

import ee.coolLibrary.api.AuthorDTO;
import ee.coolLibrary.entities.Author;
import ee.coolLibrary.repositories.AuthorRepository;
import ee.coolLibrary.repositories.BookRepository;
import ee.coolLibrary.repositories.DatabaseUtil;
import ee.coolLibrary.services.AuthorServiceImpl;

public class Main {
    public static void main(String[] args) {
        DatabaseUtil.init();
        AuthorRepository authorRepository = new AuthorRepository();
        BookRepository bookRepository = new BookRepository();
        AuthorServiceImpl authorService = new AuthorServiceImpl(authorRepository, bookRepository);
        Author author = new Author("firstname", "lastname");
        AuthorDTO authorDTO = new AuthorDTO();
        DatabaseUtil.shutdown();
    }


}
