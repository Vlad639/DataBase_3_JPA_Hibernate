package Services;

import DAO.UnutyDAO;
import Entities.City;

public class UnityService{
    private final UnutyDAO<City> cityDAO = new UnutyDAO<>(City.class);


    public UnityService(){}

    public City serviceGetByID(Long ID){
        return cityDAO.getByID(ID);
    }

    public void serviceSave(City city){
        cityDAO.save(city);
    }

    public void serviceUpdate(City city){
        cityDAO.update(city);
    }

    public void serviceDelete(City city){
        cityDAO.delete(city);
    }
}
