package ee.coolLibrary;

import ee.coolLibrary.repositories.AuthorRepository;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class DatabaseUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {

            Configuration configuration = new Configuration();

            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");


            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/Petclinic");


            properties.put(Environment.USER, "root");
            properties.put(Environment.PASS, "Fa246813as");

            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");




        }
        return sessionFactory;
    }



}

