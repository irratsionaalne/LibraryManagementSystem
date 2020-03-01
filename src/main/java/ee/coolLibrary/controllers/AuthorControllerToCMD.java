package ee.coolLibrary.controllers;

import ee.coolLibrary.entities.Author;
import ee.coolLibrary.services.AuthorService;

import java.util.Scanner;

public class AuthorControllerToCMD {

    AuthorService authorService;

    public AuthorControllerToCMD(AuthorService authorService) {
        this.authorService = authorService;
    }


    public void newAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the first name of the author");
        String firstName = scanner.nextLine();
        System.out.println("Please enter the last name of the author");
        String lastName = scanner.nextLine();
        Author author = new Author(firstName, lastName);
        String answer = authorService.save(author);
        System.out.println(answer);
    }


}
