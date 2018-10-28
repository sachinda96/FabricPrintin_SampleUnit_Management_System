/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.service.custom;

import java.util.List;
import lk.ijse.fps.dto.DesignDTO;
import lk.ijse.fps.service.SuperService;

/**
 *
 * @author Sachinda Nipun
 */
public interface DesignService extends SuperService{
    public boolean addDeign(DesignDTO design) throws Exception;
    
    public boolean updateDeign(DesignDTO design) throws Exception;
    
    public boolean deleteDeign(Integer designID) throws Exception;
    
    public boolean viewDeignId(Integer designID) throws Exception;
    
    public List<DesignDTO> getAllDeign() throws Exception;
}
