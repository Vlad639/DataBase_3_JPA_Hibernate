package Services;

import DAO.CityDAO;
import DAO.StreetDAO;
import Entities.City;
import Entities.Street;

public class StreetService implements ServiceStandart<Street>{
    private final StreetDAO streetDAO = new StreetDAO();

    public StreetService(){}

    public Street serviceGetByID(int ID){
        return streetDAO.getByID(ID);
    }

    public void serviceSave(Street street){
        streetDAO.save(street);
    }

    public void serviceUpdate(Street street){
        streetDAO.update(street);
    }

    public void serviceDelete(Street street){
        streetDAO.delete(street);
    }
}
