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
import lk.ijse.fps.buisness.custom.ColourQueu;
import lk.ijse.fps.dto.ColourQueuDTO;
import lk.ijse.fps.observer.Observer;
import lk.ijse.fps.observer.Subject;
import lk.ijse.fps.service.custom.ColorQueuService;

/**
 *
 * @author Sachinda Nipun
 */
public class colorqueuServiceImpl extends UnicastRemoteObject implements ColorQueuService,Subject{
     private ColourQueu colourQueu;
     private static List<Observer> observers = new ArrayList<>();
     
     
     public colorqueuServiceImpl()throws RemoteException{
     colourQueu=(ColourQueu) BOFactory.getInstance().getBO(BOFactory.BOTypes.COLORFACRORY);
     }
    
    @Override
    public boolean addColourseQueue(ColourQueuDTO colourQueu) throws Exception {
        boolean addColours= this.colourQueu.addColourseQueue(colourQueu);
        if (addColours) {
            notifyObservers();
        }
        return addColours;
    }

    @Override
    public boolean removeColourseQueue(ColourQueuDTO colourQueu) throws Exception {
       boolean removeColours= this.colourQueu.removeColourseQueue(colourQueu);
        if (removeColours) {
            notifyObservers();
        }
        return removeColours;
    }

    @Override
    public ColourQueuDTO getColourse() throws Exception {
        ColourQueuDTO color=this.colourQueu.getColourse();
        notifyObservers();
        return color;
    }

    @Override
    public List<ColourQueuDTO> getColourseList() throws Exception {
        return colourQueu.getColourseList();
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
