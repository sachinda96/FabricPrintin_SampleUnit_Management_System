/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.service.custom;

import java.util.List;
import lk.ijse.fps.dto.ColourQueuDTO;
import lk.ijse.fps.service.SuperService;

/**
 *
 * @author Sachinda Nipun
 */
public interface ColorQueuService extends SuperService{

     public boolean addColourseQueue(ColourQueuDTO colourQueu)throws Exception;
    
    public boolean removeColourseQueue(ColourQueuDTO colourQueu)throws Exception;
    
    public ColourQueuDTO getColourse()throws Exception;
    
    public List<ColourQueuDTO> getColourseList()throws Exception;
}
