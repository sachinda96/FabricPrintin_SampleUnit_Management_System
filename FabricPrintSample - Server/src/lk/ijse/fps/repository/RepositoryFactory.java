/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.repository;

import lk.ijse.fps.repository.custom.CustomerRepository;
import lk.ijse.fps.repository.custom.impl.ColorReposistryImpl;
import lk.ijse.fps.repository.custom.impl.CustomerRepositoryImpl;
import lk.ijse.fps.repository.custom.impl.DesignReposistryImpl;
import lk.ijse.fps.repository.custom.impl.FabricCusttingReposistryIml;
import lk.ijse.fps.repository.custom.impl.FabricReposisitryImpl;
import lk.ijse.fps.repository.custom.impl.ItemRepositoryImpl;
import lk.ijse.fps.repository.custom.impl.LoginReposistryImpl;
import lk.ijse.fps.repository.custom.impl.OrderDetailReposistryImpl;
import lk.ijse.fps.repository.custom.impl.OrderReposistryImpl;
import lk.ijse.fps.repository.custom.LoginReposistry;

/**
 *
 * @author Sachinda nipun
 */
public class RepositoryFactory {
    
    public enum RepositoryTypes{
        CUSTOMER, ITEM,COLOR,ORDERS,FABRIC,DESIGN,ORDERDETAILS,FABRICCUTTING,LOGIN
    }
    
    public static RepositoryFactory repositoryFactory;
    
    private RepositoryFactory(){
        
    }
    
    public static RepositoryFactory getInstance(){
        if (repositoryFactory == null){
            repositoryFactory = new RepositoryFactory();
        }
        return repositoryFactory;
    }
    
    public SuperRepository getRepository(RepositoryTypes type){
        switch (type){
            case CUSTOMER:
                return new CustomerRepositoryImpl();
            case ITEM:
                return new ItemRepositoryImpl();
            case COLOR:
                return new ColorReposistryImpl();
            case ORDERS:
                return new OrderReposistryImpl();
            case FABRIC:
                return new FabricReposisitryImpl();
            case DESIGN:
                return new DesignReposistryImpl();
            case ORDERDETAILS:
                return new OrderDetailReposistryImpl();
            case FABRICCUTTING:
                return new FabricCusttingReposistryIml();
            case LOGIN:
                return new LoginReposistryImpl();
            default: 
                return null;
        }
    }
    
}
