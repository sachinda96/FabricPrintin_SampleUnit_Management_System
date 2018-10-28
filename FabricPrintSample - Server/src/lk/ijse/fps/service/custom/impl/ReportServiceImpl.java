/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lk.ijse.fps.buisness.BOFactory;
import lk.ijse.fps.buisness.custom.ReportsBO;
import lk.ijse.fps.service.custom.RepoerService;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Sachinda Nipun
 */
public class ReportServiceImpl extends UnicastRemoteObject implements RepoerService{

    private ReportsBO reportsBO;
    
    public ReportServiceImpl()throws RemoteException{
        reportsBO=(ReportsBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.REPORTS);
    }
    @Override
    public JasperPrint getTelephoneOperatorReport() throws Exception {
        return reportsBO.getinishedOrderReport();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
