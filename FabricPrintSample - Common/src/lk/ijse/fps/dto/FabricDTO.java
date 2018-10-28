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
public class FabricDTO extends SuperDTO{
    private String FabricId;
    private String FabricName;
    private String FabricTypes;
    private String FabricItem;
    private String Colorway;

    public FabricDTO() {
    }

    public FabricDTO(String FabricId, String FabricName, String FabricTypes, String FabricItem, String Colorway) {
        this.FabricId = FabricId;
        this.FabricName = FabricName;
        this.FabricTypes = FabricTypes;
        this.FabricItem = FabricItem;
        this.Colorway = Colorway;
    }

    /**
     * @return the FabricId
     */
    public String getFabricId() {
        return FabricId;
    }

    /**
     * @param FabricId the FabricId to set
     */
    public void setFabricId(String FabricId) {
        this.FabricId = FabricId;
    }

    /**
     * @return the FabricName
     */
    public String getFabricName() {
        return FabricName;
    }

    /**
     * @param FabricName the FabricName to set
     */
    public void setFabricName(String FabricName) {
        this.FabricName = FabricName;
    }

    /**
     * @return the FabricTypes
     */
    public String getFabricTypes() {
        return FabricTypes;
    }

    /**
     * @param FabricTypes the FabricTypes to set
     */
    public void setFabricTypes(String FabricTypes) {
        this.FabricTypes = FabricTypes;
    }

    /**
     * @return the FabricItem
     */
    public String getFabricItem() {
        return FabricItem;
    }

    /**
     * @param FabricItem the FabricItem to set
     */
    public void setFabricItem(String FabricItem) {
        this.FabricItem = FabricItem;
    }

    /**
     * @return the Colorway
     */
    public String getColorway() {
        return Colorway;
    }

    /**
     * @param Colorway the Colorway to set
     */
    public void setColorway(String Colorway) {
        this.Colorway = Colorway;
    }
    
    

}
