package DAO;

import Entities.Human;
import HibernateSessionFactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class HumanDAO implements DAOstandart<Human>{
    public Human getByID(Long id){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Human human = session.get(Human.class,id);
        session.close();
        return human;
    }

    public void save(Human human){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(human);
        transaction.commit();
        session.close();
    }

    public void update(Human human){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(human);
        transaction.commit();
        session.close();
    }

    public void delete(Human human){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(human);
        transaction.commit();
        session.close();
    }
}
