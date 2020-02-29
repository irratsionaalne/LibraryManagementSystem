package ee.coolLibrary.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "Book")
public class Book implements SimpleEntity <Integer> {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    @Column (name = "title")
    private String title;
    @Column (name = "genre")
    private String genre;
    @Column (name = "year_of_publishing")
    private int publishYear;
    @Column (name = "description")
    private String description;
    @OneToMany
    @JoinColumn (name = "review_id")
    private List<Review> reviews;
    @ManyToMany (mappedBy = "books")
    private List<Author> authors;

    public Book(String title, String genre, int publishYear, String description) {
        this.title = title;
        this.genre = genre;
        this.publishYear = publishYear;
        this.description = description;
        this.reviews= new ArrayList<>();
        this.authors= new ArrayList<>();
    }

    public Book(int id, String title, String genre, int publishYear, String description, List<Review> reviews, List<Author> authors) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.publishYear = publishYear;
        this.description = description;
        this.reviews = reviews;
        this.authors = authors;
    }

    public Book() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addReview (Review review) {
        reviews.add(review);
    }
    public void deleteReview (Review review) {
        reviews.remove(review);
    }
    public void addAuthor(Author author) {
        authors.add(author);
    }
    public void deleteAuthor (Author author) {
        authors.remove(author);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                publishYear == book.publishYear &&
                Objects.equals(title, book.title) &&
                Objects.equals(genre, book.genre) &&
                Objects.equals(description, book.description) &&
                Objects.equals(reviews, book.reviews) &&
                Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, genre, publishYear, description, reviews, authors);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", publishYear=" + publishYear +
                ", description='" + description + '\'' +
                '}';
    }
}
