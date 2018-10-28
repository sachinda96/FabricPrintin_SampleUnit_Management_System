/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.fps.buisness.SuperBO;
import lk.ijse.fps.dto.OrderDTO;

/**
 *
 * @author Sachinda Nipun
 */
public interface FabricQueu extends SuperBO{
    
    public boolean addFabric(OrderDTO orders)throws Exception;
    
    public boolean remooveFabric(OrderDTO Orders)throws Exception;
    
    public OrderDTO getOrders()throws Exception;
    
    public ArrayList<OrderDTO> getAllOrders()throws Exception;
    
}
