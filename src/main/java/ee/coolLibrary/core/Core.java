package ee.coolLibrary.core;

import ee.coolLibrary.controllers.AuthorControllerToCMD;
import ee.coolLibrary.controllers.BookControllerToCMD;
import ee.coolLibrary.controllers.ReviewControllerToCMD;
import ee.coolLibrary.controllers.contracts.AuthorController;
import ee.coolLibrary.controllers.contracts.BookController;
import ee.coolLibrary.controllers.contracts.ReviewController;
import ee.coolLibrary.entities.Author;
import ee.coolLibrary.entities.Book;
import ee.coolLibrary.entities.Review;
import ee.coolLibrary.repositories.*;
import ee.coolLibrary.repositories.DatabaseUtil;
import ee.coolLibrary.services.*;
import ee.coolLibrary.services.contracts.AuthorService;
import ee.coolLibrary.services.contracts.BookService;
import ee.coolLibrary.services.contracts.ReviewService;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Core {
    private static BookController bookController;
    private static ReviewController reviewController;
    private static AuthorController authorController;
    public static void init () {
        DatabaseUtil.init();
        //repositories settings
        AuthorRepository authorRepository = new AuthorRepository();
        BookRepository bookRepository = new BookRepository();
        ReviewRepository reviewRepository = new ReviewRepository();
        //services settings
        BookService bookService = new BookServiceImpl(bookRepository);
        AuthorService authorService = new AuthorServiceImpl(authorRepository);
        ReviewService reviewService = new ReviewServiceImpl(reviewRepository);
        //controllers settings
         bookController = new BookControllerToCMD(bookService);
         reviewController = new ReviewControllerToCMD(reviewService);
         authorController = new AuthorControllerToCMD(authorService);

    }





    //very, very dark magic
    public static void run(Class<?> clazz) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        if (clazz==null) throw new RuntimeException("Need class to start");
        if (bookController ==null|| reviewController ==null|| authorController ==null) init();

        Map <Class<?>, Object> interfacesToImpl = new HashMap<>();
        interfacesToImpl.put(bookController.getClass().getInterfaces()[0], bookController);
        interfacesToImpl.put(reviewController.getClass().getInterfaces()[0], reviewController);
        interfacesToImpl.put(authorController.getClass().getInterfaces()[0], authorController);
        Method getInstance = clazz.getMethod("getInstance");
        Method run = clazz.getMethod("run");
        Object o = getInstance.invoke(null);
       Field [] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
           interfacesToImpl.forEach((key, value) -> {
               if (key.equals(field.getType())) {
                   field.setAccessible(true);
                   try {
                       field.set(o,value);
                   } catch (IllegalAccessException e) {
                       e.printStackTrace();
                   }
               }
           });
        }
        run.invoke(o);
    }
}
