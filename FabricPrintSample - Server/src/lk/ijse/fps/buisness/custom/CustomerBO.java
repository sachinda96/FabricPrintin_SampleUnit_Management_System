/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom;

import java.util.List;
import lk.ijse.fps.buisness.SuperBO;
import lk.ijse.fps.dto.CustomerDTO;

/**
 *
 * @author ranjith-suranga
 */
public interface CustomerBO extends SuperBO{
    
    public boolean addCustomer(CustomerDTO customer) throws Exception;
    
    public boolean updateCustomer(CustomerDTO customer) throws Exception;
    
    public boolean deleteCustomer(Integer customerID) throws Exception;
    
    public CustomerDTO getCustomerID(String name) throws Exception;
    
    public List<CustomerDTO> getAllCustomers() throws Exception;
    
}
