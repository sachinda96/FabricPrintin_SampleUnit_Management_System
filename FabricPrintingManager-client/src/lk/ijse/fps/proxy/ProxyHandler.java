/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.proxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.fps.service.ServiceFactory;
import lk.ijse.fps.service.SuperService;
import lk.ijse.fps.service.custom.ColorQueuService;
import lk.ijse.fps.service.custom.ColorService;
import lk.ijse.fps.service.custom.CustomerService;
import lk.ijse.fps.service.custom.DesignService;
import lk.ijse.fps.service.custom.FabricCuttingService;
import lk.ijse.fps.service.custom.FabricQueuService;
import lk.ijse.fps.service.custom.FabricService;
import lk.ijse.fps.service.custom.LOginService;
import lk.ijse.fps.service.custom.OrderQueuService;
import lk.ijse.fps.service.custom.OrderService;
import lk.ijse.fps.service.custom.RepoerService;
import lk.ijse.fps.service.custom.SupervisorQueuService;

/**
 *
 * @author Sachinda nipun
 */
public class ProxyHandler implements ServiceFactory {

    private static ProxyHandler proxyHandler;
    private ServiceFactory serviceFactory;
    private CustomerService customerService;
    private OrderQueuService orderQueuService;
    private FabricQueuService fabricQueuService;
    private ColorQueuService colorQueuService;
    private ColorService colorService;
    private SupervisorQueuService supervisorQueuService;
    private OrderService orderService;
    private FabricService fabricService;
    private DesignService designService;
    private FabricCuttingService fabricCuttingService;
    private LOginService lOginService;
    private RepoerService repoerService;

    private ProxyHandler() {
        try {
            serviceFactory = (ServiceFactory) Naming.lookup("rmi://localhost:5050/pos");
            customerService = (CustomerService) serviceFactory.getService(ServiceTypes.CUSTOMER);
            orderQueuService = (OrderQueuService) serviceFactory.getService(ServiceTypes.OrderQueuService);
            fabricQueuService = (FabricQueuService) serviceFactory.getService(ServiceTypes.FabricQueuService);
            colorQueuService = (ColorQueuService) serviceFactory.getService(ServiceTypes.ColorQueuService);
            supervisorQueuService = (SupervisorQueuService) serviceFactory.getService(ServiceTypes.SUPERVISORQUEU);
            fabricService = (FabricService) serviceFactory.getService(ServiceTypes.FABRIC);
            orderService = (OrderService) serviceFactory.getService(ServiceTypes.ORDERS);
            colorService = (ColorService) serviceFactory.getService(ServiceTypes.COLORS);
            fabricCuttingService = (FabricCuttingService) serviceFactory.getService(ServiceTypes.FABRICCUTTING);
            designService = (DesignService) serviceFactory.getService(ServiceTypes.DESIGN);
            lOginService = (LOginService) serviceFactory.getService(ServiceTypes.LOGIN);
            repoerService = (RepoerService) serviceFactory.getService(ServiceTypes.REPORT);
        } catch (NotBoundException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ProxyHandler getInstance() {
        if (proxyHandler == null) {
            proxyHandler = new ProxyHandler();
        }
        return proxyHandler;
    }

    @Override
    public SuperService getService(ServiceTypes type) throws Exception {
        switch (type) {
            case CUSTOMER:
                return customerService;
            case OrderQueuService:
                return orderQueuService;
            case FabricQueuService:
                return fabricQueuService;
            case ColorQueuService:
                return colorQueuService;
            case COLORS:
                return colorService;
            case SUPERVISORQUEU:
                return supervisorQueuService;
            case ORDERS:
                return orderService;
            case FABRIC:
                return fabricService;
            case DESIGN:
                return designService;
            case FABRICCUTTING:
                return fabricCuttingService;
            case LOGIN:
                return lOginService;
            case REPORT:
                return repoerService;
            default:
                return null;
        }
    }

}
