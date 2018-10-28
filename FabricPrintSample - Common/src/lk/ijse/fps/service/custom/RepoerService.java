/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.service.custom;

import lk.ijse.fps.service.SuperService;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Sachinda Nipun
 */
public interface RepoerService extends SuperService{
     public JasperPrint getTelephoneOperatorReport() throws Exception ;
}
