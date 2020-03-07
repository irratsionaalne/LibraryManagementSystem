package ee.coolLibrary;

import ee.coolLibrary.api.AuthorDTO;
import ee.coolLibrary.api.BookDTO;
import ee.coolLibrary.entities.Author;
import ee.coolLibrary.entities.Book;
import ee.coolLibrary.entities.Review;
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
        Author author = new Author("jurhov", "juurikas");
        Author author1 = new Author("tanel","lenat");
        Book book = new Book("java for idiots","education",2020,"teaching java to dumb people like myself");
        authorService.addBook(author,book);
        authorService.addBook(author1,book);
        bookService.save(book);
        authorService.save(author);
        authorService.save(author1);
        Review review = new Review(1,book,3,"shit");
        bookService.addReview(book,review);
        AuthorDTO authorDTO = new AuthorDTO(author);
        System.out.println(authorDTO.getJson());
        AuthorDTO authorDTO1 = new AuthorDTO(author1);
        System.out.println(authorDTO1.getJson());
        Book book1 = bookService.findById(book.getId());
        BookDTO bookDTO = new BookDTO(book1);
        System.out.println(bookDTO.getJson());
        DatabaseUtil.shutdown();
    }


}
