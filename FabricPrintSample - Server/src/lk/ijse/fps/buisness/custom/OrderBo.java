/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom;

import java.util.List;
import lk.ijse.fps.buisness.SuperBO;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.dto.PlaceOrderDTO;

/**
 *
 * @author Sachinda Nipun
 */
public interface OrderBo extends SuperBO{
     public boolean addOrders(PlaceOrderDTO orders) throws Exception;
     
     public boolean viewOrderId(Integer designID) throws Exception;
     
     public boolean  finshedOrders(PlaceOrderDTO orderd)throws Exception;
    
    public boolean updateOrders(PlaceOrderDTO orders) throws Exception;
    
    public boolean deleteOrders(Integer OrderID) throws Exception;
    
    public List<OrderDTO> getAllOrders() throws Exception;
    
}
