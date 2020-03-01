package ee.coolLibrary.controllers;

import ee.coolLibrary.controllers.contracts.AuthorController;
import ee.coolLibrary.entities.Author;
import ee.coolLibrary.services.contracts.AuthorService;

import java.util.Scanner;

public class AuthorControllerToCMD implements AuthorController {

    AuthorService authorService;

    public AuthorControllerToCMD(AuthorService authorService) {
        this.authorService = authorService;
    }


    public void newAuthor () {
        Scanner scanner = new Scanner(System.in);
        String firstNane = scanner.nextLine();
        String lastname = scanner.nextLine();
        Author author = new Author(firstNane,lastname);
       Author saved = authorService.save(author);
        System.out.println(saved.getFirstName()+" "+saved.getLastName());
    }



}
