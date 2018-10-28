/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom;

import lk.ijse.fps.buisness.SuperBO;
import lk.ijse.fps.dto.ItemDTO;

/**
 *
 * @author ranjith-suranga
 */
public interface ItemBO extends SuperBO{
    
    public boolean addItem(ItemDTO item)throws Exception;
    
}
