/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom;

import java.util.List;
import lk.ijse.fps.buisness.SuperBO;
import lk.ijse.fps.dto.ColourDTO;
import lk.ijse.fps.dto.CustomerDTO;

/**
 *
 * @author Sachinda Nipun
 */
public interface ColorBO extends SuperBO{
    public boolean addColor(ColourDTO color) throws Exception;
    
    public boolean updateColor(ColourDTO color) throws Exception;
    
    public boolean viewcolourId(Integer designID) throws Exception;
  
    public boolean deleteColor(Integer id) throws Exception;
    
    public List<ColourDTO> getAllCustomers() throws Exception;
}
