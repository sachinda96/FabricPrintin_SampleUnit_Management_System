/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.ManyToAny;

/**
 *
 * @author Sachinda Nipun
 */
@Entity
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int colorId;
    private String description;
    private String technicType;

    public Color() {
    }

    public Color(int colorId, String description, String technicType) {
        this.colorId = colorId;
        this.description = description;
        this.technicType = technicType;
    }

    /**
     * @return the colorId
     */
    public int getColorId() {
        return colorId;
    }

    /**
     * @param colorId the colorId to set
     */
    public void setColorId(int colorId) {
        this.colorId = colorId;
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
     * @return the technicType
     */
    public String getTechnicType() {
        return technicType;
    }

    /**
     * @param technicType the technicType to set
     */
    public void setTechnicType(String technicType) {
        this.technicType = technicType;
    }
    
    
   
}
