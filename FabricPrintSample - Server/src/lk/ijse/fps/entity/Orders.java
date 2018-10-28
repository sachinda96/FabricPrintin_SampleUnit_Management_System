/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Sachinda Nipun
 */
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private String orderDate;
    private String orderQty;
    private String FinshOrders;


    public Orders() {
    }

    public Orders(int orderId, String orderDate, String orderQty, String FinshOrders) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderQty = orderQty;
        this.FinshOrders = FinshOrders;
    }

    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the orderQty
     */
    public String getOrderQty() {
        return orderQty;
    }

    /**
     * @param orderQty the orderQty to set
     */
    public void setOrderQty(String orderQty) {
        this.orderQty = orderQty;
    }

    /**
     * @return the FinshOrders
     */
    public String getFinshOrders() {
        return FinshOrders;
    }

    /**
     * @param FinshOrders the FinshOrders to set
     */
    public void setFinshOrders(String FinshOrders) {
        this.FinshOrders = FinshOrders;
    }

    
   
}
