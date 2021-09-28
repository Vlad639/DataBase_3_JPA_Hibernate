package dao;

import hibernateSessionFactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class UnityDAO {

    private static <T> void openSessionAndMakeTransaction(List<T> objectsList, TransactionEvent transactionEvent){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        for (T elem: objectsList) {
            switch (transactionEvent){
                case SAVE -> session.save(elem);
                case UPDATE -> session.update(elem);
                case DELETE -> session.delete(elem);
            }
        }
        transaction.commit();
        session.close();
    }

    public static<T> T getByID(Class<T> objectClass, Long id){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        T object = session.get(objectClass ,id);
        session.close();
        return object;
    }

    private UnityDAO(){

    }


    public static<T> void save(T object){
        openSessionAndMakeTransaction(List.of(object), TransactionEvent.SAVE);
    }

    public static<T> void update(T object){
        openSessionAndMakeTransaction(List.of(object), TransactionEvent.UPDATE);
    }

    public static<T> void multipleUpdate(List<T> objectsList){
        openSessionAndMakeTransaction(objectsList, TransactionEvent.UPDATE);
    }

    public static<T> void delete(T object){
        openSessionAndMakeTransaction(List.of(object), TransactionEvent.DELETE);
    }
}
