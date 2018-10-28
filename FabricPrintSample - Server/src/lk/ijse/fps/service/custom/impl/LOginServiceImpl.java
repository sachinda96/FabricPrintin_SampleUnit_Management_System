/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import lk.ijse.fps.buisness.BOFactory;
import lk.ijse.fps.buisness.custom.LOginBO;
import lk.ijse.fps.dto.LoginAccountDTO;
import lk.ijse.fps.service.custom.LOginService;

/**
 *
 * @author Sachinda Nipun
 */
public class LOginServiceImpl extends UnicastRemoteObject implements LOginService{

    private LOginBO loginBo;
    
    public LOginServiceImpl()throws RemoteException{
        loginBo=(LOginBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.LOGIN);
    }
    @Override
    public boolean addAccount(LoginAccountDTO log) throws Exception {
        return loginBo.addAccount(log);
    }

    @Override
    public LoginAccountDTO searchUnit(String unitName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LoginAccountDTO> searchUserName(String Name) throws Exception {
        return  loginBo.searchName(Name);
    }

    @Override
    public LoginAccountDTO searchPassword(String Password) throws Exception {
        return loginBo.getlogs(Password);
    }

    @Override
    public List<LoginAccountDTO> getlogs() throws Exception {
        return null;
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
