/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.dto;

/**
 *
 * @author ranjith-suranga
 */
public class ItemDTO extends SuperDTO{
    
    private String code;
    private String description;
    private double unitPrice;
    private int qytOnHand;

    public ItemDTO() {
    }

    public ItemDTO(String code, String description, double unitPrice, int qytOnHand) {
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qytOnHand = qytOnHand;
    }
    
    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the qytOnHand
     */
    public int getQytOnHand() {
        return qytOnHand;
    }

    /**
     * @param qytOnHand the qytOnHand to set
     */
    public void setQytOnHand(int qytOnHand) {
        this.qytOnHand = qytOnHand;
    }

    @Override
    public String toString() {
        return "ItemDTO{" + "code=" + code + ", description=" + description + ", unitPrice=" + unitPrice + ", qytOnHand=" + qytOnHand + '}';
    }
    
    
}
