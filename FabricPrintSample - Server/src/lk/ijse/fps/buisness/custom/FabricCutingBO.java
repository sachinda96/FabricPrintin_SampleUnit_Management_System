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
public interface FabricCutingBO extends SuperBO {

    public boolean addOrders(OrderDTO orders) throws Exception;

    public boolean updateOrders(OrderDTO orders) throws Exception;

    public boolean deleteOrders(Integer OrderID) throws Exception;

    public OrderDTO getOrders(String name) throws Exception;

    public List<OrderDTO> getAllOrders() throws Exception;

    public List<OrderDTO> getAllOrdersColouKitchen() throws Exception;

    public List<OrderDTO> getAllOrdersFabricUnit() throws Exception;

    public List<OrderDTO> getAllOrdersSupervisor() throws Exception;
    
    public List<OrderDTO> getAllOrdersFinished() throws Exception;
    
    public List<OrderDTO> getAllOrdersDamaged() throws Exception;
    
    public List<OrderDTO> searchName(String name) throws Exception;
    
    public int getOrderDetail() throws Exception ;

}
