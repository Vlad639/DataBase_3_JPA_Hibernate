package dao;

import hibernateSessionFactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UnutyDAO<T> {
    Class<T> objectClass;

    public T getByID(Long id){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        T object = session.get(objectClass ,id);
        session.close();
        return object;
    }

    private UnutyDAO(){

    }

    public UnutyDAO(Class<T> objectClass) {
        this.objectClass = objectClass;
    }

    public void save(T object){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
    }

    public void update(T object){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
    }

    public void delete(T object){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        session.close();
    }
}
