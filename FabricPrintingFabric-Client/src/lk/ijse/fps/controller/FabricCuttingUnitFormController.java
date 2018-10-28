/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.fps.Demo.Validation;
import lk.ijse.fps.dto.FabricDTO;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.observer.Observer;
import lk.ijse.fps.observer.Subject;
import lk.ijse.fps.proxy.ProxyHandler;
import lk.ijse.fps.service.ServiceFactory;
import lk.ijse.fps.service.custom.FabricCuttingService;
import lk.ijse.fps.service.custom.FabricQueuService;
import lk.ijse.fps.service.custom.FabricService;
import lk.ijse.fps.service.custom.OrderQueuService;
import lk.ijse.fps.service.custom.OrderService;

/**
 * FXML Controller class
 *
 * @author Sachinda Nipun
 */
public class FabricCuttingUnitFormController implements Initializable, Observer {

    @FXML
    private JFXTextField txtDesignId;
    @FXML
    private JFXTextField txtDesignName;
    private JFXTextField txtFabricId;
    @FXML
    private JFXTextField txtFabricName;
    @FXML
    private JFXTextField txtFabricQty;
    @FXML
    private JFXTextField txtFinishFabricQty;
    @FXML
    private TableView<OrderDTO> tblOrders;

    private OrderDTO orders;

    private String CustomerID;

    private String CustomerName;

    private String CustomerTelephone;

    private String orderId;

    private String orderDate;

    private String orderQty;

    private byte[] images;

    private int orderid;

    private ObservableList<OrderDTO> tblData;

    private OrderService orderService;

    private FabricService fabricService;
    @FXML
    private JFXTextField txtFabricType;
    @FXML
    private JFXTextField txtColorway;
    @FXML
    private JFXTextField txtFabricItem;

    private FabricCuttingService fabricCuttingService;
    @FXML
    private JFXTextField txtcustomerName;
    private JFXTextField txtCustomerTel;
    @FXML
    private JFXTextField txtDesignType;
    @FXML
    private JFXTextField txtOrderDate;
    @FXML
    private JFXTextField txtOrdrQty;

    private String fabriciD;
    @FXML
    private JFXTextField OrderId;
    @FXML
    private Label inffqty;
    private Label infabid;
    @FXML
    private Label infabtype;
    @FXML
    private Label infabitem;
    @FXML
    private Label infabcoloway;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            orderService = (OrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERS);
            fabricCuttingService = (FabricCuttingService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FABRICCUTTING);
            fabricService = (FabricService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FABRIC);
       
        
            UnicastRemoteObject.exportObject(this, 0);
            Subject sub = (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERS);
            sub.registerObserver(this);
            tblData = FXCollections.observableArrayList();
            tblOrders.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
            tblOrders.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderQty"));
            tblOrders.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("fabricName"));
            tblOrders.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fabricQty"));
            tblOrders.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("orderDate"));
            tblOrders.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("designId"));
            tblOrders.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("designName"));
            tblOrders.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("DesignType"));
            tblOrders.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("orderId"));
            updateObservers();
            
            infabcoloway.setVisible(false);
            infabitem.setVisible(false);
            infabtype.setVisible(false);
            inffqty.setVisible(false);

        } catch (Exception ex) {
            Logger.getLogger(FabricCuttingUnitFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getDesign(ActionEvent event) throws Exception {

    }

    @FXML
    private void FinishFabricSettings(ActionEvent event) throws Exception {

        OrderDTO orders = new OrderDTO();

        orders.setCustomerName(txtcustomerName.getText());
        orders.setDesignId(txtDesignId.getText());
        orders.setDesignName(txtDesignName.getText());
        orders.setDesignType(txtDesignType.getText());
        orders.setFabricName(txtFabricName.getText());
        orders.setFabricQty(txtFinishFabricQty.getText());
        orders.setOrderDate(txtOrderDate.getText());
        orders.setOrderId(Integer.parseInt(OrderId.getText()));
        orders.setOrderQty(txtOrdrQty.getText());
        orders.setImage(images);
        orders.setStage("Colour Kitchen");

        FabricService fabricService = (FabricService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FABRIC);
        FabricDTO fabric = new FabricDTO();
        fabric.setFabricName(txtFabricName.getText());
        fabric.setFabricTypes(txtFabricType.getText());
        fabric.setFabricItem(txtFabricItem.getText());
        fabric.setColorway(txtColorway.getText());

        boolean Added = fabricCuttingService.updateOrders(orders);
        fabricService.addFabric(fabric);

        if (Added) {
            tblOrders.getItems().remove(tblOrders.getSelectionModel().getSelectedItem());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Order Sucsess");

            alert.showAndWait();
        }

    }

    private void setData() throws Exception {

    }


    @FXML
    private void setTabelData(MouseEvent event) {
        OrderDTO or = new OrderDTO();
        or = tblOrders.getItems().get(tblOrders.getSelectionModel().getSelectedIndex());
        txtDesignId.setText(or.getDesignId());
        txtDesignName.setText(or.getDesignName());
        txtDesignType.setText(or.getDesignType());
        txtFabricName.setText(or.getFabricName());
        txtFabricQty.setText(or.getOrderQty());
        txtOrderDate.setText(or.getOrderDate());
        txtOrdrQty.setText(or.getOrderQty());
        txtcustomerName.setText(or.getCustomerName());
        OrderId.setText(Integer.toString(or.getOrderId()));

    }

    @Override
    public void updateObservers() throws Exception {
        List<OrderDTO> Orders = fabricCuttingService.getFabricOrders();
            if (Orders!=null) {
             for (int i = 0; i < tblOrders.getItems().size(); i++) {
                    tblOrders.getItems().clear();
                }
        for (OrderDTO orderDTO : Orders) {

            orderDTO.getCustomerName();
            orderDTO.getOrderDate();
            orderDTO.getOrderQty();
            orderDTO.getFabricName();
            orderDTO.getFabricQty();
            orderDTO.getDesignId();
            orderDTO.getDesignName();
            orderDTO.getDesignType();
            orderDTO.getOrderId();

            tblData.add(orderDTO);

        }
        tblOrders.setItems(tblData);
            }
    
    }

    @FXML
    private void FinishedfabricQty(ActionEvent event) {
            if (Validation.numberOnly(txtFinishFabricQty)) {
                txtFabricName.requestFocus();
                inffqty.setVisible(false);
        }else{
                inffqty.setVisible(true);
            }
    }

    @FXML
    private void fabrictype(ActionEvent event) {
           if (Validation.name(txtFabricType)) {
                txtFabricItem.requestFocus();
                infabtype.setVisible(false);
        }else{
                infabtype.setVisible(true);
            }
    }

    @FXML
    private void fabricItems(ActionEvent event) {
         if (Validation.name(txtFabricItem)) {
                txtColorway.requestFocus();
                infabitem.setVisible(false);
        }else{
                infabitem.setVisible(true);
            }
    }

    @FXML
    private void fabricolourway(ActionEvent event) {
         if (Validation.name(txtColorway)) {
                //txtColorway.requestFocus();
                infabcoloway.setVisible(false);
        }else{
                infabcoloway.setVisible(true);
            }
    }

    private void fabricId(ActionEvent event) {
        try {
            if (fabricService.viewfabricId(Integer.parseInt(txtFabricId.getText()))==true) {
                
                infabid.setVisible(true);
            }else{
                txtFabricType.requestFocus();
                infabid.setVisible(false);
            }
        } catch (Exception ex) {
            Logger.getLogger(FabricCuttingUnitFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
