package services;

import dao.UnityDAO;
import entities.City;

public class CityService implements ServiceStandart<City>{


    public CityService(){}

    public City serviceGetByID(Long ID){
        return UnityDAO.getByID(City.class, ID);
    }

    public void serviceSave(City city){
        UnityDAO.save(city);
    }

    public void serviceUpdate(City city){
        UnityDAO.update(city);
    }

    public void serviceDelete(City city){
        UnityDAO.delete(city);
    }
}
