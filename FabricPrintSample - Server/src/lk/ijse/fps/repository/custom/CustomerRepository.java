/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.repository.custom;

import lk.ijse.fps.dto.CustomerDTO;
import lk.ijse.fps.entity.Customer;
import lk.ijse.fps.repository.SuperRepository;
import org.hibernate.Session;

/**
 *
 * @author ranjith-suranga
 */
public interface CustomerRepository extends SuperRepository<Customer, Integer>{
    
    public void setSessions(Session session) throws Exception ;
    
    public CustomerDTO SearchCustomers(String name)throws Exception;
}
