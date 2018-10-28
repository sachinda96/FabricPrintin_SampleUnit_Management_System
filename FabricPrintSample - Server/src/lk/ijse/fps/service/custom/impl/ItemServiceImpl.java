/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lk.ijse.fps.buisness.BOFactory;
import lk.ijse.fps.buisness.custom.ItemBO;
import lk.ijse.fps.dto.ItemDTO;
import lk.ijse.fps.service.custom.ItemService;

/**
 *
 * @author ranjith-suranga
 */
public class ItemServiceImpl extends UnicastRemoteObject implements ItemService{
    
    private ItemBO itemBO;
    
    public ItemServiceImpl()throws RemoteException{
        itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);
    }

    @Override
    public boolean addItem(ItemDTO item) throws Exception {
        return itemBO.addItem(item);
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
