package ee.coolLibrary.controllers;

import ee.coolLibrary.controllers.contracts.AuthorController;
import ee.coolLibrary.controllers.contracts.BookController;
import ee.coolLibrary.controllers.contracts.ReviewController;

public class MainControllerToCMD {

    private BookController bookController;
    private ReviewController reviewController;
    private AuthorController authorController;
    private static MainControllerToCMD mainControllerToCMD;

    private MainControllerToCMD () {}

    public static MainControllerToCMD getInstance () {
        if (mainControllerToCMD==null) mainControllerToCMD=new MainControllerToCMD();
        return mainControllerToCMD;
    }


    public void run () {
      authorController.newAuthor();

    }

}
