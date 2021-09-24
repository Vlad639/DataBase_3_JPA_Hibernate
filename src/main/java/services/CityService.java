package services;

import dao.UnutyDAO;
import entities.City;

public class CityService implements ServiceStandart<City>{
    private final UnutyDAO<City> cityDAO = new UnutyDAO<>(City.class);

    public CityService(){}

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
