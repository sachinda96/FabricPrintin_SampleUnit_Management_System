/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.fps.dto.DesignDTO;
import lk.ijse.fps.dto.CustomerDTO;
import lk.ijse.fps.entity.Customer;
import lk.ijse.fps.entity.Design;
import lk.ijse.fps.repository.RepositoryFactory;
import lk.ijse.fps.repository.custom.DesignDepository;
import lk.ijse.fps.repository.custom.impl.DesignReposistryImpl;
import lk.ijse.fps.resource.HibernateUtil;
import org.hibernate.Session;
import lk.ijse.fps.buisness.custom.DesignBO;

/**
 *
 * @author Sachinda Nipun
 */
public class DesignBOImp implements DesignBO{
    private DesignDepository designDepository;

    public DesignBOImp() {
        designDepository=(DesignDepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.DESIGN);
    }
    
    
    @Override
    public boolean addDeign(DesignDTO design) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            designDepository.setSession(session);
            
            session.beginTransaction();
            
            Design d=new Design();
//            d.setDesignID(design.getDesignID());
            d.setDesignName(design.getDesignName());
            d.setDesignType(design.getDesignType());
            d.setImages(design.getImages());
            boolean result = designDepository.save(d);
            
            session.getTransaction().commit();

            return result;
            }catch(Exception exp){
            exp.printStackTrace();
            return false;
        
        }
    }

    @Override
    public boolean updateDeign(DesignDTO design) throws Exception {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            designDepository.setSession(session);
            
            Design d=new Design();
           // d.setDesignID(design.getDesignID());
            d.setDesignName(design.getDesignName());
            d.setDesignType(design.getDesignType());
            d.setImages(design.getImages());
            designDepository.update(d);
            
            session.getTransaction().commit();
            
            return true;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteDeign(Integer designID) throws Exception {
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            designDepository.setSession(session);
            
            session.beginTransaction();

            Design design = designDepository.findById(designID);
            boolean result = false;

            if (design != null) {

                designDepository.delete(design);
            }
            
            session.getTransaction().commit();

            return result;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    
    }

    @Override
    public List<DesignDTO> getAllDeign() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            designDepository.setSession(session);
            
            session.beginTransaction();

            List<Design> design = designDepository.findAll();
            
            session.getTransaction().commit();

            if (design != null) {

                List<DesignDTO> alDesign = new ArrayList<>();

                for (Design designs : design) {
                    DesignDTO dto=new DesignDTO();
                    //dto.setDesignID(designs.getDesignID());
                    dto.setDesignName(designs.getDesignName());
                    dto.setDesignType(designs.getDesignType());
                    dto.setImages(designs.getImages());
                    alDesign.add(dto);
                }

                return alDesign;

            } else {

                return null;
            }

        }
    }

    @Override
    public boolean viewDeignId(Integer designID) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            designDepository.setSession(session);
            
            session.beginTransaction();

            Design design = designDepository.findById(designID);
            boolean result = false;
            session.getTransaction().commit();
            if (design != null) {

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
