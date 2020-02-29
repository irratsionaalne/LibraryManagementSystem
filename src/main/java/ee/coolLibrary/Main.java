package ee.coolLibrary;

import ee.coolLibrary.entities.Author;
import ee.coolLibrary.entities.Book;
import ee.coolLibrary.repositories.AuthorRepository;
import ee.coolLibrary.repositories.BookRepository;

public class Main {
    public static void main(String[] args) {
        DatabaseUtil.getSessionFactory();
        AuthorRepository authorRepository = new AuthorRepository(Author.class);
        Author author = new Author("saeed", "Saeed");
        authorRepository.save(author);
        Book book = new Book("Sipsik", "Childrens book",2020, "Just a test");
        BookRepository bookRepository = new BookRepository(Book.class);





        DatabaseUtil.shutdown();

    }
}
