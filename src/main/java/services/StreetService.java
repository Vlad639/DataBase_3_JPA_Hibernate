package services;

import dao.UnityDAO;
import entities.Street;

public class StreetService implements ServiceStandart<Street>{

    public StreetService(){}

    public Street serviceGetByID(Long ID){
        return UnityDAO.getByID(Street.class, ID);
    }

    public void serviceSave(Street street){
        UnityDAO.save(street);
    }

    public void serviceUpdate(Street street){
        UnityDAO.update(street);
    }

    public void serviceDelete(Street street){
        UnityDAO.delete(street);
    }
}
