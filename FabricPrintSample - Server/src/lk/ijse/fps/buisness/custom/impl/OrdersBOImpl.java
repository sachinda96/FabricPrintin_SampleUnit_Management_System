/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.fps.buisness.custom.OrderBo;
import lk.ijse.fps.dto.CustomerDTO;
import lk.ijse.fps.dto.DesignDTO;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.dto.OrderDetailDto;
import lk.ijse.fps.dto.OrderDetail_PKDto;
import lk.ijse.fps.dto.PlaceOrderDTO;
import lk.ijse.fps.entity.Customer;
import lk.ijse.fps.entity.Design;
import lk.ijse.fps.entity.Fabric;
import lk.ijse.fps.entity.FabricCutting;
import lk.ijse.fps.entity.OrderDetail;
import lk.ijse.fps.entity.OrderDetail_PK;
import lk.ijse.fps.entity.Orders;
import lk.ijse.fps.repository.RepositoryFactory;
import lk.ijse.fps.repository.custom.CustomerRepository;
import lk.ijse.fps.repository.custom.DesignDepository;
import lk.ijse.fps.repository.custom.FabricCusttingReposistry;
import lk.ijse.fps.repository.custom.OrderDetailReposistry;
import lk.ijse.fps.repository.custom.OrderReposistry;
import lk.ijse.fps.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Sachinda Nipun
 */
public class OrdersBOImpl implements OrderBo {

    private OrderReposistry orderReposistry;
    private DesignDepository designDepository;
    private OrderDetailReposistry orderDetailReposistry;
    private FabricCusttingReposistry fabricCusttingReposistry;

    public OrdersBOImpl() {
        orderReposistry = (OrderReposistry) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ORDERS);
        designDepository = (DesignDepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.DESIGN);
        orderDetailReposistry = (OrderDetailReposistry) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ORDERDETAILS);
        fabricCusttingReposistry = (FabricCusttingReposistry) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.FABRICCUTTING);
    }

    @Override
    public boolean addOrders(PlaceOrderDTO orders) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            boolean result2 = false;
            boolean result3 = false;
            boolean result4 = false;
            boolean result5 = false;
            List<OrderDetailDto> list = orders.getOrderDetails();
            List<OrderDTO> orderList = orders.getListOrders();
            orderReposistry.setSession(session);
            designDepository.setSession(session);
            orderDetailReposistry.setSession(session);
            fabricCusttingReposistry.setSession(session);

            session.beginTransaction();

       
           
            OrderDTO orderDTO = orders.getOrderDTO();
            FabricCutting fc = new FabricCutting();    
            fc.setCustomerName(orderDTO.getCustomerName());
            fc.setDesignId(orderDTO.getDesignId());
            fc.setDesignName(orderDTO.getDesignName());
            fc.setDesignType(orderDTO.getDesignType());
            fc.setFabricName(orderDTO.getFabricName());
            fc.setFabricQty(orderDTO.getFabricQty());
            fc.setOrderDate(orderDTO.getOrderDate());
            fc.setOrderQty(orderDTO.getOrderQty());
            fc.setDesignType(orderDTO.getDesignType());
            fc.setStage(orderDTO.getStage());
            result4 = fabricCusttingReposistry.save(fc);

            Customer c=new Customer();
            c.setFirstname(orders.getCustomerDTO().getFirstname());
            
            Orders o = new Orders();
            o.setOrderDate(orders.getOrderDTO().getOrderDate());
            o.setOrderQty(orders.getOrderDTO().getFabricQty());
            o.setFinshOrders(orders.getOrderDTO().getAvailable());
            result2 = orderReposistry.save(o);

            for (OrderDetailDto orderDetailDto : list) {

                Design d = new Design();
                d.setDesignNumber(orders.getDesignDTO().getDesignNumber());
                d.setDesignName(orders.getDesignDTO().getDesignName());
                d.setDesignType(orders.getDesignDTO().getDesignType());
                d.setImages(orders.getDesignDTO().getImages());
                result3 = designDepository.save(d);

                OrderDetail orderd = new OrderDetail();
                orderd.setOrders(o);
                orderd.setDesign(d);
                orderd.setOrderDate(orderDetailDto.getOrderDate());
                orderd.setPrice(orderDetailDto.getPrice());
                orderd.setDeliveryDate(orderDetailDto.getDeliveryDate());

                OrderDetail_PK orderDeatailpk = new OrderDetail_PK();
                orderDeatailpk.setDesignID(d.getDesignID());
                orderDeatailpk.setOrderId(o.getOrderId());
                orderd.setOrderDetail_PK(orderDeatailpk);
                System.out.println(orderDeatailpk);
                result5 = orderDetailReposistry.save(orderd);
            }

           
                session.getTransaction().commit();

                return true;
            
        } catch (Exception exp) {
            exp.printStackTrace();
            return false;

        }
    }

    @Override
    public boolean updateOrders(PlaceOrderDTO orders) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            orderReposistry.setSession(session);

            session.beginTransaction();
            Orders o = new Orders();
            o.setOrderId(orders.getOrderDTO().getOrderId());
            o.setOrderDate(orders.getOrderDTO().getOrderDate());
            o.setOrderQty(orders.getOrderDTO().getFabricQty());
            o.setFinshOrders(orders.getOrderDTO().getAvailable());
            orderReposistry.update(o);

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

            orderReposistry.setSession(session);

            session.beginTransaction();

            Orders orders = orderReposistry.findById(OrderID);
            boolean result = false;

            if (orders != null) {

                orderReposistry.delete(orders);
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

            orderReposistry.setSession(session);

            session.beginTransaction();

            List<Orders> orders = orderReposistry.findAll();

            session.getTransaction().commit();

            if (orders != null) {

                List<OrderDTO> allOrders = new ArrayList<>();

                for (Orders allOrder : orders) {
                    OrderDTO orderDTO = new OrderDTO();
                    //orderDTO.setOrderId(allOrder.getOrderId());
                    orderDTO.setOrderQty(allOrder.getOrderQty());
                    orderDTO.setOrderDate(allOrder.getOrderDate());
                    allOrders.add(orderDTO);
                }
                return allOrders;
            } else {
                return null;
            }
        }
    }

    @Override
    public boolean finshedOrders(PlaceOrderDTO orderd) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            boolean result1 = false;
            boolean result2 = false;

            orderReposistry.setSession(session);
            designDepository.setSession(session);
            orderDetailReposistry.setSession(session);
            fabricCusttingReposistry.setSession(session);

            session.beginTransaction();

            CustomerDTO cust = orderd.getCustomerDTO();
            

            OrderDTO orders = orderd.getOrderDTO();
            FabricCutting fc = new FabricCutting();
            fc.setCustomerName(orders.getCustomerName());
            fc.setDesignName(orders.getDesignName());
            fc.setDesignType(orders.getDesignType());
            fc.setFabricName(orders.getFabricName());
            fc.setFabricQty(orders.getFabricQty());
            fc.setOrderDate(orders.getOrderDate());
            fc.setOrderQty(orders.getOrderQty());
            fc.setDesignId(orders.getDesignId());
            fc.setPribtingTechnic(orders.getPribtingTechnic());
            fc.setPrintingMethod(orders.getPrintingMethod());
            fc.setStage(orders.getStage());
            
            fabricCusttingReposistry.update(fc);

            
           // orderReposistry.update(o);

            session.getTransaction().commit();

            return true;

        } catch (Exception exp) {
            exp.printStackTrace();
            return false;

        }
    }

    @Override
    public boolean viewOrderId(Integer designID) throws Exception {
           try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            orderReposistry.setSession(session);
            
            session.beginTransaction();

               Orders fl = orderReposistry.findById(designID);
            boolean result = false;
            session.getTransaction().commit();
            if (fl != null) {

                return true;
            }else{
                return false;
            }
         
           
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    
    
    }
}
