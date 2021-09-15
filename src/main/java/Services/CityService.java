package Services;

import DAO.CityDAO;
import Entities.City;

public class CityService implements ServiceStandart<City>{
    private final CityDAO cityDAO = new CityDAO();

    public CityService(){}

    public City serviceGetByID(int ID){
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
