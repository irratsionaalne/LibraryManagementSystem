package ee.coolLibrary.api;

import com.google.gson.Gson;
import ee.coolLibrary.entities.Review;

public class ReviewDTO {
    int id;
    int bookId;
    String bookTitle;
    int score;
    String comment;

    public ReviewDTO(Review review) {
        this.id = review.getId();
        this.bookId = review.getBook().getId();
        this.bookTitle = review.getBook().getTitle();
        this.score = review.getScore();
        this.comment = review.getComment();
    }

    public String getJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
