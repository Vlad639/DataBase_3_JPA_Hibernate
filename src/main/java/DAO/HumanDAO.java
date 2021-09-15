package DAO;

import Entities.Human;
import HibernateSessionFactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class HumanDAO implements DAOstandart<Human>{
    public Human getByID(int id){
        return HibernateSessionFactory.getSessionFactory().openSession().get(Human.class,id);
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
