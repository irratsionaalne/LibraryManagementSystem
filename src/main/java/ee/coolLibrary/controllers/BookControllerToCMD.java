package ee.coolLibrary.controllers;

import ee.coolLibrary.controllers.contracts.BookController;
import ee.coolLibrary.services.contracts.BookService;

public class BookControllerToCMD implements BookController {
    BookService bookService;

    public BookControllerToCMD(BookService bookService) {
        this.bookService = bookService;
    }
}
