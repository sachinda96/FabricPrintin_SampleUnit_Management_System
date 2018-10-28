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
import lk.ijse.fps.buisness.custom.OrderBo;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.dto.PlaceOrderDTO;
import lk.ijse.fps.observer.Observer;
import lk.ijse.fps.observer.Subject;
import lk.ijse.fps.service.custom.OrderService;

/**
 *
 * @author Sachinda Nipun
 */
public class OrderServiceImpl extends UnicastRemoteObject implements OrderService,Subject{
    private OrderBo orderBo;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    
    public OrderServiceImpl()throws RemoteException{
        orderBo=(OrderBo) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDERS);
    }
    @Override
    public boolean addOrders(PlaceOrderDTO Orders) throws Exception {
        boolean adedd= orderBo.addOrders(Orders);
        notifyObservers();
        return adedd;
    }

    @Override
    public boolean deleteOrders(Integer OrdersID) throws Exception {
       boolean delet=orderBo.deleteOrders(OrdersID);
       notifyObservers();
       return delet;
    }

    @Override
    public boolean updateOrders(PlaceOrderDTO Orders) throws Exception {
       boolean update=orderBo.updateOrders(Orders);
       notifyObservers();
       return update;
    }

    @Override
    public List<OrderDTO> getOrders() throws Exception {
        return orderBo.getAllOrders();
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
        System.out.println(observer);
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
    public boolean finsheOrders(PlaceOrderDTO Orders) throws Exception {
         boolean adedd= orderBo.finshedOrders(Orders);
        notifyObservers();
        return adedd;
    }

    @Override
    public boolean viewOrderId(Integer designID) throws Exception {
        return orderBo.viewOrderId(designID);
    }
    
}
