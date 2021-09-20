package Services;

import DAO.HumanDAO;
import Entities.Human;

public class HumanService implements ServiceStandart<Human>{
    private final HumanDAO humanDAO = new HumanDAO();

    public HumanService(){}

    public Human serviceGetByID(Long ID){
        return humanDAO.getByID(ID);
    }

    public void serviceSave(Human human){
        humanDAO.save(human);
    }

    public void serviceUpdate(Human human){
        humanDAO.update(human);
    }

    public void serviceDelete(Human human){
        humanDAO.delete(human);
    }

}
