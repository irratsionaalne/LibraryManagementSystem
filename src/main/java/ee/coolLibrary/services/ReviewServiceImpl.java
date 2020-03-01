package ee.coolLibrary.services;

import com.google.common.base.Strings;
import ee.coolLibrary.entities.Author;
import ee.coolLibrary.entities.Review;
import ee.coolLibrary.repositories.ReviewRepository;
import ee.coolLibrary.services.contracts.ReviewService;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    @Override
    public Set<Review> findAll() {
        Set<Review> entitySet = new HashSet<>();
        for (Review entity : repository.findAll()) {
            entitySet.add(entity);
        }
        return entitySet;
    }


}
