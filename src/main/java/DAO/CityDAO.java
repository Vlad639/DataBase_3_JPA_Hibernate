package DAO;

import Entities.City;
import org.hibernate.Session;
import org.hibernate.Transaction;
import HibernateSessionFactory.HibernateSessionFactory;


public class CityDAO implements DAOstandart<City>{
    public City getByID(int id){
        return HibernateSessionFactory.getSessionFactory().openSession().get(City.class,id);
    }

    public void save(City city){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(city);
        transaction.commit();
        session.close();
    }

    public void update(City city){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(city);
        transaction.commit();
        session.close();
    }

    public void delete(City city){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(city);
        transaction.commit();
        session.close();
    }
}
