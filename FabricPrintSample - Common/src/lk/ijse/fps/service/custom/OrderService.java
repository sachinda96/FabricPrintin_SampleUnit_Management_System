/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.service.custom;

import java.util.List;
import lk.ijse.fps.dto.CustomerDTO;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.dto.PlaceOrderDTO;
import lk.ijse.fps.service.SuperService;

/**
 *
 * @author Sachinda Nipun
 */
public interface OrderService extends SuperService {

    public boolean addOrders(PlaceOrderDTO Orders) throws Exception;

    public boolean finsheOrders(PlaceOrderDTO Orders) throws Exception;

    public boolean viewOrderId(Integer designID) throws Exception;
    
    public boolean deleteOrders(Integer OrdersID) throws Exception;

    public boolean updateOrders(PlaceOrderDTO Orders) throws Exception;

    public List<OrderDTO> getOrders() throws Exception;
}
