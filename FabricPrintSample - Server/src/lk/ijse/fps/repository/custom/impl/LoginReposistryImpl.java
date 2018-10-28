/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.repository.custom.impl;

import java.io.Serializable;
import java.util.List;
import lk.ijse.fps.entity.Login;
import lk.ijse.fps.repository.SuperRepositoryImpl;
import org.hibernate.Session;

/**
 *
 * @author Sachinda Nipun
 */
public class LoginReposistryImpl extends SuperRepositoryImpl<Login, String> implements lk.ijse.fps.repository.custom.LoginReposistry{
    private Session session;
    public LoginReposistryImpl() {
    }

    @Override
    public void setSessions(Session session) throws Exception {
        this.session=session;
    }

    @Override
    public Login searchUnit(String unit) throws Exception {
        Login log=(Login) session.createSQLQuery("select * from Fabriccutting where CustomerName='" + unit+ "'").list();
              
             return log;
    }

    @Override
    public List<Login> searchName(String name) throws Exception {
        List<Login> log= session.createSQLQuery("select * from login where userName='" + name+ "'").list();
              
             return log;
    }

    @Override
    public Login searchpassword(String password) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    
}
