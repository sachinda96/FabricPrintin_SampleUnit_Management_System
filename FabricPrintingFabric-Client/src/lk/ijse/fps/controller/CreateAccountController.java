/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.swing.JOptionPane;
import lk.ijse.fps.dto.LoginAccountDTO;
import lk.ijse.fps.proxy.ProxyHandler;
import lk.ijse.fps.service.ServiceFactory;
import lk.ijse.fps.service.custom.LOginService;

/**
 * FXML Controller class
 *
 * @author Sachinda Nipun
 */
public class CreateAccountController implements Initializable {

    @FXML
    private JFXTextField txtId;
    @FXML
    private JFXTextField txtUserName;
    @FXML
    private JFXTextField txtPassword;
    @FXML
    private JFXButton crateOnAction;
    @FXML
    private JFXComboBox<String> cmbUnit;

    private ObservableList<String> List;
    
    private LOginService log;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            log=(LOginService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.LOGIN);
            List = FXCollections.observableArrayList("BDU", "Fabric", "Colour KItchen", "Superviser","Manager");
            cmbUnit.setItems(List);
        } catch (Exception ex) {
            Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void crateOnAction(ActionEvent event) {
        try {
            LoginAccountDTO login=new LoginAccountDTO();
            login.setCompanyId(Integer.parseInt(txtId.getText()));
            login.setUserName(txtUserName.getText());
            login.setPassword(txtPassword.getText());
            login.setUnit(cmbUnit.getValue());
            
            boolean adeed=log.addAccount(login);
            if (adeed) {
                System.out.println("hari");
            }
        } catch (Exception ex) {
            Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
