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
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.observer.Observer;
import lk.ijse.fps.observer.Subject;
import lk.ijse.fps.service.custom.OrderQueuService;

/**
 *
 * @author Sachinda Nipun
 */
public class OrderqueuServiceImpl extends UnicastRemoteObject implements OrderQueuService,Subject{
    
    private BDUOrderQueu orderQueueBO;
    private static List<Observer> observers = new ArrayList<>();

    public OrderqueuServiceImpl() throws RemoteException {
        orderQueueBO = (BDUOrderQueu) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDERQUEU);
    }

    
    
    @Override
    public boolean addOrdQueu(OrderDTO order) throws Exception {
        boolean addOrder=orderQueueBO.addOrdersQueue(order);
        if (addOrder) {
            notifyObservers();
        }
        return addOrder;
    }

    @Override
    public boolean removeOrdQueu(OrderDTO order) throws Exception {
        boolean removeOrders=orderQueueBO.removeOrdersQueue(order);
        if (removeOrders) {
            notifyObservers();
        }
        return removeOrders;
    }

    @Override
    public OrderDTO getOrder() throws Exception {
        OrderDTO order=orderQueueBO.getOrder();
     
          notifyObservers();  
        
        
        
        return order;
    }

    @Override
    public List<OrderDTO> getOrderList() throws Exception {
       return orderQueueBO.getOrdrList();
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
    
    
}
