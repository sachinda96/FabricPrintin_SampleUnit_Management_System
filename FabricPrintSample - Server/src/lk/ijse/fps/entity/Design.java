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
public class Design {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int DesignID;
    private String DesignNumber;
    private String DesignName;
    private String DesignType;
    private byte [] Images;

    public Design() {
    }

    public Design(int DesignID, String DesignNumber, String DesignName, String DesignType, byte[] Images) {
        this.DesignID = DesignID;
        this.DesignNumber = DesignNumber;
        this.DesignName = DesignName;
        this.DesignType = DesignType;
        this.Images = Images;
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
     * @return the DesignNumber
     */
    public String getDesignNumber() {
        return DesignNumber;
    }

    /**
     * @param DesignNumber the DesignNumber to set
     */
    public void setDesignNumber(String DesignNumber) {
        this.DesignNumber = DesignNumber;
    }

    /**
     * @return the DesignName
     */
    public String getDesignName() {
        return DesignName;
    }

    /**
     * @param DesignName the DesignName to set
     */
    public void setDesignName(String DesignName) {
        this.DesignName = DesignName;
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
     * @return the Images
     */
    public byte[] getImages() {
        return Images;
    }

    /**
     * @param Images the Images to set
     */
    public void setImages(byte[] Images) {
        this.Images = Images;
    }

  
   
}
