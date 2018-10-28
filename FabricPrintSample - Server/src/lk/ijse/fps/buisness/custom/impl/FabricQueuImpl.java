/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import lk.ijse.fps.buisness.custom.FabricQueu;
import lk.ijse.fps.dto.OrderDTO;

/**
 *
 * @author Sachinda Nipun
 */
public class FabricQueuImpl implements FabricQueu{
    
    private static FabricQueu fabricQueu;
    
    private ArrayList<OrderDTO> fabricorders;
   

    private FabricQueuImpl() {
        fabricorders=new ArrayList<>();

        
    }
    
    public static FabricQueu getInstance(){
        if (fabricQueu==null) {
            fabricQueu=new FabricQueuImpl();
        }
        return fabricQueu;
    }

    @Override
    public boolean addFabric(OrderDTO orders) throws Exception {
        return fabricorders.add(orders);
    }

    @Override
    public boolean remooveFabric(OrderDTO Orders) throws Exception {
        return fabricorders.remove(Orders);
    }

    @Override
    public OrderDTO getOrders() throws Exception {
        OrderDTO orderDTO=fabricorders.get(0);
        fabricorders.remove(orderDTO);
        return orderDTO;
    }

    @Override
    public ArrayList<OrderDTO> getAllOrders() throws Exception {
        return fabricorders;
    }
    
}
