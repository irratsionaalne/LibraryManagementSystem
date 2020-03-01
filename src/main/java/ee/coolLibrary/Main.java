package ee.coolLibrary;

import ee.coolLibrary.entities.Author;
import ee.coolLibrary.entities.Book;
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
        AuthorService authorService = new AuthorServiceImpl(authorRepository, bookRepository);
        Author saved = authorService.save(new Author("fsdfds", "dawdw"));
        System.out.println(saved);
        DatabaseUtil.shutdown();
    }


}
