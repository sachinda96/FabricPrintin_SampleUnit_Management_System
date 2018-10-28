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
import lk.ijse.fps.buisness.custom.FabriCBo;
import lk.ijse.fps.dto.FabricDTO;
import lk.ijse.fps.observer.Observer;
import lk.ijse.fps.observer.Subject;
import lk.ijse.fps.service.custom.FabricService;

/**
 *
 * @author Sachinda Nipun
 */
public class FabricServiceImpl extends UnicastRemoteObject implements FabricService,Subject{
    private FabriCBo fabriCBo;
    
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    
   public FabricServiceImpl()throws RemoteException{
       fabriCBo=(FabriCBo) BOFactory.getInstance().getBO(BOFactory.BOTypes.FABRIC);
   }

    @Override
    public boolean addFabric(FabricDTO fabric) throws Exception {
        boolean added= fabriCBo.addFabric(fabric);
        notifyObservers();
        return added;
    }

    @Override
    public boolean updateFabric(FabricDTO fabric) throws Exception {
        boolean update= fabriCBo.updateFabric(fabric);
        notifyObservers();
        return update;
    }

    @Override
    public boolean deleteFabric(String fabricID) throws Exception {
       boolean deleted= fabriCBo.deleteFabric(fabricID);
        notifyObservers();
        return deleted; 
    }

    @Override
    public List<FabricDTO> getAllFabric() throws Exception {
        return fabriCBo.getAllFabric();
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
                    Logger.getLogger(FabricServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        }).start();
    }

    @Override
    public boolean viewfabricId(Integer designID) throws Exception {
        return fabriCBo.viewfabricId(designID);
    }

}
