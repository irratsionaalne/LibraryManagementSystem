package ee.coolLibrary.services;

import com.google.common.base.Strings;
import ee.coolLibrary.entities.Author;
import ee.coolLibrary.repositories.AuthorRepository;

import java.util.Objects;

public class AuthorService extends AbstractService <AuthorRepository, Author, Integer>{

    public AuthorService(AuthorRepository repository) {
        super(repository);
    }

    @Override
    public Author save(Author author) {
        if (Objects.isNull(author)) throw new RuntimeException("Author is null");
        if (Strings.isNullOrEmpty(author.getFirstName())||Strings.isNullOrEmpty(author.getLastName())) throw new RuntimeException("Last name or first name shouldn't be null!!!");

        return repository.save(author);
    }

    @Override
    public Author findById(Integer integer) {
        return null;
    }

    @Override
    public Author delete(Author entity) {
        return null;
    }

    @Override
    public Author update(Author entity) {
        return null;
    }

    @Override
    public Iterable<Author> findAll() {
        return null;
    }
}
