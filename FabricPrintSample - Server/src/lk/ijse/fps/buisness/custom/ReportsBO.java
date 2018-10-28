/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom;


import lk.ijse.fps.buisness.SuperBO;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Kasun
 */
public interface ReportsBO extends SuperBO {

    

    public JasperPrint getinishedOrderReport() throws Exception;
}
