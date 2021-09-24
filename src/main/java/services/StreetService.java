package services;

import dao.UnutyDAO;
import entities.Street;

public class StreetService implements ServiceStandart<Street>{
    private final UnutyDAO<Street> streetDAO = new UnutyDAO<>(Street.class);

    public StreetService(){}

    public Street serviceGetByID(Long ID){
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
