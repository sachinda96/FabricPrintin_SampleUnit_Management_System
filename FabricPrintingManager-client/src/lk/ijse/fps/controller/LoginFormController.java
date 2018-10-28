/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.fps.dto.LoginAccountDTO;
import lk.ijse.fps.proxy.ProxyHandler;
import lk.ijse.fps.service.ServiceFactory;
import lk.ijse.fps.service.custom.LOginService;

/**
 * FXML Controller class
 *
 * @author Sachinda Nipun
 */
public class LoginFormController implements Initializable {

    private LOginService login;
    @FXML
    private JFXTextField txtId;
    @FXML
    private JFXTextField txtUsername;
    @FXML
    private JFXPasswordField txtPassword;

    private String UserName;

    private String password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            login = (LOginService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.LOGIN);
        } catch (Exception ex) {
            Logger.getLogger(LoginFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void lblLogin(ActionEvent event) {
        try {
            LoginAccountDTO log = login.searchPassword(txtId.getText());
            if (log != null) {

                UserName = log.getUserName();
                password = log.getPassword();
                if (UserName.equals(txtUsername.getText()) && password.equals(txtPassword.getText())) {
                    Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/fps/view/MainFrom.fxml"));
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();

                }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Login Fail Cheak Your Password and user Name");
                alert.showAndWait();
                }
            } else {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Login Fail Cheak Your Input Details");
                alert.showAndWait();
            }

        } catch (Exception ex) {
            Logger.getLogger(LoginFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void lblCreateNew(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/fps/view/CreateAccount.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
