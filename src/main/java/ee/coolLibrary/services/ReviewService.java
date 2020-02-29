package ee.coolLibrary.services;

import ee.coolLibrary.entities.Review;
import ee.coolLibrary.repositories.ReviewRepository;

public class ReviewService extends AbstractService <ReviewRepository, Review, Integer> {
    public ReviewService(ReviewRepository repository) {
        super(repository);
    }

    @Override
    public Review save(Review entity) {
        return null;
    }

    @Override
    public Review findById(Integer integer) {
        return null;
    }

    @Override
    public Review delete(Review entity) {
        return null;
    }

    @Override
    public Review update(Review entity) {
        return null;
    }

    @Override
    public Iterable<Review> findAll() {
        return null;
    }
}
