package services;

import dao.UnityDAO;
import entities.Flat;

import java.util.List;

public class FlatService implements ServiceStandart<Flat>{


    public FlatService(){}

    public Flat serviceGetByID(Long ID){
        return UnityDAO.getByID(Flat.class, ID);
    }

    public void serviceSave(Flat flat){
        UnityDAO.save(flat);
    }

    public void serviceUpdate(Flat flat){
        UnityDAO.update(flat);
    }

    public void serviceMultipleUpdate(List<Flat> flats){
        UnityDAO.multipleUpdate(flats);
    }

    public void serviceDelete(Flat flat){
        UnityDAO.delete(flat);
    }


}
