/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.service.custom;

import java.util.List;
import lk.ijse.fps.dto.SupervisorQueuDTO;
import lk.ijse.fps.service.SuperService;

/**
 *
 * @author Sachinda Nipun
 */
public interface SupervisorQueuService extends SuperService{
    public boolean addFinshedOrdersQueue(SupervisorQueuDTO supervisorQueuDTO)throws Exception;
    
    public boolean removeFinshedOrdersQueue(SupervisorQueuDTO supervisorQueuDTO)throws Exception;
    
    public SupervisorQueuDTO getFinshedOrder()throws Exception;
    
    public List<SupervisorQueuDTO> getFinshedOrdrList()throws Exception;
}
