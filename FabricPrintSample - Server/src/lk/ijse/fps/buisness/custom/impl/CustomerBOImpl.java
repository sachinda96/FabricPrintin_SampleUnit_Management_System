
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.fps.buisness.custom.CustomerBO;
import lk.ijse.fps.dto.CustomerDTO;
import lk.ijse.fps.entity.Customer;
import lk.ijse.fps.repository.RepositoryFactory;
import lk.ijse.fps.repository.custom.CustomerRepository;
import lk.ijse.fps.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ranjith-suranga
 */
public class CustomerBOImpl implements CustomerBO {

    private CustomerRepository customerRepository;

    public CustomerBOImpl() {
        this.customerRepository = (CustomerRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.CUSTOMER);
    }

    @Override
    public boolean addCustomer(CustomerDTO customer) throws Exception {

        try (Session session=HibernateUtil.getSessionFactory().openSession()) {

            customerRepository.setSession(session);
            
            session.beginTransaction();
            
            Customer c = new Customer();
           // c.setId(customer.getCustomerID());
            c.setFirstname(customer.getFirstname());
            c.setLastname(customer.getLastname());
            c.setCompany(customer.getCompany());
            c.setEmail(customer.getCompany());
            c.setTelNumber(customer.getTelNumber());
            boolean result = customerRepository.save(c);
            
            session.getTransaction().commit();

            return result;
            }catch(Exception exp){
            exp.printStackTrace();
            return false;
        
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            customerRepository.setSession(session);
            
            session.beginTransaction();

            List<Customer> customers = customerRepository.findAll();
            
            session.getTransaction().commit();

            if (customers != null) {

                List<CustomerDTO> alCustomers = new ArrayList<>();

                for (Customer customer : customers) {
                    CustomerDTO dto = new CustomerDTO();
                        dto.setCustomerID(customer.getId());
                        dto.setFirstname(customer.getFirstname());
                        dto.setLastname(customer.getLastname());
                        dto.setCompany(customer.getCompany());
                        dto.setEmail(customer.getEmail());
                        dto.setTelNumber(customer.getTelNumber());
                    alCustomers.add(dto);
                }

                return alCustomers;

            } else {

                return null;
            }

        }
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            customerRepository.setSession(session);
            
            session.beginTransaction();
              Customer c = new Customer();
            c.setId(customer.getCustomerID());
            c.setFirstname(customer.getFirstname());
            c.setLastname(customer.getLastname());
            c.setCompany(customer.getCompany());
            c.setEmail(customer.getCompany());
            c.setTelNumber(customer.getTelNumber());
            customerRepository.update(c);
            
            session.getTransaction().commit();
            
            return true;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCustomer(Integer customerID) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            customerRepository.setSession(session);
            
            session.beginTransaction();

            Customer customer = customerRepository.findById(customerID);
            boolean result = false;

            if (customer != null) {

                customerRepository.delete(customer);
            }
            
            session.getTransaction().commit();

            return result;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public CustomerDTO getCustomerID(String name) throws Exception {
     try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            customerRepository.setSessions(session);
            
            session.beginTransaction();
            CustomerDTO c=null;
            
            CustomerDTO customer = customerRepository.SearchCustomers(name);
            boolean result = false;

            if (customer != null) {

                 c=new CustomerDTO();
                c.setCustomerID(customer.getCustomerID());
                c.setFirstname(customer.getFirstname());
                c.setTelNumber(customer.getTelNumber());
            }
            
            session.getTransaction().commit();

            return c;
        }catch(Exception exp){
            exp.printStackTrace();
            return null;
        }
    }

}
