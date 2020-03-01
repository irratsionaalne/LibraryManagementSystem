package ee.coolLibrary;

import ee.coolLibrary.entities.Author;
import ee.coolLibrary.entities.Book;
import ee.coolLibrary.repositories.AuthorRepository;
import ee.coolLibrary.repositories.BookRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ee.coolLibrary.services.AuthorServiceImpl;

import java.util.Set;


public class AuthorServiceImplTest {


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private AuthorServiceImpl authorService;
    private Author author;
    private Author author1;

    @Before
    public void init() {
        authorRepository = new AuthorRepository();
        bookRepository = new BookRepository();
        authorService = new AuthorServiceImpl(authorRepository, bookRepository);
        author = new Author("test 1", "test1");
        author1 = new Author("test 2", "test2");
    }

    @After
    public void clear() {
        authorRepository.delete(author);
        authorRepository.delete(author1);
    }


    @Test
    public void testSave() {
        Author test = authorService.save(author);
        Author test1 = authorService.save(author1);
        Assert.assertEquals(test, author);
        Assert.assertEquals(test1, author1);
        test = authorService.findById(author.getId());
        test1 = authorService.findById(author1.getId());
        Assert.assertEquals(test, author);
        Assert.assertEquals(test1, author1);

    }

    @Test (expected = RuntimeException.class)
    public void tryException () {
        authorService.save(new Author("",""));
    }

    @Test
    public void testFindById() {
        authorService.save(author);
        authorService.save(author1);
        Author test = authorService.findById(author.getId());
        Author test1 = authorService.findById(author1.getId());
        Assert.assertEquals(test, author);
        Assert.assertEquals(test1, author1);
    }

    @Test
    public void testUpdate() {
        authorService.save(author);
        String updatedName = "TestUserOne";
        author.setFirstName(updatedName);
      Author updated =  authorService.update(author);
Assert.assertEquals(author, updated);
Assert.assertEquals(updated.getFirstName(), updatedName);
    }

    @Test
    public void testFindAll() {
        Author test = authorService.save(author);
        Author test1 = authorService.save(author1);
        Set<Author> authors =  authorService.findAll();
        Assert.assertTrue(authors.contains(test)&&authors.contains(test1));

    }

    @Test
    public void testAddBook() {

        authorService.save(author);
        Book book = new Book("titletest", "gengetest", 1990, "desc");
        authorService.addBook(author, book);
        Author test = authorService.findById(author.getId());
        Assert.assertTrue(test.getBooks().contains(book));
        authorService.deleteBook(author, book);

    }

    @Test
    public void testDeleteBook() {

        authorService.save(author);
        Book book = new Book("titletest", "gengetest", 1990, "desc");
        authorService.addBook(author, book);
        Author test = authorService.findById(author.getId());
        Assert.assertTrue(test.getBooks().contains(book));
       test = authorService.deleteBook(author, book);
        Assert.assertFalse(authorService.findById(test.getId()).getBooks().contains(book));
    }
}
