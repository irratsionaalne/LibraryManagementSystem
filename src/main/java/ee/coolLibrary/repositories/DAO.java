package ee.coolLibrary.repositories;

import com.sun.xml.bind.v2.model.core.ID;
import ee.coolLibrary.DatabaseUtil;
import ee.coolLibrary.entities.Author;
import ee.coolLibrary.entities.SimpleEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class DAO <ENT extends SimpleEntity<ID>, ID> implements SimpleRepository <ENT, ID> {
    private Session session = DatabaseUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    Class<ENT> entClass;

    public DAO(Class<ENT> entClass) {
        this.entClass = entClass;
    }

    @Override
    public ENT save(ENT entity) {
        try {
            transaction.begin();
            int id = (Integer) session.save(entity);
            transaction.commit();
            return findById(entity.getId());
        } catch (HibernateException e) {
            transaction.rollback();
            return entity;
        }
    }

    @Override
    public ENT findById(ID id) {
        return (ENT) session.find(entClass, id);
    }

    @Override
    public ENT delete(ENT entity) {
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
    public ENT update(ENT entity) {
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
    public Iterable<ENT> findAll() {
        return session.createCriteria(Object.class).list();
    }
}
