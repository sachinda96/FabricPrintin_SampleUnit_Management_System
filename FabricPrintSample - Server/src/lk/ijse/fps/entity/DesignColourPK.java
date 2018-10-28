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
 * @author Sachinda Nipun
 */
@Embeddable
public class DesignColourPK implements Serializable{
    private String DesignID;
    private String colorId;

    public DesignColourPK() {
    }

    public DesignColourPK(String DesignID, String colorId) {
        this.DesignID = DesignID;
        this.colorId = colorId;
    }

    /**
     * @return the DesignID
     */
    public String getDesignID() {
        return DesignID;
    }

    /**
     * @param DesignID the DesignID to set
     */
    public void setDesignID(String DesignID) {
        this.DesignID = DesignID;
    }

    /**
     * @return the colorId
     */
    public String getColorId() {
        return colorId;
    }

    /**
     * @param colorId the colorId to set
     */
    public void setColorId(String colorId) {
        this.colorId = colorId;
    }
    
    
}
