package Services;

import DAO.UnutyDAO;
import Entities.House;

public class HouseService implements ServiceStandart<House>{
    private final UnutyDAO<House> houseDAO = new UnutyDAO<>(House.class);

    public HouseService(){}

    public House serviceGetByID(Long ID){
        return houseDAO.getByID(ID);
    }

    public void serviceSave(House house){
        houseDAO.save(house);
    }

    public void serviceUpdate(House house){
        houseDAO.update(house);
    }

    public void serviceDelete(House house){
        houseDAO.delete(house);
    }
}
