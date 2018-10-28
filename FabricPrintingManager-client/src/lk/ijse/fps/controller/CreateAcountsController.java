/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.controller;

import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.ijse.fps.dto.LoginAccountDTO;
import lk.ijse.fps.proxy.ProxyHandler;
import lk.ijse.fps.service.ServiceFactory;
import lk.ijse.fps.service.custom.LOginService;

/**
 * FXML Controller class
 *
 * @author Sachinda Nipun
 */
public class CreateAcountsController implements Initializable {

    @FXML
    private JFXComboBox<String> cmbUnit;
    private ObservableList<String> cmblist;
    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtREPassword;
    
    private LOginService lOginService;
    @FXML
    private Label lblPassworderror;
    
   // private 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            lOginService=(LOginService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.LOGIN);
            cmblist=FXCollections.observableArrayList("BDU","Fabric","Colour KItchen","Superviser");
            cmbUnit.setItems(cmblist);
            lblPassworderror.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(CreateAcountsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void CreateOnAction(ActionEvent event) {
       
        String Password=txtPassword.getText();
        String REPassword=txtREPassword.getText();
        
           
            try {
                LoginAccountDTO log=new LoginAccountDTO();
                log.setUnit(cmbUnit.getValue());
                log.setPassword(txtPassword.getText());
                log.setUserName(txtUserName.getText());
                boolean added=lOginService.addAccount(log);
                if (added) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Craeted Sucsess");
                    
                    alert.showAndWait();
                }else{
                    lblPassworderror.setVisible(true);
                    txtPassword.requestFocus();
                }
            } catch (Exception ex) {
                Logger.getLogger(CreateAcountsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
    }
    

