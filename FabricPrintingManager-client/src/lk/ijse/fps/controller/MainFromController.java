/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.rmi.server.UnicastRemoteObject;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.fps.observer.Observer;
import lk.ijse.fps.observer.Subject;
import lk.ijse.fps.proxy.ProxyHandler;
import lk.ijse.fps.service.ServiceFactory;
import lk.ijse.fps.service.custom.FabricCuttingService;

/**
 * FXML Controller class
 *
 * @author Sachinda Nipun
 */
public class MainFromController implements Initializable ,Observer{

    @FXML
    private AnchorPane pameAncore;
    @FXML
    private JFXButton onDamageDesign;
    @FXML
    private Label lblSetTitle;
    @FXML
    private PieChart ChartPie;
    
    private double DamageOrder;
   
    private double finidhedOrder;
    
    private FabricCuttingService fabricCuttingService;
    
    private int DamageDesing;
    @FXML
    private AnchorPane paneViewOrs;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            Subject sub=(Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FABRICCUTTING);
            fabricCuttingService=(FabricCuttingService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FABRICCUTTING);
           
            
            updateObservers();
        } catch (Exception ex) {
            Logger.getLogger(MainFromController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    private void onOrderAction(ActionEvent event) {
        try {
            AnchorPane anchor = FXMLLoader.load(this.getClass().getResource("/lk/ijse/fps/view/BDUOrderForm.fxml"));
            pameAncore.getChildren().setAll(anchor);
        } catch (IOException ex) {
            Logger.getLogger(MainFromController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void onFabricAction(ActionEvent event) {
     try {
            AnchorPane anchor = FXMLLoader.load(this.getClass().getResource("/lk/ijse/fps/view/FabricCuttingUnitForm.fxml"));
            pameAncore.getChildren().setAll(anchor);
        } catch (IOException ex) {
            Logger.getLogger(MainFromController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    private void oncolorrAction(ActionEvent event) {
    try {
            AnchorPane anchor = FXMLLoader.load(this.getClass().getResource("/lk/ijse/fps/view/ClourKichan.fxml"));
            pameAncore.getChildren().setAll(anchor);
        } catch (IOException ex) {
            Logger.getLogger(MainFromController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    private void onPrintrAction(ActionEvent event) {
    try {
            AnchorPane anchor = FXMLLoader.load(this.getClass().getResource("/lk/ijse/fps/view/SupervisorForm.fxml"));
            pameAncore.getChildren().setAll(anchor);
        } catch (IOException ex) {
            Logger.getLogger(MainFromController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onFinishedDesign(ActionEvent event) {
        try {
            AnchorPane anchor = FXMLLoader.load(this.getClass().getResource("/lk/ijse/fps/view/ViewFinishOrders.fxml"));
            pameAncore.getChildren().setAll(anchor);
        } catch (IOException ex) {
            Logger.getLogger(MainFromController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onDamageDesign(ActionEvent event) {
    try {
            AnchorPane anchor = FXMLLoader.load(this.getClass().getResource("/lk/ijse/fps/view/ViewDamagedOrders.fxml"));
            pameAncore.getChildren().setAll(anchor);
        } catch (IOException ex) {
            Logger.getLogger(MainFromController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @FXML
    private void onSearchDesign(ActionEvent event) {
         try {
            AnchorPane anchor = FXMLLoader.load(this.getClass().getResource("/lk/ijse/fps/view/SearcDesign.fxml"));
            pameAncore.getChildren().setAll(anchor);
        } catch (IOException ex) {
            Logger.getLogger(MainFromController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onCustomer(ActionEvent event) throws IOException {
             Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/fps/view/CustomerForm.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
           // lblSetTitle.setText("Customer Form");
    }

    @FXML
    private void homeOn(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/fps/view/MainFrom.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainFromController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public void updateObservers() throws Exception {
        DamageDesing=fabricCuttingService.getOrderDetail();
        
         ObservableList<PieChart.Data> chatr;
            chatr = FXCollections.observableArrayList(
                    new PieChart.Data("Dmage Design",DamageDesing),
                    new PieChart.Data("Finished Design", 50)
                    
                    
            );
            
            ChartPie.setData(chatr);
        System.out.println(DamageDesing);
    }

    @FXML
    private void onFabric(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/fps/view/FabricDetails.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainFromController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void OnFabricLbl(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/fps/view/FabricCuttingUnitForm.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainFromController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onColourLbl(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/fps/view/ClourKichan.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainFromController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void OnBduLbl(MouseEvent event) {
         try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/fps/view/BDUOrderForm.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainFromController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @FXML
    private void OnSupervisorLbl(MouseEvent event) {
         try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/fps/view/SupervisorForm.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainFromController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
}
