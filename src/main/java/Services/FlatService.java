package Services;

import DAO.UnutyDAO;
import Entities.Flat;

public class FlatService implements ServiceStandart<Flat>{
    private final UnutyDAO<Flat> flatDAO = new UnutyDAO<>(Flat.class);

    public FlatService(){}

    public Flat serviceGetByID(Long ID){
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
