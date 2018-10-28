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
public class OrderDTO extends SuperDTO{
    
    private int orderId;
    private String orderDate;
    private String orderQty;
    private String CustomerId;
    private String CustomerName;
    private String customerTelephone;
    private String designId;
    private String designName;
    private String DesignType;
    private String fabricId;
    private String fabricName;
    private String fabricQty;
    private byte [] Image;
    private String Available;
    private String Stage;
    private String PribtingTechnic;
    private String printingMethod;
    private CustomerDTO customerDTO;

    public OrderDTO() {
    }

    public OrderDTO(int orderId, String orderDate, String orderQty, String CustomerId, String CustomerName, String customerTelephone, String designId, String designName, String DesignType, String fabricId, String fabricName, String fabricQty, byte[] Image, String Available, String Stage, String PribtingTechnic, String printingMethod, CustomerDTO customerDTO) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderQty = orderQty;
        this.CustomerId = CustomerId;
        this.CustomerName = CustomerName;
        this.customerTelephone = customerTelephone;
        this.designId = designId;
        this.designName = designName;
        this.DesignType = DesignType;
        this.fabricId = fabricId;
        this.fabricName = fabricName;
        this.fabricQty = fabricQty;
        this.Image = Image;
        this.Available = Available;
        this.Stage = Stage;
        this.PribtingTechnic = PribtingTechnic;
        this.printingMethod = printingMethod;
        this.customerDTO = customerDTO;
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
     * @return the CustomerId
     */
    public String getCustomerId() {
        return CustomerId;
    }

    /**
     * @param CustomerId the CustomerId to set
     */
    public void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
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
     * @return the customerTelephone
     */
    public String getCustomerTelephone() {
        return customerTelephone;
    }

    /**
     * @param customerTelephone the customerTelephone to set
     */
    public void setCustomerTelephone(String customerTelephone) {
        this.customerTelephone = customerTelephone;
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
     * @return the fabricId
     */
    public String getFabricId() {
        return fabricId;
    }

    /**
     * @param fabricId the fabricId to set
     */
    public void setFabricId(String fabricId) {
        this.fabricId = fabricId;
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
     * @return the Image
     */
    public byte[] getImage() {
        return Image;
    }

    /**
     * @param Image the Image to set
     */
    public void setImage(byte[] Image) {
        this.Image = Image;
    }

    /**
     * @return the Available
     */
    public String getAvailable() {
        return Available;
    }

    /**
     * @param Available the Available to set
     */
    public void setAvailable(String Available) {
        this.Available = Available;
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

    /**
     * @return the customerDTO
     */
    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    /**
     * @param customerDTO the customerDTO to set
     */
    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    
   
}
