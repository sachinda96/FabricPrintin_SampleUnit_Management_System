/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.service.custom;

import lk.ijse.fps.dto.ItemDTO;
import lk.ijse.fps.service.SuperService;

/**
 *
 * @author ranjith-suranga
 */
public interface ItemService extends SuperService{
    
    public boolean addItem(ItemDTO item) throws Exception;
    
}
