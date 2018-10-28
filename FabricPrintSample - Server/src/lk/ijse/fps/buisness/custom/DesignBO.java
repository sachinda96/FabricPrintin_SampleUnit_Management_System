/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom;

import java.util.List;
import lk.ijse.fps.buisness.SuperBO;
import lk.ijse.fps.dto.CustomerDTO;
import lk.ijse.fps.dto.DesignDTO;

/**
 *
 * @author Sachinda Nipun
 */
public interface DesignBO extends SuperBO{
    
    public boolean addDeign(DesignDTO design) throws Exception;
    
    public boolean updateDeign(DesignDTO design) throws Exception;
    
    public boolean deleteDeign(Integer designID) throws Exception;
    
    public boolean viewDeignId(Integer designID) throws Exception;
    
    public List<DesignDTO> getAllDeign() throws Exception;
}
