package ee.coolLibrary.api;

import com.google.gson.Gson;
import ee.coolLibrary.api.DTO.BookDTO;
import ee.coolLibrary.api.contracts.LibraryAPI;
import ee.coolLibrary.entities.Book;
import ee.coolLibrary.services.contracts.BookService;
import ee.coolLibrary.util.ServiceBuilder;

import java.util.HashSet;
import java.util.Set;

public class BookAPI implements LibraryAPI<String> {

    BookService bookService;
    Gson gson;
    BookDTO bookDTO;

    public BookAPI() {
        this.bookService = ServiceBuilder.getBookService();
        this.gson = new Gson();
    }

    @Override
    public String save(String s) {
        bookDTO = gson.fromJson(s, BookDTO.class);
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
        Book book = bookService.findById(Integer.parseInt(s));
        return new BookDTO(book).getJson();
    }

    @Override
    public String delete(String s) {
        bookDTO = gson.fromJson(s, BookDTO.class);
        Book book = bookService.findById(bookDTO.getId());
        if (book == null){
            return "Book not found";
        }
        bookService.delete(book);
        return "Deleted";
    }

    @Override
    public String update(String s) {
        bookDTO = gson.fromJson(s,BookDTO.class);
        Book book = bookService.findById(bookDTO.getId());
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
}
