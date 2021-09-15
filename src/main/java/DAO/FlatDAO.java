package DAO;

import Entities.Flat;
import Entities.Street;
import HibernateSessionFactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class FlatDAO implements DAOstandart<Flat>{
    public Flat getByID(int id){
        return HibernateSessionFactory.getSessionFactory().openSession().get(Flat.class,id);
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
