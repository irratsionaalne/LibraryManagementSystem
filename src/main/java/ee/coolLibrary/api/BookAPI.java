package ee.coolLibrary.api;

import com.google.gson.Gson;
import ee.coolLibrary.api.DTO.BookDTO;
import ee.coolLibrary.api.contracts.LibraryAPI;
import ee.coolLibrary.entities.Book;
import ee.coolLibrary.services.contracts.BookService;
import ee.coolLibrary.services.contracts.ReviewService;
import ee.coolLibrary.util.ServiceBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.Set;

public class BookAPI implements LibraryAPI<String> {

    BookService bookService;
    ReviewService reviewService;
    Gson gson;
    BookDTO bookDTO;

    public BookAPI() {
        this.bookService = ServiceBuilder.getBookService();
        this.gson = new Gson();
    }

    @Override
    public String save(String s) {
        try {

            bookDTO = gson.fromJson(s, BookDTO.class);
        } catch (Exception e) {
            return "not a Json!";
        }
        String title = bookDTO.getTitle();
        String genre = bookDTO.getGenre();
        int publishingYear = bookDTO.getPublishYear();
        String description = bookDTO.getDescription();
        Book book = new Book(title, genre, publishingYear, description);
        bookService.save(book);
        return findById(book.getId().toString());
    }

    @Override
    public String findById(String s) {
        Book book;
        try {
            book = bookService.findById(Integer.parseInt(s));
        } catch (Exception e) {
            return "Wrong Id format";
        }
        if (book==null) {
            return "book not found";
        }
        return new BookDTO(book).getJson();
    }

    @Override
    public String delete(String s) {
        try {

            bookDTO = gson.fromJson(s, BookDTO.class);
        } catch (Exception e) {
            return "not a Json!";
        }
        Book book = bookService.findById(bookDTO.getId());
        if (book == null){
            return "Book not found";
        }
        bookService.delete(book);
        return "Deleted";
    }

    @Override
    public String update(String s) {
        try {

            bookDTO = gson.fromJson(s, BookDTO.class);
        } catch (Exception e) {
            return "not a Json!";
        }
        Book book = bookService.findById(bookDTO.getId());
        if (book==null) {
            return "Book not found";
        }
        book.setTitle(bookDTO.getTitle());
        book.setGenre(bookDTO.getGenre());
        book.setDescription(bookDTO.getDescription());
        book.setPublishYear(bookDTO.getPublishYear());
        Book saved = bookService.update(book);
        return new BookDTO(saved).getJson();
    }

    @Override
    public String findAll() {
        Set<BookDTO> bookDTOS = new HashSet<>();
        bookService.findAll().forEach(book -> bookDTOS.add(new BookDTO(book)));
        return gson.toJson(bookDTOS);
    }

    public String addReviewToBook(String bookID, String reviewID){
        int bookIDint, reviewIDint;
        try {
            bookIDint = Integer.parseInt(bookID);
            reviewIDint = Integer.parseInt(reviewID);
        } catch (Exception e){
            return "Invalid parameters";
        }
        bookService.addReview(bookService.findById(bookIDint), reviewService.findById(reviewIDint));
        return "Review Added";
    }

    public String deleteReviewFromBook(String bookID, String reviewID){
        int bookIDint, reviewIDint;
        try {
            bookIDint = Integer.parseInt(bookID);
            reviewIDint = Integer.parseInt(reviewID);
        } catch (Exception e){
            return "Invalid parameters";
        }
        bookService.deleteReview(bookService.findById(bookIDint), reviewService.findById(reviewIDint));
        return "Deleted review";
    }
}
