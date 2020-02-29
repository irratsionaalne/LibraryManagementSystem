package ee.coolLibrary.services;

import com.google.common.base.Strings;
import ee.coolLibrary.entities.Author;
import ee.coolLibrary.repositories.AuthorRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AuthorService extends AbstractService<AuthorRepository, Author, Integer> {

    public AuthorService(AuthorRepository repository) {
        super(repository);
    }

    @Override
    public Author save(Author author) {
        if (Objects.isNull(author)) throw new RuntimeException("Author is null");
        if (Strings.isNullOrEmpty(author.getFirstName()) || Strings.isNullOrEmpty(author.getLastName()))
            throw new RuntimeException("Last name or first name shouldn't be null!!!");
        return repository.save(author);
    }

    @Override
    public Author findById(Integer id) {
        if (Objects.isNull(id)||id<0) throw new RuntimeException("ID can't be null");
        return repository.findById(id);
    }

    @Override
    public Author delete(Author author) {
        if (Objects.isNull(author)) throw new RuntimeException("Author can't be null");
        if (Objects.isNull(findById(author.getId()))) throw  new RuntimeException("Author not found");
        return repository.delete(author);
    }

    @Override
    public Author update(Author author) {
        if (Objects.isNull(author)) throw new RuntimeException("Author can't be null");
        if (Objects.isNull(findById(author.getId()))) throw  new RuntimeException("Author not found");
        if (Strings.isNullOrEmpty(author.getFirstName()) || Strings.isNullOrEmpty(author.getLastName()))
            throw new RuntimeException("Names can't be null");
        return repository.update(author);
    }

    @Override
    public Iterable<Author> findAll() {
        Set<Author> authorSet = new HashSet<>();
        for (Author author : repository.findAll()) {
            authorSet.add(author);
        }
        return authorSet;
    }
}