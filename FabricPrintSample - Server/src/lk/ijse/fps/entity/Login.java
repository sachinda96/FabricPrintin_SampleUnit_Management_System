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

/**
 *
 * @author Sachinda Nipun
 */
@Entity
public class Login {
    @Id
    private String CompanyId;
    private String Unit;
    private String userName;
    private String passsowrd;

    public Login() {
    }

    public Login(String CompanyId, String Unit, String userName, String passsowrd) {
        this.CompanyId = CompanyId;
        this.Unit = Unit;
        this.userName = userName;
        this.passsowrd = passsowrd;
    }

    /**
     * @return the CompanyId
     */
    public String getCompanyId() {
        return CompanyId;
    }

    /**
     * @param CompanyId the CompanyId to set
     */
    public void setCompanyId(String CompanyId) {
        this.CompanyId = CompanyId;
    }

    /**
     * @return the Unit
     */
    public String getUnit() {
        return Unit;
    }

    /**
     * @param Unit the Unit to set
     */
    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the passsowrd
     */
    public String getPasssowrd() {
        return passsowrd;
    }

    /**
     * @param passsowrd the passsowrd to set
     */
    public void setPasssowrd(String passsowrd) {
        this.passsowrd = passsowrd;
    }

    
}
