/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lk.ijse.fps.repository.custom.impl.LoginReposistryImpl;
import lk.ijse.fps.service.ServiceFactory;
import lk.ijse.fps.service.SuperService;
import lk.ijse.fps.service.custom.SupervisorQueuService;
import lk.ijse.fps.service.custom.impl.ColorServiceImpl;
import lk.ijse.fps.service.custom.impl.CustomerServiceImpl;
import lk.ijse.fps.service.custom.impl.DesignServiceImpl;
import lk.ijse.fps.service.custom.impl.FabricCuttingServiceImpl;
import lk.ijse.fps.service.custom.impl.FabricServiceImpl;
import lk.ijse.fps.service.custom.impl.FabricqueuServiceImpl;
import lk.ijse.fps.service.custom.impl.ItemServiceImpl;
import lk.ijse.fps.service.custom.impl.LOginServiceImpl;
import lk.ijse.fps.service.custom.impl.OrderServiceImpl;
import lk.ijse.fps.service.custom.impl.OrderqueuServiceImpl;
import lk.ijse.fps.service.custom.impl.ReportServiceImpl;
import lk.ijse.fps.service.custom.impl.SupervisorQueuSerivceImpl;
import lk.ijse.fps.service.custom.impl.colorqueuServiceImpl;

/**
 *
 * @author ranjith-suranga
 */
public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory {

    public static ServiceFactory serviceFactory;

    private ServiceFactoryImpl() throws RemoteException {

    }

    public static ServiceFactory getInstance() throws RemoteException {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactoryImpl();
        }
        return serviceFactory;
    }

    @Override
    public SuperService getService(ServiceTypes type) throws Exception {
        switch (type) {
            case CUSTOMER:
                return new CustomerServiceImpl();
            case ITEM:
                return new ItemServiceImpl();
            case OrderQueuService:
                return new OrderqueuServiceImpl();
            case FabricQueuService:
                return new FabricqueuServiceImpl();
            case ColorQueuService:
                return new colorqueuServiceImpl();
            case COLORS:
                return new ColorServiceImpl();
            case SUPERVISORQUEU:
                return new SupervisorQueuSerivceImpl();
            case ORDERS:
                return new OrderServiceImpl();
            case FABRIC:
                return new FabricServiceImpl();
            case DESIGN:
                return new DesignServiceImpl();
            case FABRICCUTTING:
                return new FabricCuttingServiceImpl();
            case LOGIN:
                return new LOginServiceImpl();
            case REPORT:
                return new ReportServiceImpl();
            default:
                return null;
        }
    }

}
