/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Sachinda nipun
 */
@Entity
public class OrderDetail implements Serializable{
    private double Price;
    private String orderDate;
    private String DeliveryDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DesignID",referencedColumnName = "DesignID",insertable = false,updatable = false)
    private Design design;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId",referencedColumnName = "orderId",insertable = false,updatable = false)
    private Orders orders;
    @EmbeddedId
    private OrderDetail_PK orderDetail_PK;

    public OrderDetail() {
    }

    public OrderDetail(double Price, String orderDate, String DeliveryDate, Design design, Orders orders, OrderDetail_PK orderDetail_PK) {
        this.Price = Price;
        this.orderDate = orderDate;
        this.DeliveryDate = DeliveryDate;
        this.design = design;
        this.orders = orders;
        this.orderDetail_PK = orderDetail_PK;
    }

    /**
     * @return the Price
     */
    public double getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(double Price) {
        this.Price = Price;
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
     * @return the DeliveryDate
     */
    public String getDeliveryDate() {
        return DeliveryDate;
    }

    /**
     * @param DeliveryDate the DeliveryDate to set
     */
    public void setDeliveryDate(String DeliveryDate) {
        this.DeliveryDate = DeliveryDate;
    }

    /**
     * @return the design
     */
    public Design getDesign() {
        return design;
    }

    /**
     * @param design the design to set
     */
    public void setDesign(Design design) {
        this.design = design;
    }

    /**
     * @return the orders
     */
    public Orders getOrders() {
        return orders;
    }

    /**
     * @param orders the orders to set
     */
    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    /**
     * @return the orderDetail_PK
     */
    public OrderDetail_PK getOrderDetail_PK() {
        return orderDetail_PK;
    }

    /**
     * @param orderDetail_PK the orderDetail_PK to set
     */
    public void setOrderDetail_PK(OrderDetail_PK orderDetail_PK) {
        this.orderDetail_PK = orderDetail_PK;
    }

    

   
}
