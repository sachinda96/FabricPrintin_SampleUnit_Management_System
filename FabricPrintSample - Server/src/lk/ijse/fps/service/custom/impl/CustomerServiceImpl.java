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
import lk.ijse.fps.buisness.custom.CustomerBO;
import lk.ijse.fps.dto.CustomerDTO;
import lk.ijse.fps.observer.Observer;
import lk.ijse.fps.observer.Subject;
import lk.ijse.fps.reservation.Reservation;
import lk.ijse.fps.reservation.impl.ReservationImpl;
import lk.ijse.fps.service.custom.CustomerService;

/**
 *
 * @author Sachinda Nipun
 */
public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService, Subject {

    private CustomerBO customerBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<CustomerService> cusResBook = new ReservationImpl<>();

    public CustomerServiceImpl() throws RemoteException {
        customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
    }

    @Override
    public boolean addCustomer(CustomerDTO customer) throws Exception {
        boolean result = customerBO.addCustomer(customer);
        notifyObservers();
        return result;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
        return customerBO.getAllCustomers();
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
                    Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    @Override
    public boolean deleteCustomer(Integer customerID) throws Exception {
        boolean result = false;
        if (cusResBook.reserve(customerID, this, true)) {
            result = customerBO.deleteCustomer(customerID);
            notifyObservers();
            if (cusResBook.isInternalReservation(customerID)){
                release(customerID);
            }
        }
        return result;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) throws Exception {
        boolean result = false;
        if (cusResBook.reserve(customer.getCustomerID(), this, true)) {
            result = customerBO.updateCustomer(customer);
            notifyObservers();
            if (cusResBook.isInternalReservation(customer.getCustomerID())){
                release(customer.getCustomerID());
            }            
        }
        return result;
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        System.out.println("sucsess"+id);
        return cusResBook.reserve(id, this, false);
    }

    @Override
    public boolean release(Object id) throws Exception {
       System.out.println("relise"+id);
        return cusResBook.release(id);
    }

}
