package ee.coolLibrary.services;

import ee.coolLibrary.entities.Author;
import ee.coolLibrary.entities.Book;
import ee.coolLibrary.entities.Review;
import ee.coolLibrary.repositories.ReviewRepository;
import ee.coolLibrary.services.contracts.ReviewService;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ReviewServiceImpl extends AbstractService<ReviewRepository, Review, Integer> implements ReviewService {


    public ReviewServiceImpl(ReviewRepository repository) {
        super(repository);
    }

    @Override
    public Review save(Review entity) {

        if (Objects.isNull(entity)) throw new RuntimeException("Review is null");

        return repository.save(entity);
    }

    @Override
    public Review findById(Integer integer) {

        if (Objects.isNull(integer) || integer < 0) throw new RuntimeException("Invalid ID");
        return repository.findById(integer);
    }

    @Override
    public Review delete(Review entity) {

        if (Objects.isNull(entity)) throw new RuntimeException("Review is delete");
        if (Objects.isNull(entity.getId())) throw new RuntimeException("Review is not delete");
        return repository.delete(entity);
    }

    @Override
    public Review update(Review entity) {
        if (Objects.isNull(entity)) throw new RuntimeException("Review is update");
        if (Objects.isNull(entity.getId())) throw new RuntimeException("Review in not update");
        return repository.update(entity);
    }


    public Set<Review> findAllByAuthor(Author author) {
        List<Book> books = author.getBooks();
        Set<Review> reviews = new HashSet<>();
        for (Book book : books) {
            reviews.addAll(book.getReviews());
        }
        return reviews;
    }

    public Set<Review> findByBook(Book book) {
        return findAll().stream().filter(review -> book.getReviews().contains(review)).collect(Collectors.toSet());
    }

    @Override
    public Set<Review> findAll() {
        Set<Review> entitySet = new HashSet<>();
        for (Review entity : repository.findAll()) {
            entitySet.add(entity);
        }
        return entitySet;
    }


}
