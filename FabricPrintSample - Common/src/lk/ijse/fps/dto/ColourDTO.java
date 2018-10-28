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
public class ColourDTO extends SuperDTO{
    private String ColurId;
    private String ClourDescription;
    private String technicType;

    public ColourDTO() {
    }

    /**
     * @return the ColurId
     */
    public String getColurId() {
        return ColurId;
    }

    /**
     * @param ColurId the ColurId to set
     */
    public void setColurId(String ColurId) {
        this.ColurId = ColurId;
    }

    /**
     * @return the ClourDescription
     */
    public String getClourDescription() {
        return ClourDescription;
    }

    /**
     * @param ClourDescription the ClourDescription to set
     */
    public void setClourDescription(String ClourDescription) {
        this.ClourDescription = ClourDescription;
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
