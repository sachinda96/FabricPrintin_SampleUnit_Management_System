/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.service.custom;

import java.util.List;
import lk.ijse.fps.dto.CustomerDTO;
import lk.ijse.fps.reservation.Reservation;
import lk.ijse.fps.service.SuperService;

/**
 *
 * @author ranjith-suranga
 */
public interface CustomerService extends SuperService{
    
    public boolean addCustomer(CustomerDTO customer)throws Exception;
    
    public boolean deleteCustomer(Integer customerID) throws Exception;
    
    public boolean updateCustomer(CustomerDTO customer) throws Exception;
    
    public List<CustomerDTO> getAllCustomers() throws Exception;
        
}
