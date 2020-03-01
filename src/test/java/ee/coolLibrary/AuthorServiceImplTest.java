package ee.coolLibrary;

import ee.coolLibrary.entities.Author;
import ee.coolLibrary.repositories.AuthorRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ee.coolLibrary.services.AuthorServiceImpl;


public class AuthorServiceImplTest {


    private AuthorRepository authorRepository;
    private AuthorServiceImpl authorService;
    private Author author;
    private Author author1;

    @Before
    public void init() {
        authorRepository = new AuthorRepository();
        authorService = new AuthorServiceImpl(authorRepository);
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

    @Test
    public void testFindById() {
        authorService.save(author);
        authorService.save(author1);
        Author test = authorService.findById(author.getId());
        Author test1 = authorService.findById(author1.getId());
        Assert.assertEquals(test, author);
        Assert.assertEquals(test1, author1);
    }

    public void testUpdate() {

    }

    public void testFindAll() {
    }

    public void testAddBook() {
    }

    public void testDeleteBook() {
    }
}
