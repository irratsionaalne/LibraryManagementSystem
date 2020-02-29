package ee.coolLibrary.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "Author")
public class Author implements SimpleEntity <Integer> {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column (name = "id")
   private int id;

@Column (name = "first_name")
   private String firstName;
@Column (name = "last_name")
   private String lastName;
   @ManyToMany
   @JoinTable(name = "Author_Books", joinColumns = {@JoinColumn (name = "author_id")}, inverseJoinColumns = {@JoinColumn (name = "book_id")})
   private List<Book> books;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books= new ArrayList<Book>();
    }

    public Author(int id, String firstName, String lastName, List<Book> books) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    public Author() {
    }


    @Override
    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addBook (Book book) {
        books.add(book);
    }
    public void removeBook (Book book) {
        books.add(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
                Objects.equals(firstName, author.firstName) &&
                Objects.equals(lastName, author.lastName) &&
                Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, books);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
