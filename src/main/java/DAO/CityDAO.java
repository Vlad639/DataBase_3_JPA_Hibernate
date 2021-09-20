package DAO;

import Entities.City;
import org.hibernate.Session;
import org.hibernate.Transaction;
import HibernateSessionFactory.HibernateSessionFactory;


public class CityDAO implements DAOStandart<City> {
    public City getByID(Long id){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        City city = session.get(City.class,id);
        session.close();
        return city;
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
