package services;

import dao.UnityDAO;
import entities.Human;

public class HumanService implements ServiceStandart<Human>{

    public HumanService(){}

    public Human serviceGetByID(Long ID){
        return UnityDAO.getByID(Human.class, ID);
    }

    public void serviceSave(Human human){
        UnityDAO.save(human);
    }

    public void serviceUpdate(Human human){
        UnityDAO.update(human);
    }

    public void serviceDelete(Human human){
        UnityDAO.delete(human);
    }

}
