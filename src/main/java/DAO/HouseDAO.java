package DAO;

import Entities.House;
import HibernateSessionFactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class HouseDAO implements DAOStandart<House> {
    public House getByID(Long id){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        House house = session.get(House.class,id);
        session.close();
        return house;
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
