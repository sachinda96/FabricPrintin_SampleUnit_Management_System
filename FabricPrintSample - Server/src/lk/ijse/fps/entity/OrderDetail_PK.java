/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Gnanod-PC
 */
@Embeddable
public class OrderDetail_PK implements Serializable{
    private int DesignID;
    private int orderId;

    public OrderDetail_PK() {
    }

    public OrderDetail_PK(int DesignID, int orderId) {
        this.DesignID = DesignID;
        this.orderId = orderId;
    }

    /**
     * @return the DesignID
     */
    public int getDesignID() {
        return DesignID;
    }

    /**
     * @param DesignID the DesignID to set
     */
    public void setDesignID(int DesignID) {
        this.DesignID = DesignID;
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

    
}
