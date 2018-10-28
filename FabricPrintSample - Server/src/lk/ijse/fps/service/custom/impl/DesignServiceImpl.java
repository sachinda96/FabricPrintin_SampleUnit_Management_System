/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.fps.buisness.BOFactory;
import lk.ijse.fps.buisness.custom.DesignBO;
import lk.ijse.fps.buisness.custom.impl.DesignBOImp;
import lk.ijse.fps.dto.DesignDTO;
import lk.ijse.fps.observer.Observer;
import lk.ijse.fps.observer.Subject;
import lk.ijse.fps.service.custom.DesignService;

/**
 *
 * @author Sachinda Nipun
 */
public class DesignServiceImpl extends UnicastRemoteObject implements DesignService,Subject{
    private DesignBO designBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    
    public DesignServiceImpl()throws RemoteException{
        designBO=(DesignBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.DESIGN);
    }
    @Override
    public boolean addDeign(DesignDTO design) throws Exception {
        boolean added=designBO.addDeign(design);
        notifyObservers();
        return added;
    }

    @Override
    public boolean updateDeign(DesignDTO design) throws Exception {
        boolean update=designBO.updateDeign(design);
        notifyObservers();
        return update;
    }

    @Override
    public boolean deleteDeign(Integer designID) throws Exception {
         boolean delet=designBO.deleteDeign(designID);
        notifyObservers();
        return delet;
    }

    @Override
    public List<DesignDTO> getAllDeign() throws Exception {
        return designBO.getAllDeign();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registerObserver(Observer observer) throws Exception {
        alObservers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws Exception {
        alObservers.remove(observer);
    }

    @Override
    public void notifyObservers() throws Exception {
        new Thread(() -> {
            for (Observer observer : alObservers) {
                
                try {
                    observer.updateObservers();
                } catch (Exception ex) {
                    Logger.getLogger(OrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            }
        }).start();
    }

    @Override
    public boolean viewDeignId(Integer designID) throws Exception {
        return designBO.viewDeignId(designID);
    }
    
}
