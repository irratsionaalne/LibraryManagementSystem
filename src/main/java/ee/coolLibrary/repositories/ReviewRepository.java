package ee.coolLibrary.repositories;

import ee.coolLibrary.entities.Review;

public class ReviewRepository extends DAO<Review, Integer> {
    public ReviewRepository(Class<Review> reviewClass) {
        super(reviewClass);
    }
}
