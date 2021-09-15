package DAO;
public interface DAOstandart<T> {

        public T getByID(int ID);

        public void save(T obj);

        public void update(T obj);

        public void delete(T obj);
}
