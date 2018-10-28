/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom;

import java.util.List;
import lk.ijse.fps.buisness.SuperBO;
import lk.ijse.fps.dto.OrderDTO;

/**
 *
 * @author Sachinda Nipun
 */
public interface BDUOrderQueu extends SuperBO{
    
    public boolean addOrdersQueue(OrderDTO ordersQueu)throws Exception;
    
    public boolean removeOrdersQueue(OrderDTO ordersQueu)throws Exception;
    
    public OrderDTO getOrder()throws Exception;
    
    public List<OrderDTO> getOrdrList()throws Exception;
    
}
