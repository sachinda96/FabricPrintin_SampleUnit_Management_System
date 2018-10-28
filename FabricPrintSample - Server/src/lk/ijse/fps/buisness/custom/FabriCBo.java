/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom;

import java.util.List;
import lk.ijse.fps.buisness.SuperBO;
import lk.ijse.fps.dto.CustomerDTO;
import lk.ijse.fps.dto.FabricDTO;
import lk.ijse.fps.dto.OrderDTO;

/**
 *
 * @author Sachinda Nipun
 */
public interface FabriCBo extends SuperBO{
    
    public boolean addFabric(FabricDTO fabric) throws Exception;
    
    public boolean viewfabricId(Integer designID) throws Exception;
    
    public boolean updateFabric(FabricDTO fabric) throws Exception;
    
    public boolean deleteFabric(String fabricID) throws Exception;
    
    public List<FabricDTO> getAllFabric() throws Exception;
}
