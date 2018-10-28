/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.dto;

/**
 *
 * @author Sachinda Nipun
 */
public class OrderDetail_PKDto extends SuperDTO{
    private int DesigID;
    private int OrderId;

    public OrderDetail_PKDto() {
    }

    public OrderDetail_PKDto(int DesigID, int OrderId) {
        this.DesigID = DesigID;
        this.OrderId = OrderId;
    }

    /**
     * @return the DesigID
     */
    public int getDesigID() {
        return DesigID;
    }

    /**
     * @param DesigID the DesigID to set
     */
    public void setDesigID(int DesigID) {
        this.DesigID = DesigID;
    }

    /**
     * @return the OrderId
     */
    public int getOrderId() {
        return OrderId;
    }

    /**
     * @param OrderId the OrderId to set
     */
    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }

   
}
