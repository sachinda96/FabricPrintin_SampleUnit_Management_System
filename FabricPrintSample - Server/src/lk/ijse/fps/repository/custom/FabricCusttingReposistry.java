/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.repository.custom;

import java.util.List;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.entity.FabricCutting;
import lk.ijse.fps.repository.SuperRepository;
import org.hibernate.Session;

/**
 *
 * @author Sachinda Nipun
 */
public interface FabricCusttingReposistry extends SuperRepository<FabricCutting, Integer>{
    
    public void setSessions(Session session)throws Exception;
    
    public List<Object[]> getColourKitchenOrders()throws Exception;
    
    public List<Object[]> getsupervisorOrders()throws Exception;
    
    public List<Object[]> getFabricOrders()throws Exception;
    
    public List<Object[]> getFinishOrders()throws Exception;
    
    public List<Object[]> getDamagedOrders()throws Exception;
    
    public List<Object[]> getFabricStage(String name)throws Exception;

    public int getOrderDetail()throws Exception;
}
