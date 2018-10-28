/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.repository.custom.impl;

import lk.ijse.fps.dto.CustomerDTO;
import lk.ijse.fps.entity.Customer;
import lk.ijse.fps.repository.SuperRepositoryImpl;
import lk.ijse.fps.repository.custom.CustomerRepository;
import org.hibernate.Session;

/**
 *
 * @author ranjith-suranga
 */
public class CustomerRepositoryImpl extends SuperRepositoryImpl<Customer, Integer> implements CustomerRepository {
    private Session session;
    public CustomerRepositoryImpl(){
        
    }

    @Override
    public CustomerDTO SearchCustomers(String name) throws Exception {
        CustomerDTO cust=(CustomerDTO) session.createSQLQuery("select * from Fabriccutting where CustomerName='" + name+ "'");
        return cust;
    }

    @Override
    public void setSessions(Session session) throws Exception {
        this.session=session;
    }

}
