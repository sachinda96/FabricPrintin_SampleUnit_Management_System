/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.fps.dto.OrderDTO;

/**
 *
 * @author Sachinda Nipun
 */
public class BDUOrderQueu implements lk.ijse.fps.buisness.custom.BDUOrderQueu{
    
    private static BDUOrderQueu bduOrderqueu;
    
    private ArrayList<OrderDTO> orderList;

    private BDUOrderQueu() {
        orderList=new ArrayList<>();
    }
    
    public static BDUOrderQueu getInstance() {
        if (bduOrderqueu == null) {
            bduOrderqueu = new BDUOrderQueu();
        }
        return bduOrderqueu;
    }


    @Override
    public boolean addOrdersQueue(OrderDTO ordersQueu) throws Exception {
      return orderList.add(ordersQueu);
    }

    @Override
    public boolean removeOrdersQueue(OrderDTO ordersQueu) throws Exception {
        
        return orderList.remove(ordersQueu);
      
    }

    @Override
    public List<OrderDTO> getOrdrList() throws Exception {
        return orderList;
    }

    @Override
    public OrderDTO getOrder() throws Exception {
        if (orderList.isEmpty()) {
            return null;
        }else{
        
        OrderDTO orderdto=orderList.get(0);
         orderList.remove(orderdto);

        return orderdto;
        } 
    }
    
    
    
    
}
