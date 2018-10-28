/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.repository.custom.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.entity.FabricCutting;
import lk.ijse.fps.repository.SuperRepositoryImpl;
import lk.ijse.fps.repository.custom.FabricCusttingReposistry;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Sachinda Nipun
 */
public class FabricCusttingReposistryIml extends SuperRepositoryImpl<FabricCutting, Integer> implements FabricCusttingReposistry{
    private Session session;
    public FabricCusttingReposistryIml() {
    
    }

    @Override
    public void setSessions(Session session) throws Exception {
        this.session = session;
    }

    @Override
    public List<Object[]> getColourKitchenOrders() throws Exception {
             List<Object[]> ob=session.createSQLQuery("select * from Fabriccutting where stage='colour kitchen'").list();
              
             return ob;
    }

    @Override
    public List<Object[]> getsupervisorOrders() throws Exception {
        List<Object[]> ob=session.createSQLQuery("select * from Fabriccutting where stage='Supervisor Unit'").list();
              
             return ob;
    }

    @Override
    public List<Object[]> getFabricOrders() throws Exception {
        List<Object[]> ob=session.createSQLQuery("select * from Fabriccutting where stage='Fabric Unit'").list();
              
             return ob;
    }

    @Override
    public List<Object[]> getFabricStage(String name) throws Exception {
        List<Object[]> ob=session.createSQLQuery("select * from Fabriccutting where CustomerName='" + name+ "'").list();
              
             return ob;
    }

    @Override
    public List<Object[]> getFinishOrders() throws Exception {
        List<Object[]> ob=session.createSQLQuery("select * from Fabriccutting where stage='Finished'").list();
              
             return ob;
    }

    @Override
    public List<Object[]> getDamagedOrders() throws Exception {
         List<Object[]> ob=session.createSQLQuery("select * from Fabriccutting where stage='Damaged'").list();
              
             return ob;
    }

    @Override
    public int getOrderDetail() throws Exception {
       SQLQuery tq= session.createSQLQuery("select count(*) from fabriccutting where stage='Damaged'");
    
       Object ob=tq.list().get(0);
       
        int x=((Number)ob).intValue();
        return x;
    }
   
    
    
}
