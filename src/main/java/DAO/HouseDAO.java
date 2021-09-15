package DAO;

import Entities.House;
import Entities.Street;
import HibernateSessionFactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class HouseDAO implements DAOstandart<House>{
    public House getByID(int id){
        return HibernateSessionFactory.getSessionFactory().openSession().get(House.class,id);
    }

    public void save(House house){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(house);
        transaction.commit();
        session.close();
    }

    public void update(House house){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(house);
        transaction.commit();
        session.close();
    }

    public void delete(House house){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(house);
        transaction.commit();
        session.close();
    }
}
