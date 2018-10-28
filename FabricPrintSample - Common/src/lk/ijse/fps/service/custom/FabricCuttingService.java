/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.service.custom;

import java.util.List;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.dto.PlaceOrderDTO;
import lk.ijse.fps.service.SuperService;

/**
 *
 * @author Sachinda Nipun
 */
public interface FabricCuttingService extends SuperService {

    public boolean addOrders(OrderDTO orders) throws Exception;

    public boolean updateOrders(OrderDTO orders) throws Exception;

    public boolean deleteOrders(Integer OrderID) throws Exception;

    public List<OrderDTO> getAllOrders() throws Exception;

    public List<OrderDTO> getColourKitchenOrders() throws Exception;

    public List<OrderDTO> getsupervisorOrders() throws Exception;

    public List<OrderDTO> getFabricOrders() throws Exception;
    
    public List<OrderDTO> getOrdersDamage() throws Exception;

    public List<OrderDTO> getOrdersFinished() throws Exception;

    public List<OrderDTO> searchName(String name) throws Exception;
    
    public int getOrderDetail() throws Exception;
}
