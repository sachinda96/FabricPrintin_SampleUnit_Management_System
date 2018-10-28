/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.service.custom;

import java.util.List;
import lk.ijse.fps.dto.LoginAccountDTO;
import lk.ijse.fps.service.SuperService;

/**
 *
 * @author Sachinda Nipun
 */
public interface LOginService extends SuperService {

    public boolean addAccount(LoginAccountDTO log) throws Exception;

    public LoginAccountDTO searchUnit(String unitName) throws Exception;

    public List<LoginAccountDTO> searchUserName(String Name) throws Exception;

    public LoginAccountDTO searchPassword(String Password) throws Exception;

    public List<LoginAccountDTO> getlogs() throws Exception;
}
