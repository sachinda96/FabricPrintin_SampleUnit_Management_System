/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Sachinda Nipun
 */
@Entity
public class Fabric {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int FabricId;
    private String FabricName;
    private String FabricTypes;
    private String FabricItem;
    private String Colorway;

    public Fabric() {
    }

    public Fabric(int FabricId, String FabricName, String FabricTypes, String FabricItem, String Colorway) {
        this.FabricId = FabricId;
        this.FabricName = FabricName;
        this.FabricTypes = FabricTypes;
        this.FabricItem = FabricItem;
        this.Colorway = Colorway;
    }

    /**
     * @return the FabricId
     */
    public int getFabricId() {
        return FabricId;
    }

    /**
     * @param FabricId the FabricId to set
     */
    public void setFabricId(int FabricId) {
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
