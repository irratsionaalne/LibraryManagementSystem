package ee.coolLibrary.entities;


import ee.coolLibrary.entities.contracts.SimpleEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Review implements SimpleEntity<Integer> {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    int id;
    @ManyToOne
    @JoinColumn (name = "book_id")
    Book book;
    @Column (name = "score")
    int score;
    @Column (name = "comment")
    String comment;

    public Review(Book book, int score, String comment) {
        this.book = book;
        if (score>10) {
            score=10;
        }
        if (score<0) {
            score=0;
        }
        this.score = score;
        this.comment = comment;
    }

    public Review(int id, Book book, int score, String comment) {
        this.id = id;
        this.book = book;
        this.score = score;
        this.comment = comment;
    }

    public Review() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
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
