package ee.coolLibrary.services;

import ee.coolLibrary.entities.Review;
import ee.coolLibrary.repositories.ReviewRepository;
import ee.coolLibrary.services.contracts.ReviewService;

public class ReviewServiceImpl extends AbstractService <ReviewRepository, Review, Integer> implements ReviewService {
    public ReviewServiceImpl(ReviewRepository repository) {
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
