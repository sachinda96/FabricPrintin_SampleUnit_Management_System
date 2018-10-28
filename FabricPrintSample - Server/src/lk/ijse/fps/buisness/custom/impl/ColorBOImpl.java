/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom.impl;

import java.util.List;
import lk.ijse.fps.buisness.custom.ColorBO;
import lk.ijse.fps.dto.ColourDTO;
import lk.ijse.fps.entity.Color;
import lk.ijse.fps.entity.Customer;
import lk.ijse.fps.entity.Design;
import lk.ijse.fps.entity.Fabric;
import lk.ijse.fps.repository.RepositoryFactory;
import lk.ijse.fps.repository.custom.ColorReposistry;
import lk.ijse.fps.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Sachinda Nipun
 */
public class ColorBOImpl implements ColorBO {

    private ColorReposistry colorReposistry;

    public ColorBOImpl() {
        colorReposistry = (ColorReposistry) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.COLOR);
    }

    @Override
    public boolean addColor(ColourDTO color) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            colorReposistry.setSession(session);

            session.beginTransaction();

            Color colors = new Color();
            colors.setTechnicType(color.getTechnicType());
            colors.setDescription(color.getClourDescription());
            boolean result = colorReposistry.save(colors);

            session.getTransaction().commit();

            return result;

        } catch (Exception exp) {
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateColor(ColourDTO color) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            colorReposistry.setSession(session);

            session.beginTransaction();

            Color colors = new Color();
            colors.setTechnicType(color.getTechnicType());
            colors.setDescription(color.getClourDescription());
            colorReposistry.update(colors);

            session.getTransaction().commit();

            return true;

        } catch (Exception exp) {
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteColor(Integer id) throws Exception {
       return false;
    }

    @Override
    public List<ColourDTO> getAllCustomers() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean viewcolourId(Integer colorID) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            colorReposistry.setSession(session);

            session.beginTransaction();

            Color cl = colorReposistry.findById(Integer.toString(colorID));
            boolean result = false;
            session.getTransaction().commit();
            if (cl != null) {

                return true;
            } else {
                return false;
            }

        } catch (Exception exp) {
            exp.printStackTrace();
            return false;
        }

    }

}
