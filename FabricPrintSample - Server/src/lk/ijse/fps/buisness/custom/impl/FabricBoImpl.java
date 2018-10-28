/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.fps.buisness.custom.FabriCBo;
import lk.ijse.fps.dto.CustomerDTO;
import lk.ijse.fps.dto.FabricDTO;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.entity.Color;
import lk.ijse.fps.entity.Customer;
import lk.ijse.fps.entity.Fabric;
import lk.ijse.fps.repository.RepositoryFactory;
import lk.ijse.fps.repository.custom.FabricReposistry;
import lk.ijse.fps.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Sachinda Nipun
 */
public class FabricBoImpl implements FabriCBo{
    private FabricReposistry fabricReposistry;

    public FabricBoImpl() {
        fabricReposistry=(FabricReposistry) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.FABRIC);
    }

    @Override
    public boolean addFabric(FabricDTO fabric) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            fabricReposistry.setSession(session);
            
            session.beginTransaction();
            
            Fabric f=new Fabric();
            f.setFabricName(fabric.getFabricName());
            f.setFabricTypes(fabric.getFabricTypes());
            f.setFabricItem(fabric.getFabricItem());
            f.setColorway(fabric.getColorway());
            boolean result = fabricReposistry.save(f);
            
            session.getTransaction().commit();

            return result;
            }catch(Exception exp){
            exp.printStackTrace();
            return false;
        
        }
    }

    @Override
    public boolean updateFabric(FabricDTO fabric) throws Exception {
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            fabricReposistry.setSession(session);
            
            session.beginTransaction();
            Fabric f=new Fabric();
            f.setFabricName(fabric.getFabricName());
            f.setFabricTypes(fabric.getFabricTypes());
            f.setFabricItem(fabric.getFabricItem());
            f.setColorway(fabric.getColorway());
            fabricReposistry.update(f);
            
            session.getTransaction().commit();
            
            return true;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteFabric(String fabricID) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            fabricReposistry.setSession(session);
            
            session.beginTransaction();

            Fabric fabric = fabricReposistry.findById(fabricID);
            boolean result = false;

            if (fabric != null) {

                fabricReposistry.delete(fabric);
            }
            
            session.getTransaction().commit();

            return result;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    
    }

    @Override
    public List<FabricDTO> getAllFabric() throws Exception {
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            fabricReposistry.setSession(session);
            
            session.beginTransaction();

            List<Fabric> fabric = fabricReposistry.findAll();
            
            session.getTransaction().commit();

            if (fabric != null) {

                List<FabricDTO> alfabric = new ArrayList<>();

                for (Fabric fabtics : fabric) {
                   FabricDTO fb=new FabricDTO();
                   fb.setFabricId(Integer.toString(fabtics.getFabricId()));
                   fb.setFabricName(fabtics.getFabricName());
                   fb.setFabricTypes(fabtics.getFabricTypes());
                   fb.setFabricItem(fabtics.getFabricItem());
                   fb.setColorway(fabtics.getColorway());
                    alfabric.add(fb);
                }

                return alfabric;

            } else {

                return null;
            }

        }
    }

    @Override
    public boolean viewfabricId(Integer designID) throws Exception {
           try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            fabricReposistry.setSession(session);
            
            session.beginTransaction();

               Fabric fl = fabricReposistry.findById(Integer.toString(designID));
            boolean result = false;
            session.getTransaction().commit();
            if (fl != null) {

                return true;
            }else{
                return false;
            }
         
           
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    
    }
    
    

}
