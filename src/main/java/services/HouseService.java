package services;

import dao.UnityDAO;
import entities.House;

public class HouseService implements ServiceStandart<House>{


    public HouseService(){}

    public House serviceGetByID(Long ID){
        return UnityDAO.getByID(House.class, ID);
    }

    public void serviceSave(House house){
        UnityDAO.save(house);
    }

    public void serviceUpdate(House house){
        UnityDAO.update(house);
    }

    public void serviceDelete(House house){
        UnityDAO.delete(house);
    }
}
