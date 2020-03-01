package ee.coolLibrary.controllers;

import ee.coolLibrary.controllers.contracts.ReviewController;
import ee.coolLibrary.services.contracts.ReviewService;

public class ReviewControllerToCMD implements ReviewController {
    ReviewService reviewService;

    public ReviewControllerToCMD(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
}
