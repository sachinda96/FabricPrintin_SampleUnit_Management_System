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
public class SupervisorOrder extends SuperDTO{
    private OrderDTO orderdto;
    private ColourDTO colourdto;

    public SupervisorOrder() {
    }

    public SupervisorOrder(OrderDTO orderdto, ColourDTO colourdto) {
        this.orderdto = orderdto;
        this.colourdto = colourdto;
    }

    /**
     * @return the orderdto
     */
    public OrderDTO getOrderdto() {
        return orderdto;
    }

    /**
     * @param orderdto the orderdto to set
     */
    public void setOrderdto(OrderDTO orderdto) {
        this.orderdto = orderdto;
    }

    /**
     * @return the colourdto
     */
    public ColourDTO getColourdto() {
        return colourdto;
    }

    /**
     * @param colourdto the colourdto to set
     */
    public void setColourdto(ColourDTO colourdto) {
        this.colourdto = colourdto;
    }
    
    
}
