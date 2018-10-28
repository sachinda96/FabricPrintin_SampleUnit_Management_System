/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.proxy.ProxyHandler;
import lk.ijse.fps.service.ServiceFactory;
import lk.ijse.fps.service.custom.FabricCuttingService;

/**
 * FXML Controller class
 *
 * @author Sachinda Nipun
 */
public class SearcDesignController implements Initializable {

    @FXML
    private TableView<OrderDTO> tblOrders;
    
    private ObservableList<OrderDTO> listOrders;

    private FabricCuttingService fabricCuttingService;
    @FXML
    private JFXTextField txtCustomerName;
    @FXML
    private JFXButton btnSearch;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            fabricCuttingService=(FabricCuttingService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FABRICCUTTING);
            listOrders = FXCollections.observableArrayList();
            tblOrders.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
            tblOrders.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderQty"));
            tblOrders.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("fabricName"));
            tblOrders.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fabricQty"));
            tblOrders.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("orderDate"));
            tblOrders.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("designId"));
            tblOrders.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("designName"));
            tblOrders.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("DesignType"));
            tblOrders.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("orderId"));
            tblOrders.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("Stage"));
        } catch (Exception ex) {
            Logger.getLogger(SearcDesignController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void setTabelData(MouseEvent event) {
        
       
    
    }

    @FXML
    private void onActionbtnSearch(ActionEvent event) {
     try {
            List<OrderDTO> list=fabricCuttingService.searchName(txtCustomerName.getText());
            if(list==null){
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText(" Wrong Name");
            }
            for (OrderDTO orderDTO : list) {
             orderDTO.getCustomerName();
            orderDTO.getOrderDate();
            orderDTO.getOrderQty();
            orderDTO.getFabricName();
            orderDTO.getFabricQty();
            orderDTO.getDesignId();
            orderDTO.getDesignName();
            orderDTO.getDesignType();
            orderDTO.getOrderId();
            orderDTO.getStage();

            listOrders.add(orderDTO);

        }
        tblOrders.setItems(listOrders);
     
         
     } catch (Exception ex) {
            Logger.getLogger(SearcDesignController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
