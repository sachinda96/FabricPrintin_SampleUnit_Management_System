/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.service.custom;

import java.util.List;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.service.SuperService;

/**
 *
 * @author Sachinda Nipun
 */
public interface OrderQueuService extends SuperService{
    
    public boolean addOrdQueu(OrderDTO order)throws Exception;
    
    public boolean removeOrdQueu(OrderDTO order)throws Exception;
    
    public OrderDTO getOrder()throws Exception;
    
    public List<OrderDTO> getOrderList()throws Exception;
}
