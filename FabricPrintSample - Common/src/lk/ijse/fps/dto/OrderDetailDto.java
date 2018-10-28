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
public class OrderDetailDto extends SuperDTO{
    private int detailId;
    private double Price;
    private String orderDate;
    private String DeliveryDate;
    private DesignDTO item;
    private OrderDTO orders;
    private OrderDetail_PKDto orderDetail_PKDto;

    public OrderDetailDto() {
    }

    public OrderDetailDto(int detailId, double Price, String orderDate, String DeliveryDate, DesignDTO item, OrderDTO orders, OrderDetail_PKDto orderDetail_PKDto) {
        this.detailId = detailId;
        this.Price = Price;
        this.orderDate = orderDate;
        this.DeliveryDate = DeliveryDate;
        this.item = item;
        this.orders = orders;
        this.orderDetail_PKDto = orderDetail_PKDto;
    }

    /**
     * @return the detailId
     */
    public int getDetailId() {
        return detailId;
    }

    /**
     * @param detailId the detailId to set
     */
    public void setDetailId(int detailId) {
        this.detailId = detailId;
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
     * @return the item
     */
    public DesignDTO getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(DesignDTO item) {
        this.item = item;
    }

    /**
     * @return the orders
     */
    public OrderDTO getOrders() {
        return orders;
    }

    /**
     * @param orders the orders to set
     */
    public void setOrders(OrderDTO orders) {
        this.orders = orders;
    }

    /**
     * @return the orderDetail_PKDto
     */
    public OrderDetail_PKDto getOrderDetail_PKDto() {
        return orderDetail_PKDto;
    }

    /**
     * @param orderDetail_PKDto the orderDetail_PKDto to set
     */
    public void setOrderDetail_PKDto(OrderDetail_PKDto orderDetail_PKDto) {
        this.orderDetail_PKDto = orderDetail_PKDto;
    }

   
}
