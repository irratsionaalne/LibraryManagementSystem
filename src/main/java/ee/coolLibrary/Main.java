package ee.coolLibrary;

import ee.coolLibrary.entities.Author;
import ee.coolLibrary.repositories.AuthorRepository;
import ee.coolLibrary.repositories.DatabaseUtil;
import ee.coolLibrary.services.AuthorServiceImpl;
import ee.coolLibrary.services.contracts.AuthorService;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
DatabaseUtil.init();
        AuthorRepository authorRepository = new AuthorRepository();
        AuthorService authorService = new AuthorServiceImpl(authorRepository);
       Author saved = authorService.save(new Author("fsdfds","dawdw"));
        System.out.println(saved);
        DatabaseUtil.shutdown();
    }




}
