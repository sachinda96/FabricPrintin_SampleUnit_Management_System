/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.fps.buisness.custom.LOginBO;
import lk.ijse.fps.dto.CustomerDTO;
import lk.ijse.fps.dto.LoginAccountDTO;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.entity.Customer;
import lk.ijse.fps.entity.Fabric;
import lk.ijse.fps.entity.Login;
import lk.ijse.fps.repository.RepositoryFactory;
import lk.ijse.fps.repository.custom.LoginReposistry;
import lk.ijse.fps.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Sachinda Nipun
 */
public class LoginBoImpl implements LOginBO {

    private LoginReposistry loginReposistry;

    public LoginBoImpl() {
        loginReposistry = (LoginReposistry) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.LOGIN);
    }

    @Override
    public boolean addAccount(LoginAccountDTO log) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            loginReposistry.setSession(session);

            session.beginTransaction();

            Login lo = new Login();
            lo.setCompanyId(Integer.toString(log.getCompanyId()));
            lo.setUnit(log.getUnit());
            lo.setUserName(log.getUserName());
            lo.setPasssowrd(log.getPassword());

            boolean result = loginReposistry.save(lo);

            session.getTransaction().commit();

            return result;
        } catch (Exception exp) {
            exp.printStackTrace();
            return false;

        }
    }

    @Override
    public List<LoginAccountDTO> searchName(String name) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            loginReposistry.setSession(session);

            session.beginTransaction();

            List<Login> log = loginReposistry.searchName(name);

            session.getTransaction().commit();

            if (log != null) {

                List<LoginAccountDTO> allLogs = new ArrayList<>();

                for (Login logins : log) {
                    LoginAccountDTO logs = new LoginAccountDTO();
                    logs.setUnit(logins.getUnit());
                    logs.setUserName(logins.getUserName());
                    logs.setPassword(logins.getPasssowrd());
                    allLogs.add(logs);

                }

                return allLogs;

            } else {

                return null;
            }

        }
    }

    @Override
    public LoginAccountDTO getlogs(String name) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            loginReposistry.setSession(session);

            session.beginTransaction();

            Login log = loginReposistry.findById(name);
            if (log != null) {

                System.out.println(log);
                LoginAccountDTO logAc = new LoginAccountDTO();
                logAc.setCompanyId(Integer.parseInt(log.getCompanyId()));
                logAc.setUserName(log.getUserName());
                logAc.setPassword(log.getPasssowrd());
                logAc.setUnit(log.getUnit());
                System.out.println(logAc);
                session.getTransaction().commit();

                return logAc;

            } else {
                return null;
            }

        } catch (Exception exp) {
            exp.printStackTrace();
            return null;
        }
    }

}
