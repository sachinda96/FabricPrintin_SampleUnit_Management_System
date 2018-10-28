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
import lk.ijse.fps.buisness.BOFactory;
import lk.ijse.fps.buisness.custom.ColorBO;
import lk.ijse.fps.dto.ColourDTO;
import lk.ijse.fps.observer.Observer;
import lk.ijse.fps.observer.Subject;
import lk.ijse.fps.service.custom.ColorService;

/**
 *
 * @author Sachinda Nipun
 */
public class ColorServiceImpl extends UnicastRemoteObject implements ColorService,Subject{
    private ColorBO colorBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    
    public ColorServiceImpl()throws RemoteException{
        colorBO=(ColorBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.COLORS);
    }
    @Override
    public boolean addColor(ColourDTO Color) throws Exception {
        System.out.println("test 2");
        boolean added=this.colorBO.addColor(Color);
        System.out.println("test 3");
        if (added) {
            notifyObservers();
        }
        return added;
    }

    @Override
    public boolean deleteColor(String ColorID) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateColor(ColourDTO Color) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ColourDTO> getAllColor() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        for (Observer alObserver : alObservers) {
            alObserver.updateObservers();
        }
    }

    @Override
    public boolean viewcolorId(Integer designID) throws Exception {
        return colorBO.viewcolourId(designID);
    }
    
}
