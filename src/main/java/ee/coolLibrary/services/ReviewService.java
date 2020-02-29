package ee.coolLibrary.services;

import ee.coolLibrary.entities.Review;
import ee.coolLibrary.repositories.ReviewRepository;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ReviewService extends AbstractService <ReviewRepository, Review, Integer> {
    public ReviewService(ReviewRepository repository) {
        super(repository);
    }

    @Override
    public Review save(Review review) {
        if(Objects.isNull(review)) throw new RuntimeException("Review can't be null");
        return repository.save(review);
    }

    @Override
    public Review findById(Integer id) {
        if (Objects.isNull(id)||id<0) throw new RuntimeException("Invalid ID");
        return repository.findById(id);
    }

    @Override
    public Review delete(Review review) {
        if (Objects.isNull(review)) throw new RuntimeException("Review can't be null");
        if (Objects.isNull(review.getId())) throw new RuntimeException("Invalid ID");
        return repository.delete(review);
    }

    @Override
    public Review update(Review review) {
        if (Objects.isNull(review)) throw new RuntimeException("Review can't be null");
        if (Objects.isNull(findById(review.getId()))) throw new RuntimeException("Invalid ID");
        return repository.update(review);
    }

    @Override
    public Iterable<Review> findAll() {
        Set<Review> reviewSet = new HashSet<>();
        for (Review review : repository.findAll()) {
            reviewSet.add(review);
        }
        return reviewSet;
    }
}
