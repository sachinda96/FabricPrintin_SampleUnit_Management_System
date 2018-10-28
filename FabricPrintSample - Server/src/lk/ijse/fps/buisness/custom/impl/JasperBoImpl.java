/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom.impl;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.fps.buisness.custom.ReportsBO;
import lk.ijse.fps.resource.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.hibernate.Session;

/**
 *
 * @author Sachinda Nipun
 */
public class JasperBoImpl implements ReportsBO {
    
    private Connection connection;
    
    @Override
    
    public JasperPrint getinishedOrderReport() throws JRException {
        try {
            JasperReport compiledReport = (JasperReport) JRLoader.loadObject(JasperBoImpl.class.getResourceAsStream("/reports/Blank_A4.jasper"));
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.doWork((cnctn) -> {
                connection = cnctn;
            });
            JasperPrint filledReport = JasperFillManager.fillReport(compiledReport, null, connection);
            
            return filledReport;
        } catch (JRException ex) {
            Logger.getLogger(JasperBoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
}
