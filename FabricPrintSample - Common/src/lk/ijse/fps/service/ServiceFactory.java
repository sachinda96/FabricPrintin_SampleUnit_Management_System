/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.service;

import java.rmi.Remote;

/**
 *
 * @author sachinda nipun
 */
public interface ServiceFactory extends Remote{
    
    public enum ServiceTypes{
        CUSTOMER,ITEM,OrderQueuService,FabricQueuService,ColorQueuService,COLORS,SUPERVISORQUEU,ORDERS,FABRIC,DESIGN,FABRICCUTTING,LOGIN,REPORT
    }
    
    public SuperService getService(ServiceTypes type) throws Exception;
    
}
