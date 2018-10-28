/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom;

import java.util.List;
import lk.ijse.fps.buisness.SuperBO;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.dto.SupervisorQueuDTO;

/**
 *
 * @author Sachinda Nipun
 */
public interface SupervisorQueu extends SuperBO{
    public boolean addOrdersQueue(SupervisorQueuDTO supervisorQueuDTO)throws Exception;
    
    public boolean removeOrdersQueue(SupervisorQueuDTO supervisorQueuDTO)throws Exception;
    
    public SupervisorQueuDTO getOrder()throws Exception;
    
    public List<SupervisorQueuDTO> getOrdrList()throws Exception;
}
