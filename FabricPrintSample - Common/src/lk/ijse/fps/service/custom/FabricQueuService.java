/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.service.custom;

import java.util.ArrayList;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.service.SuperService;

/**
 *
 * @author Sachinda Nipun
 */
public interface FabricQueuService extends SuperService{
    
    public boolean addFabric(OrderDTO ordersDTO)throws Exception;
    
    public boolean removeFabric(OrderDTO ordersDTO)throws Exception;
    
    public OrderDTO getFabric()throws Exception;
    
    public ArrayList<OrderDTO> getAllOrders()throws  Exception;
    
    
}
