package DAO;

import Entities.Flat;
import HibernateSessionFactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class FlatDAO implements DAOStandart<Flat> {
    public Flat getByID(Long id){
        Session session  = HibernateSessionFactory.getSessionFactory().openSession();
        Flat flat = session.get(Flat.class,id);
        session.close();
        return flat;
    }

    public void save(Flat flat){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(flat);
        transaction.commit();
        session.close();
    }

    public void update(Flat flat){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(flat);
        transaction.commit();
        session.close();
    }

    public void delete(Flat flat){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(flat);
        transaction.commit();
        session.close();
    }
}
