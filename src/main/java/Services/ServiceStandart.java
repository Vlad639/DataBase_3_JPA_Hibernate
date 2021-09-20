package Services;

public interface ServiceStandart<T> {

    T serviceGetByID(Long ID);

    void serviceSave(T obj);

    void serviceUpdate(T obj);

    void serviceDelete(T obj);
}
