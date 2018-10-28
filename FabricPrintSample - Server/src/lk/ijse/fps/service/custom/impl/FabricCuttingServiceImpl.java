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
import lk.ijse.fps.buisness.custom.FabricCutingBO;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.observer.Observer;
import lk.ijse.fps.observer.Subject;
import lk.ijse.fps.service.custom.FabricCuttingService;

/**
 *
 * @author Sachinda Nipun
 */
public class FabricCuttingServiceImpl extends UnicastRemoteObject implements FabricCuttingService, Subject {

    private FabricCutingBO fabricCutingBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();

    public FabricCuttingServiceImpl() throws RemoteException {
        fabricCutingBO = (FabricCutingBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.FABRICCUTTING);
    }

    @Override
    public boolean addOrders(OrderDTO orders) throws Exception {
        boolean added = fabricCutingBO.addOrders(orders);
        if (added) {
        notifyObservers();
        }

        return added;
    }

    @Override
    public boolean updateOrders(OrderDTO orders) throws Exception {
        boolean added = fabricCutingBO.updateOrders(orders);
        
        if (added) {
            notifyObservers();
        }

        return added;
    }

    @Override
    public boolean deleteOrders(Integer OrderID) throws Exception {
        boolean del = fabricCutingBO.deleteOrders(OrderID);
        if (del) {
            notifyObservers();
        }

        return del;
    }

    @Override
    public List<OrderDTO> getAllOrders() throws Exception {
        return fabricCutingBO.getAllOrders();
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
    public List<OrderDTO> getColourKitchenOrders() throws Exception {
        return fabricCutingBO.getAllOrdersColouKitchen();
    }

    @Override
    public List<OrderDTO> getsupervisorOrders() throws Exception {
        return fabricCutingBO.getAllOrdersSupervisor();
    }

    @Override
    public List<OrderDTO> getFabricOrders() throws Exception {
        return fabricCutingBO.getAllOrdersFabricUnit();
    }

    @Override
    public void notifyObservers() throws Exception {
        new Thread(() -> {
            for (Observer observer : alObservers) {

               
                try {
                    observer.updateObservers();
                } catch (Exception ex) {
                    Logger.getLogger(FabricCuttingServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                

            }
        }).start();
    }

    @Override
    public List<OrderDTO> searchName(String name) throws Exception {
        return fabricCutingBO.searchName(name);
    }

    @Override
    public List<OrderDTO> getOrdersFinished() throws Exception {
        return fabricCutingBO.getAllOrdersFinished();
    }

    @Override
    public List<OrderDTO> getOrdersDamage() throws Exception {
        return fabricCutingBO.getAllOrdersDamaged();
    }

    @Override
    public int getOrderDetail() throws Exception {
        System.out.println(fabricCutingBO.getOrderDetail());
        return fabricCutingBO.getOrderDetail();
        
    }

}
