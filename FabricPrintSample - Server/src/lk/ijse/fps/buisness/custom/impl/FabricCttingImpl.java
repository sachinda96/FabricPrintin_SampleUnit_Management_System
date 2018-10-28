/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.fps.buisness.custom.FabricCutingBO;
import lk.ijse.fps.dto.FabricDTO;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.entity.Fabric;
import lk.ijse.fps.entity.FabricCutting;
import lk.ijse.fps.repository.RepositoryFactory;
import lk.ijse.fps.repository.custom.FabricCusttingReposistry;
import lk.ijse.fps.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Sachinda Nipun
 */
public class FabricCttingImpl implements FabricCutingBO {

    private FabricCusttingReposistry fabricCusttingReposistry;
    
    public FabricCttingImpl() {
        fabricCusttingReposistry = (FabricCusttingReposistry) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.FABRICCUTTING);
    }
    
    @Override
    public boolean addOrders(OrderDTO orders) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            fabricCusttingReposistry.setSession(session);
            
            session.beginTransaction();
            
            FabricCutting fc = new FabricCutting();
            fc.setOrderId(orders.getOrderId());
            fc.setCustomerName(orders.getCustomerName());
            fc.setDesignId(orders.getDesignId());
            fc.setDesignName(orders.getDesignName());
            fc.setDesignType(orders.getDesignType());
            fc.setFabricName(orders.getFabricName());
            fc.setFabricQty(orders.getFabricQty());
            fc.setOrderDate(orders.getOrderDate());
            fc.setOrderQty(orders.getOrderQty());
//            fc.setAvailable(orders.getAvailable());
            fc.setStage(orders.getStage());
            boolean result = fabricCusttingReposistry.save(fc);
            
            session.getTransaction().commit();
            
            return result;
        } catch (Exception exp) {
            exp.printStackTrace();
            return false;
            
        }
    }
    
    @Override
    public boolean updateOrders(OrderDTO orders) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            fabricCusttingReposistry.setSession(session);
            
            session.beginTransaction();
            
            FabricCutting fc = new FabricCutting();
            fc.setOrderId(orders.getOrderId());
            fc.setCustomerName(orders.getCustomerName());
            fc.setDesignId(orders.getDesignId());
            fc.setDesignName(orders.getDesignName());
            fc.setDesignType(orders.getDesignType());
            fc.setFabricName(orders.getFabricName());
            fc.setFabricQty(orders.getFabricQty());
            fc.setOrderDate(orders.getOrderDate());
            fc.setOrderQty(orders.getOrderQty());
            fc.setPrintingMethod(orders.getPrintingMethod());
            fc.setPribtingTechnic(orders.getPribtingTechnic());
            fc.setStage(orders.getStage());
            fabricCusttingReposistry.update(fc);
            
            session.getTransaction().commit();
            
            return true;
        } catch (Exception exp) {
            exp.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean deleteOrders(Integer OrderID) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            fabricCusttingReposistry.setSession(session);
            
            session.beginTransaction();
            
            FabricCutting fabricCut = fabricCusttingReposistry.findById(OrderID);
            boolean result = false;
            
            if (fabricCut != null) {
                
                fabricCusttingReposistry.delete(fabricCut);
            }
            
            session.getTransaction().commit();
            
            return result;
        } catch (Exception exp) {
            exp.printStackTrace();
            return false;
        }
    }
    
    @Override
    public List<OrderDTO> getAllOrders() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            fabricCusttingReposistry.setSession(session);
            
            session.beginTransaction();
            
            List<FabricCutting> fabriccut = fabricCusttingReposistry.findAll();
            
            session.getTransaction().commit();
            
            if (fabriccut != null) {
                
                List<OrderDTO> alfabric = new ArrayList<>();
                
                for (FabricCutting fabtics : fabriccut) {
                    OrderDTO fc = new OrderDTO();
                    fc.setOrderId(fabtics.getOrderId());
                    fc.setDesignId(fabtics.getDesignId());
                    fc.setCustomerName(fabtics.getCustomerName());
                    fc.setDesignName(fabtics.getDesignName());
                    fc.setDesignType(fabtics.getDesignType());
                    fc.setFabricName(fabtics.getFabricName());
                    fc.setFabricQty(fabtics.getFabricQty());
                    fc.setOrderDate(fabtics.getOrderDate());
                    fc.setOrderQty(fabtics.getOrderQty());
                    fc.setPribtingTechnic(fabtics.getPribtingTechnic());
                    fc.setPrintingMethod(fabtics.getPrintingMethod());
//            fc.setAvailable(fabtics.getAvailable());
                    fc.setStage(fabtics.getStage());
                    alfabric.add(fc);
                }
                
                return alfabric;
                
            } else {
                
                return null;
            }
            
        }
    }
    
    @Override
    public List<OrderDTO> getAllOrdersColouKitchen() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            fabricCusttingReposistry.setSessions(session);
            
            session.beginTransaction();
            
            List<Object[]> fabriccut = fabricCusttingReposistry.getColourKitchenOrders();
            session.getTransaction().commit();
            
            if (fabriccut != null) {
                
                List<OrderDTO> alfabric = new ArrayList<>();
                
                for (Object[] ob : fabriccut) {
                    OrderDTO fc = new OrderDTO();
                   fc.setOrderId((int) ob[0]);
                   fc.setCustomerName((String) ob[1]); 
                   fc.setDesignType((String) ob[2]);
                   fc.setPribtingTechnic((String) ob[3]);
                   fc.setStage((String) ob[4]);
                   fc.setDesignId((String) ob[5]);
                   fc.setDesignName((String) ob[6]);
                   fc.setFabricName((String) ob[7]);
                   fc.setFabricQty((String) ob[8]);
                   fc.setOrderDate((String) ob[9]);
                   fc.setOrderQty((String) ob[10]);
                   fc.setPrintingMethod((String) ob[11]);
                
                    alfabric.add(fc);
                }

                return alfabric;
                
            } else {
                
                return null;
            }
        }
    }
    
    @Override
    public OrderDTO getOrders(String name) throws Exception {
        return null;
    }

    @Override
    public List<OrderDTO> getAllOrdersFabricUnit() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            fabricCusttingReposistry.setSessions(session);
            
            session.beginTransaction();
            
            List<Object[]> fabriccut = fabricCusttingReposistry.getFabricOrders();
            session.getTransaction().commit();
            
            if (fabriccut != null) {
                
                List<OrderDTO> alfabric = new ArrayList<>();
                
                for (Object[] ob : fabriccut) {
                    OrderDTO fc = new OrderDTO();
                    fc.setOrderId((int) ob[0]);
                   fc.setCustomerName((String) ob[1]); 
                   fc.setDesignType((String) ob[2]);
                   fc.setPribtingTechnic((String) ob[3]);
                   fc.setStage((String) ob[4]);
                   fc.setDesignId((String) ob[5]);
                   fc.setDesignName((String) ob[6]);
                   fc.setFabricName((String) ob[7]);
                   fc.setFabricQty((String) ob[8]);
                   fc.setOrderDate((String) ob[9]);
                   fc.setOrderQty((String) ob[10]);
                   fc.setPrintingMethod((String) ob[11]);
                    alfabric.add(fc);
                }

                return alfabric;
                
            } else {
                
                return null;
            }
        }
    }

    @Override
    public List<OrderDTO> getAllOrdersSupervisor() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            fabricCusttingReposistry.setSessions(session);
            
            session.beginTransaction();
            
            List<Object[]> fabriccut = fabricCusttingReposistry.getsupervisorOrders();
            session.getTransaction().commit();
            
            if (fabriccut != null) {
                
                List<OrderDTO> alfabric = new ArrayList<>();
                
                for (Object[] ob : fabriccut) {
                    OrderDTO fc = new OrderDTO();
                    fc.setOrderId((int) ob[0]);
                   fc.setCustomerName((String) ob[1]); 
                   fc.setDesignType((String) ob[2]);
                   fc.setPribtingTechnic((String) ob[3]);
                   fc.setStage((String) ob[4]);
                   fc.setDesignId((String) ob[5]);
                   fc.setDesignName((String) ob[6]);
                   fc.setFabricName((String) ob[7]);
                   fc.setFabricQty((String) ob[8]);
                   fc.setOrderDate((String) ob[9]);
                   fc.setOrderQty((String) ob[10]);
                   fc.setPrintingMethod((String) ob[11]);
                    alfabric.add(fc);
                }
                return alfabric;
                
            } else {
                
                return null;
            }
        }
    }

    @Override
    public List<OrderDTO> searchName(String name) throws Exception {
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            fabricCusttingReposistry.setSessions(session);
            
            session.beginTransaction();
            
            List<Object[]> fabriccut = fabricCusttingReposistry.getFabricStage(name);
            session.getTransaction().commit();
            
            if (fabriccut != null) {
                
                List<OrderDTO> alfabric = new ArrayList<>();
                
                for (Object[] ob : fabriccut) {
                    OrderDTO fc = new OrderDTO();
                    fc.setOrderId((int) ob[0]);
                   fc.setCustomerName((String) ob[1]); 
                   fc.setDesignType((String) ob[2]);
                   fc.setPribtingTechnic((String) ob[3]);
                   fc.setStage((String) ob[4]);
                   fc.setDesignId((String) ob[5]);
                   fc.setDesignName((String) ob[6]);
                   fc.setFabricName((String) ob[7]);
                   fc.setFabricQty((String) ob[8]);
                   fc.setOrderDate((String) ob[9]);
                   fc.setOrderQty((String) ob[10]);
                   fc.setPrintingMethod((String) ob[11]);
                    alfabric.add(fc);
                }
                return alfabric;
                
            } else {
                
                return null;
            }
         }
    }

    @Override
    public List<OrderDTO> getAllOrdersFinished() throws Exception {
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            fabricCusttingReposistry.setSessions(session);
            
            session.beginTransaction();
            
            List<Object[]> fabriccut = fabricCusttingReposistry.getFinishOrders();
            session.getTransaction().commit();
            
            if (fabriccut != null) {
                
                List<OrderDTO> alfabric = new ArrayList<>();
                
                for (Object[] ob : fabriccut) {
                    OrderDTO fc = new OrderDTO();
                   fc.setOrderId((int) ob[0]);
                   fc.setCustomerName((String) ob[1]); 
                   fc.setDesignType((String) ob[2]);
                   fc.setPribtingTechnic((String) ob[3]);
                   fc.setStage((String) ob[4]);
                   fc.setDesignId((String) ob[5]);
                   fc.setDesignName((String) ob[6]);
                   fc.setFabricName((String) ob[7]);
                   fc.setFabricQty((String) ob[8]);
                   fc.setOrderDate((String) ob[9]);
                   fc.setOrderQty((String) ob[10]);
                   fc.setPrintingMethod((String) ob[11]);
                    alfabric.add(fc);
                }

                return alfabric;
                
            } else {
                
                return null;
            }
        }
    }

    @Override
    public List<OrderDTO> getAllOrdersDamaged() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            fabricCusttingReposistry.setSessions(session);
            
            session.beginTransaction();
            
            List<Object[]> fabriccut = fabricCusttingReposistry.getDamagedOrders();
            session.getTransaction().commit();
            
            if (fabriccut != null) {
                
                List<OrderDTO> alfabric = new ArrayList<>();
                
                for (Object[] ob : fabriccut) {
                    OrderDTO fc = new OrderDTO();
                    fc.setOrderId((int) ob[0]);
                   fc.setCustomerName((String) ob[1]); 
                   fc.setDesignType((String) ob[2]);
                   fc.setPribtingTechnic((String) ob[3]);
                   fc.setStage((String) ob[4]);
                   fc.setDesignId((String) ob[5]);
                   fc.setDesignName((String) ob[6]);
                   fc.setFabricName((String) ob[7]);
                   fc.setFabricQty((String) ob[8]);
                   fc.setOrderDate((String) ob[9]);
                   fc.setOrderQty((String) ob[10]);
                   fc.setPrintingMethod((String) ob[11]);
                    alfabric.add(fc);
                }

                return alfabric;
                
            } else {
                
                return null;
            }
        }
    }

    @Override
    public int getOrderDetail() throws Exception {
             try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            fabricCusttingReposistry.setSessions(session);
            
            session.beginTransaction();
            
            int x = fabricCusttingReposistry.getOrderDetail();
            session.getTransaction().commit();
            
                 return x;
             
             }
    }
}
