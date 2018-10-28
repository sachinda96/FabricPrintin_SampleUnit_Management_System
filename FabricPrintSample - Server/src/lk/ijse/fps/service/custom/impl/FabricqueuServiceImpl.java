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
import lk.ijse.fps.buisness.custom.BDUOrderQueu;
import lk.ijse.fps.buisness.custom.FabricQueu;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.observer.Observer;
import lk.ijse.fps.observer.Subject;
import lk.ijse.fps.service.custom.FabricQueuService;
import lk.ijse.fps.service.custom.OrderQueuService;

/**
 *
 * @author Sachinda Nipun
 */
public class FabricqueuServiceImpl extends UnicastRemoteObject implements FabricQueuService,Subject{
    
    private FabricQueu fabricQueueBO;
    private static List<Observer> observers = new ArrayList<>();

    public FabricqueuServiceImpl() throws RemoteException {
        fabricQueueBO = (FabricQueu) BOFactory.getInstance().getBO(BOFactory.BOTypes.FABRICQUEU);
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
        this.observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws Exception {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() throws Exception {
        new Thread(() -> {
            for (Observer observer : observers) {
                try {
                    observer.updateObservers();
                } catch (Exception ex) {
                    Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    @Override
    public boolean addFabric(OrderDTO ordersDTO) throws Exception {
        boolean added=fabricQueueBO.addFabric(ordersDTO);
        if (added) {
            notifyObservers();
        }
        return added;
    }

    @Override
    public boolean removeFabric(OrderDTO ordersDTO) throws Exception {
        boolean removes=fabricQueueBO.remooveFabric(ordersDTO);
        if (removes) {
            notifyObservers();
        }
        return removes;
    }

    @Override
    public OrderDTO getFabric() throws Exception {
        OrderDTO orders=fabricQueueBO.getOrders();
        if (orders!=null) {
            notifyObservers();
        }
        return orders;
    }

    @Override
    public ArrayList<OrderDTO> getAllOrders() throws Exception {
        return fabricQueueBO.getAllOrders();
    }
    
    
}
