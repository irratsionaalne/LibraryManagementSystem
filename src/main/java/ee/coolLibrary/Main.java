package ee.coolLibrary;

import ee.coolLibrary.repositories.AuthorRepository;
import ee.coolLibrary.repositories.BookRepository;
import ee.coolLibrary.repositories.DatabaseUtil;
import ee.coolLibrary.services.AuthorServiceImpl;
import ee.coolLibrary.services.contracts.AuthorService;

public class Main {
    public static void main(String[] args) {
        DatabaseUtil.init();
        AuthorRepository authorRepository = new AuthorRepository();
        BookRepository bookRepository = new BookRepository();
        AuthorServiceImpl authorService = new AuthorServiceImpl(authorRepository, bookRepository);
        DatabaseUtil.shutdown();
    }


}
