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
import lk.ijse.fps.buisness.custom.SupervisorQueu;
import lk.ijse.fps.dto.SupervisorQueuDTO;
import lk.ijse.fps.observer.Observer;
import lk.ijse.fps.observer.Subject;
import lk.ijse.fps.service.custom.SupervisorQueuService;

/**
 *
 * @author Sachinda Nipun
 */
public class SupervisorQueuSerivceImpl extends UnicastRemoteObject implements SupervisorQueuService,Subject{
    private SupervisorQueu supervisorQueu;
    private static ArrayList<Observer> alObservers = new ArrayList<>();

    public SupervisorQueuSerivceImpl() throws RemoteException{
        supervisorQueu=(SupervisorQueu) BOFactory.getInstance().getBO(BOFactory.BOTypes.SUPERVISORQUEU);
    }
    
    

    @Override
    public boolean addFinshedOrdersQueue(SupervisorQueuDTO supervisorQueuDTO) throws Exception {
        boolean added=supervisorQueu.addOrdersQueue(supervisorQueuDTO);
        notifyObservers();
        return added;
    }

    @Override
    public boolean removeFinshedOrdersQueue(SupervisorQueuDTO supervisorQueuDTO) throws Exception {
        boolean remove=supervisorQueu.removeOrdersQueue(supervisorQueuDTO);
        notifyObservers();
        return remove;
    }

    @Override
    public SupervisorQueuDTO getFinshedOrder() throws Exception {
        SupervisorQueuDTO getOrders=supervisorQueu.getOrder();
        notifyObservers();
        return getOrders;
    }

    @Override
    public List<SupervisorQueuDTO> getFinshedOrdrList() throws Exception {
       return supervisorQueu.getOrdrList();
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
                    Logger.getLogger(SupervisorQueuSerivceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        }).start();
    }
    
}
