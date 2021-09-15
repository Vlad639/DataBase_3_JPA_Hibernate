package DAO;

import Entities.Street;
import HibernateSessionFactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class StreetDAO implements DAOstandart<Street>{
    public Street getByID(int id){
        return HibernateSessionFactory.getSessionFactory().openSession().get(Street.class,id);
    }

    public void save(Street street){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(street);
        transaction.commit();
        session.close();
    }

    public void update(Street street){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(street);
        transaction.commit();
        session.close();
    }

    public void delete(Street street){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(street);
        transaction.commit();
        session.close();
    }
}
