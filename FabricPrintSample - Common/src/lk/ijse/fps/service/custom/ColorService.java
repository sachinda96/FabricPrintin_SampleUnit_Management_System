/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.service.custom;

import java.util.List;
import lk.ijse.fps.dto.ColourDTO;
import lk.ijse.fps.dto.CustomerDTO;
import lk.ijse.fps.service.SuperService;

/**
 *
 * @author Sachinda Nipun
 */
public interface ColorService extends SuperService{
    public boolean addColor(ColourDTO Color)throws Exception;
    
    public boolean viewcolorId(Integer designID) throws Exception;
    
    public boolean deleteColor(String ColorID) throws Exception;
    
    public boolean updateColor(ColourDTO Color) throws Exception;
    
    public List<ColourDTO> getAllColor() throws Exception;
}
