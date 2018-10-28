/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.repository.custom;

import java.util.List;
import lk.ijse.fps.entity.Login;
import lk.ijse.fps.repository.SuperRepository;
import org.hibernate.Session;


/**
 *
 * @author Sachinda Nipun
 */
public interface LoginReposistry extends SuperRepository<lk.ijse.fps.entity.Login, String>{
    public void setSessions(Session session)throws Exception;
    
    public lk.ijse.fps.entity.Login searchUnit(String unit)throws Exception;
    
    public List<Login> searchName(String name)throws Exception;
    
    public lk.ijse.fps.entity.Login searchpassword(String password)throws Exception;
}
