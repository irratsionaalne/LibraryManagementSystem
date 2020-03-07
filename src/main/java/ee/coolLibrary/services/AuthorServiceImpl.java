package ee.coolLibrary.services;

import ee.coolLibrary.entities.Author;
import ee.coolLibrary.entities.Book;
import ee.coolLibrary.repositories.AuthorRepository;
import ee.coolLibrary.repositories.BookRepository;
import ee.coolLibrary.services.contracts.AuthorService;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static ee.coolLibrary.util.Strings.isNullOrEmpty;

public class AuthorServiceImpl extends AbstractService<AuthorRepository, Author, Integer> implements AuthorService {

BookRepository bookRepository;


    public AuthorServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {

        super(authorRepository);
        this.bookRepository=bookRepository;
    }

    @Override
    public Author save(Author author) {
        if (Objects.isNull(author)) throw new RuntimeException("Author is null");
        if (isNullOrEmpty(author.getFirstName()) || isNullOrEmpty(author.getLastName()))
            throw new RuntimeException("Last name or first name shouldn't be null!!!");
        return repository.save(author);
    }

    @Override
    public Author findById(Integer id) {
        if (Objects.isNull(id) || id < 0) throw new RuntimeException("ID can't be null");
        return repository.findById(id);
    }

    @Override
    public Author delete(Author author) {
        if (Objects.isNull(author)) throw new RuntimeException("Author can't be null");
        if (Objects.isNull(findById(author.getId()))) throw new RuntimeException("Author not found");
        return repository.delete(author);
    }

    @Override
    public Author update(Author author) {
        if (Objects.isNull(author)) throw new RuntimeException("Author can't be null");
        if (Objects.isNull(findById(author.getId()))) throw new RuntimeException("Author not found");
        if (isNullOrEmpty(author.getFirstName()) || isNullOrEmpty(author.getLastName()))
            throw new RuntimeException("Names can't be null");
        return repository.update(author);
    }

    @Override
    public Set<Author> findAll() {
        Set<Author> authorSet = new HashSet<>();
        for (Author author : repository.findAll()) {
            authorSet.add(author);
        }
        return authorSet;
    }

    @Override
    public Author addBook(Author author, Book book) {
        if (author == null || book == null) throw new IllegalArgumentException("book or author is null");
        if (bookRepository.findById(book.getId())==null)  bookRepository.save(book);
        author.addBook(book);
        book.addAuthor(author);
        return save(author);
    }

    @Override
    public Author deleteBook(Author author, Book book) {
        if (author == null || book == null) throw new IllegalArgumentException("book or author is null");
        author.removeBook(book);
        return save(author);
    }
}
