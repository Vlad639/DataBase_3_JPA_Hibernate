package Services;

public interface ServiceStandart<T> {

    public T serviceGetByID(Long ID);

    public void serviceSave(T obj);

    public void serviceUpdate(T obj);

    public void serviceDelete(T obj);
}
