package DAO;
public interface DAOStandart<T> {

        T getByID(Long ID);

        void save(T obj);

        void update(T obj);

        void delete(T obj);
}
