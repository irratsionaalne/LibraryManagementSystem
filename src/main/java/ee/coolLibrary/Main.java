package ee.coolLibrary;

import ee.coolLibrary.api.AuthorDTO;
import ee.coolLibrary.api.BookDTO;
import ee.coolLibrary.entities.Author;
import ee.coolLibrary.entities.Book;
import ee.coolLibrary.repositories.AuthorRepository;
import ee.coolLibrary.repositories.BookRepository;
import ee.coolLibrary.repositories.DatabaseUtil;
import ee.coolLibrary.services.AuthorServiceImpl;
import ee.coolLibrary.services.BookServiceImpl;

public class Main {
    public static void main(String[] args) {
        DatabaseUtil.init();
        AuthorRepository authorRepository = new AuthorRepository();
        BookRepository bookRepository = new BookRepository();
        AuthorServiceImpl authorService = new AuthorServiceImpl(authorRepository, bookRepository);
        BookServiceImpl bookService = new BookServiceImpl(bookRepository);
        Author author = new Author("firstname", "lastname");
        Author author1 = new Author("xyz","zyx");
        AuthorDTO authorDTO = new AuthorDTO(author);
        Book book = new Book("test","testing",2000,"desc");
        author.addBook(book);
        author1.addBook(book);
        bookService.save(book);
        authorService.save(author);
        authorService.save(author1);
        System.out.println(authorDTO.getJson());
        Book book1 = bookService.findById(book.getId());
        BookDTO bookDTO1 = new BookDTO(book1);
        System.out.println(bookDTO1.getJson());
        DatabaseUtil.shutdown();
    }


}
