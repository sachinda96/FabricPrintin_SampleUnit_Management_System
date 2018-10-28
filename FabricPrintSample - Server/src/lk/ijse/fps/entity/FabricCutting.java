/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lk.ijse.fps.dto.CustomerDTO;

/**
 *
 * @author Sachinda Nipun
 */
@Entity
public class FabricCutting implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private String orderDate;
    private String orderQty;
    private String CustomerName;
    private String designId;
    private String designName;
    private String DesignType;
    private String fabricName;
    private String fabricQty;
    private String Stage;
    private String PribtingTechnic;
    private String printingMethod;

    public FabricCutting() {
    }

    public FabricCutting(int orderId, String orderDate, String orderQty, String CustomerName, String designId, String designName, String DesignType, String fabricName, String fabricQty, String Stage, String PribtingTechnic, String printingMethod) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderQty = orderQty;
        this.CustomerName = CustomerName;
        this.designId = designId;
        this.designName = designName;
        this.DesignType = DesignType;
        this.fabricName = fabricName;
        this.fabricQty = fabricQty;
        this.Stage = Stage;
        this.PribtingTechnic = PribtingTechnic;
        this.printingMethod = printingMethod;
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
     * @return the CustomerName
     */
    public String getCustomerName() {
        return CustomerName;
    }

    /**
     * @param CustomerName the CustomerName to set
     */
    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    /**
     * @return the designId
     */
    public String getDesignId() {
        return designId;
    }

    /**
     * @param designId the designId to set
     */
    public void setDesignId(String designId) {
        this.designId = designId;
    }

    /**
     * @return the designName
     */
    public String getDesignName() {
        return designName;
    }

    /**
     * @param designName the designName to set
     */
    public void setDesignName(String designName) {
        this.designName = designName;
    }

    /**
     * @return the DesignType
     */
    public String getDesignType() {
        return DesignType;
    }

    /**
     * @param DesignType the DesignType to set
     */
    public void setDesignType(String DesignType) {
        this.DesignType = DesignType;
    }

    /**
     * @return the fabricName
     */
    public String getFabricName() {
        return fabricName;
    }

    /**
     * @param fabricName the fabricName to set
     */
    public void setFabricName(String fabricName) {
        this.fabricName = fabricName;
    }

    /**
     * @return the fabricQty
     */
    public String getFabricQty() {
        return fabricQty;
    }

    /**
     * @param fabricQty the fabricQty to set
     */
    public void setFabricQty(String fabricQty) {
        this.fabricQty = fabricQty;
    }

    /**
     * @return the Stage
     */
    public String getStage() {
        return Stage;
    }

    /**
     * @param Stage the Stage to set
     */
    public void setStage(String Stage) {
        this.Stage = Stage;
    }

    /**
     * @return the PribtingTechnic
     */
    public String getPribtingTechnic() {
        return PribtingTechnic;
    }

    /**
     * @param PribtingTechnic the PribtingTechnic to set
     */
    public void setPribtingTechnic(String PribtingTechnic) {
        this.PribtingTechnic = PribtingTechnic;
    }

    /**
     * @return the printingMethod
     */
    public String getPrintingMethod() {
        return printingMethod;
    }

    /**
     * @param printingMethod the printingMethod to set
     */
    public void setPrintingMethod(String printingMethod) {
        this.printingMethod = printingMethod;
    }

   

   
}
