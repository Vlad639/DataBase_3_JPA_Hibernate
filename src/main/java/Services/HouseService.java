package Services;

import DAO.HouseDAO;
import Entities.House;

public class HouseService implements ServiceStandart<House>{
    private final HouseDAO houseDAO = new HouseDAO();

    public HouseService(){}

    public House serviceGetByID(int ID){
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
