package ee.coolLibrary.repositories;

import ee.coolLibrary.entities.Author;
import ee.coolLibrary.entities.Book;
import ee.coolLibrary.entities.Review;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class DatabaseUtil {

    private static SessionFactory sessionFactory;



    public static void init () {
        Configuration configuration = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/Petclinic");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "Fa246813as");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.put(Environment.HBM2DDL_AUTO, "none");
        configuration.addAnnotatedClass(Author.class);
        configuration.addAnnotatedClass(Book.class);
        configuration.addAnnotatedClass(Review.class);
        configuration.setProperties(properties);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);


    }


    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
           init();
        }
        return sessionFactory;
    }

   public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }


}

