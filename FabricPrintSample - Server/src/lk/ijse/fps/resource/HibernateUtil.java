/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.resource;

import java.io.File;
import lk.ijse.fps.entity.Color;
import lk.ijse.fps.entity.Customer;
import lk.ijse.fps.entity.Design;
import lk.ijse.fps.entity.DesignDetails;
import lk.ijse.fps.entity.Fabric;
import lk.ijse.fps.entity.FabricCutting;
import lk.ijse.fps.entity.Item;
import lk.ijse.fps.entity.Login;
import lk.ijse.fps.entity.OrderDetail;
import lk.ijse.fps.entity.Orders;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Sachinda nipun
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    private static StandardServiceRegistry registry;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            
            // (1) 
            File hibernateProperties = new File("settings/hibernate.properties");
            registry = new StandardServiceRegistryBuilder().loadProperties(hibernateProperties).build();
            
            // (2)
            sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(Customer.class)
                    //.addAnnotatedClass(Item.class)
                    .addAnnotatedClass(Color.class)
                    .addAnnotatedClass(Orders.class)
                    .addAnnotatedClass(Fabric.class)
                    .addAnnotatedClass(Design.class)
                    .addAnnotatedClass(OrderDetail.class)
                    .addAnnotatedClass(FabricCutting.class)
                    .addAnnotatedClass(Login.class)
                    .buildMetadata().buildSessionFactory();
            
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            
            StandardServiceRegistryBuilder.destroy(registry);
            
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
