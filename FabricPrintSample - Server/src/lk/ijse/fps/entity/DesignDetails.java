/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.entity;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Sachinda Nipun
 */
@Entity
public class DesignDetails {
    private String DesignName;
    private String colourName;
    private String Technic;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DesignID",referencedColumnName = "itemCode",insertable = false,updatable = false)
    private Design design;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "colorId",referencedColumnName = "colorId",insertable = false,updatable = false)
    private Color color;
    @EmbeddedId
    private DesignColourPK designColourPK;

    public DesignDetails() {
    }

    public DesignDetails(String DesignName, String colourName, String Technic, Design design, Color color) {
        this.DesignName = DesignName;
        this.colourName = colourName;
        this.Technic = Technic;
        this.design = design;
        this.color = color;

    }

    public DesignDetails(String DesignName, String colourName, String Technic, Design design, Color color, DesignColourPK designColourPK) {
        this.DesignName = DesignName;
        this.colourName = colourName;
        this.Technic = Technic;
        this.design = design;
        this.color = color;
        this.designColourPK = designColourPK;
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
     * @return the colourName
     */
    public String getColourName() {
        return colourName;
    }

    /**
     * @param colourName the colourName to set
     */
    public void setColourName(String colourName) {
        this.colourName = colourName;
    }

    /**
     * @return the Technic
     */
    public String getTechnic() {
        return Technic;
    }

    /**
     * @param Technic the Technic to set
     */
    public void setTechnic(String Technic) {
        this.Technic = Technic;
    }

    /**
     * @return the design
     */
    public Design getDesign() {
        return design;
    }

    /**
     * @param design the design to set
     */
    public void setDesign(Design design) {
        this.design = design;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the designColourPK
     */
    public DesignColourPK getDesignColourPK() {
        return designColourPK;
    }

    /**
     * @param designColourPK the designColourPK to set
     */
    public void setDesignColourPK(DesignColourPK designColourPK) {
        this.designColourPK = designColourPK;
    }
    
    
}
