/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom;

import java.util.List;
import lk.ijse.fps.buisness.SuperBO;
import lk.ijse.fps.dto.ColourDTO;
import lk.ijse.fps.dto.LoginAccountDTO;
import lk.ijse.fps.entity.Login;

/**
 *
 * @author Sachinda Nipun
 */
public interface LOginBO extends SuperBO{
    public boolean addAccount(LoginAccountDTO log) throws Exception;
    
    public List<LoginAccountDTO> searchName(String name)throws Exception;
    
    public LoginAccountDTO getlogs(String name) throws Exception;
}
