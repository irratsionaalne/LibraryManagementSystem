package ee.coolLibrary.repositories;

import com.sun.xml.bind.v2.model.core.ID;
import ee.coolLibrary.DatabaseUtil;
import ee.coolLibrary.entities.Author;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DAO implements SimpleRepository {
    private Session session = DatabaseUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    @Override
    public Object save(Object entity) {
        try {
            transaction.begin();
            int id = (Integer) session.save(entity);
            transaction.commit();
            return findById(entity, id);
        } catch (HibernateException e) {
            transaction.rollback();
            return entity;
        }
    }

    @Override
    public Object findById(Object entity, Object o) {
        return session.find(Object.class, o);
    }

    @Override
    public Object delete(Object entity) {
        try {
            transaction.begin();
            session.delete(entity);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        }
        return entity;
    }

    @Override
    public Object update(Object entity) {
        try {
            transaction.begin();
            session.update(entity);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        }
        return entity;
    }

    @Override
    public Iterable findAll() {
        return session.createCriteria(Object.class).list();
    }
}
