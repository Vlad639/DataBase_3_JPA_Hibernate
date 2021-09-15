package Services;

import DAO.FlatDAO;
import DAO.HouseDAO;
import Entities.Flat;

public class FlatService implements ServiceStandart<Flat>{
    private final FlatDAO flatDAO = new FlatDAO();

    public FlatService(){}

    public Flat serviceGetByID(int ID){
        return flatDAO.getByID(ID);
    }

    public void serviceSave(Flat flat){
        flatDAO.save(flat);
    }

    public void serviceUpdate(Flat flat){
        flatDAO.update(flat);
    }

    public void serviceDelete(Flat flat){
        flatDAO.delete(flat);
    }
}