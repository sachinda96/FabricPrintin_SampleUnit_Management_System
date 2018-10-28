/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Sachinda Nipun
 * 
 */
@Entity
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String Firstname;
    private String Lastname;
    private String Company;
    private String telNumber;
    private String Email;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Orders> orders;

    public Customer() {
    }

    public Customer(int id, String Firstname, String Lastname, String Company, String telNumber, String Email, List<Orders> orders) {
        this.id = id;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Company = Company;
        this.telNumber = telNumber;
        this.Email = Email;
        this.orders = orders;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the Firstname
     */
    public String getFirstname() {
        return Firstname;
    }

    /**
     * @param Firstname the Firstname to set
     */
    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    /**
     * @return the Lastname
     */
    public String getLastname() {
        return Lastname;
    }

    /**
     * @param Lastname the Lastname to set
     */
    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    /**
     * @return the Company
     */
    public String getCompany() {
        return Company;
    }

    /**
     * @param Company the Company to set
     */
    public void setCompany(String Company) {
        this.Company = Company;
    }

    /**
     * @return the telNumber
     */
    public String getTelNumber() {
        return telNumber;
    }

    /**
     * @param telNumber the telNumber to set
     */
    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the orders
     */
    public List<Orders> getOrders() {
        return orders;
    }

    /**
     * @param orders the orders to set
     */
    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

   
}
