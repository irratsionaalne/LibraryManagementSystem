package ee.coolLibrary.Database;

import ee.coolLibrary.entities.Author;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AuthorTable {
    private Session session = LibraryDB.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    public Author save(Author author) {
        try {
            transaction.begin();
            int id = (Integer) session.save(author);
            transaction.commit();
            return find(id);
        } catch (HibernateException e) {
            transaction.rollback();
            return null;
        }

    }

    public void update(Author author) {
        try {
            transaction.begin();
            session.update(author);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        }
    }

    public void delete(Author author) {
        try {
            transaction.begin();
            session.delete(author);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        }


    }

    public Author find(int id) {
        return session.find(Author.class, id);
    }
}
