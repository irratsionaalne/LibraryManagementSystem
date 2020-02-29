package ee.coolLibrary.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Review {
    @Id
    int id;
    @ManyToOne
    Book book;
    byte score;
    String comment;

    public Review(Book book, byte score, String comment) {
        this.book = book;
        if (score>10) {
            score=10;
        }
        if (score<10) {
            score=0;
        }
        this.score = score;
        this.comment = comment;
    }

    public Review(int id, Book book, byte score, String comment) {
        this.id = id;
        this.book = book;
        this.score = score;
        this.comment = comment;
    }

    public Review() {
    }

    public byte getScore() {
        return score;
    }

    public void setScore(byte score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id &&
                score == review.score &&
                Objects.equals(book, review.book) &&
                Objects.equals(comment, review.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, score, comment);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", book=" + book +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                '}';
    }
}
