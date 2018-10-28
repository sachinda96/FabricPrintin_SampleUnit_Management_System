/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.fps.dto.ColourDTO;
import lk.ijse.fps.dto.ColourQueuDTO;
import lk.ijse.fps.dto.CustomerDTO;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.dto.PlaceOrderDTO;
import lk.ijse.fps.observer.Observer;
import lk.ijse.fps.observer.Subject;
import lk.ijse.fps.proxy.ProxyHandler;
import lk.ijse.fps.service.ServiceFactory;
import lk.ijse.fps.service.custom.ColorQueuService;
import lk.ijse.fps.service.custom.FabricCuttingService;
import lk.ijse.fps.service.custom.FabricQueuService;
import lk.ijse.fps.service.custom.OrderQueuService;
import lk.ijse.fps.service.custom.OrderService;
import lk.ijse.fps.service.custom.SupervisorQueuService;

/**
 * FXML Controller class
 *
 * @author Sachinda Nipun
 */
public class SupervisorFormController implements Initializable, Observer {

    /**
     * Initializes the controller class.
     */
    private SupervisorQueuService supervisorQueuService;
    private TableView<ColourQueuDTO> tblOrders;
    private JFXTextField txtDesignID;
    @FXML
    private JFXTextField txtDesignName;
    private JFXTextField txtFabricName;
    private JFXTextField txtFabricQty;
    @FXML
    private JFXTextField txtDesignTecnic;
    private JFXTextArea txthowPrint;

    private ObservableList<OrderDTO> tblData;

    private ColorQueuService clor;

    private String CustomerID;

    private String Customertel;

    private String CustomerName;

    private int OrderID;

    private String OrderDate;

    private String OrderQty;

    private FabricCuttingService fabricCuttingService;

    private String PribtingMethod;

    private String FabricQty;

    private String FabricName;

    private ObservableList<ColourQueuDTO> tblGetOrderData;

    private OrderService orderService;
    @FXML
    private TableView<OrderDTO> tblOrders1;
    @FXML
    private JFXTextField txtDesignId;
    @FXML
    private JFXTextField txtDesignType;

    @FXML
    private TableView<OrderDTO> tblOrders11;

    private ObservableList<OrderDTO> setOrders;
    @FXML
    private JFXTextArea txthowPrinttedesign;
    @FXML
    private JFXButton btnFinish;
    @FXML
    private JFXButton btnDesign;
    @FXML
    private JFXButton btnGetOrders;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            Subject sub = (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FABRICCUTTING);
            sub.registerObserver(this);
            fabricCuttingService = (FabricCuttingService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FABRICCUTTING);
            clor = (ColorQueuService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ColorQueuService);
            orderService = (OrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERS);
            tblData = FXCollections.observableArrayList();
            setOrders = FXCollections.observableArrayList();
            tblOrders1.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
            tblOrders1.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderQty"));
            tblOrders1.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("fabricName"));
            tblOrders1.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fabricQty"));
            tblOrders1.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("orderDate"));
            tblOrders1.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("designId"));
            tblOrders1.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("designName"));
            tblOrders1.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("DesignType"));
            tblOrders1.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("orderId"));
            tblOrders1.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("PribtingTechnic"));
            tblOrders1.getColumns().get(10).setCellValueFactory(new PropertyValueFactory<>("printingMethod"));

            tblOrders11.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
            tblOrders11.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderQty"));
            tblOrders11.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("fabricName"));
            tblOrders11.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fabricQty"));
            tblOrders11.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("orderDate"));
            tblOrders11.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("designId"));
            tblOrders11.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("designName"));
            tblOrders11.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("DesignType"));
            tblOrders11.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("orderId"));
            tblOrders11.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("PribtingTechnic"));
            tblOrders11.getColumns().get(10).setCellValueFactory(new PropertyValueFactory<>("printingMethod"));
            updateObservers();
            btnDesign.setVisible(false);
            btnFinish.setVisible(false);

        } catch (Exception ex) {
            Logger.getLogger(SupervisorFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateObservers() throws Exception {

        List<OrderDTO> Orders = fabricCuttingService.getsupervisorOrders();
        if (Orders != null) {

            for (int i = 0; i < tblOrders1.getItems().size(); i++) {
                tblOrders1.getItems().clear();
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
                orderDTO.getPribtingTechnic();
                orderDTO.getPrintingMethod();
                tblData.add(orderDTO);

            }
            tblOrders1.setItems(tblData);
        }
    }

    private void getOrders(ActionEvent event) {
        try {
            ColourQueuDTO c = clor.getColourse();
            txthowPrint.setText(c.getColourdto().getClourDescription());
            txtDesignID.setText(c.getOrderdto().getDesignId());
            txtDesignTecnic.setText(c.getColourdto().getTechnicType());
            txtFabricName.setText(c.getOrderdto().getFabricName());
            txtFabricQty.setText(c.getOrderdto().getFabricQty());
            txtDesignName.setText(c.getOrderdto().getDesignName());

            CustomerID = c.getOrderdto().getCustomerId();
            CustomerName = c.getOrderdto().getCustomerName();
            Customertel = c.getOrderdto().getCustomerTelephone();
            OrderDate = c.getOrderdto().getOrderDate();
            OrderQty = c.getOrderdto().getOrderQty();

        } catch (Exception ex) {
            Logger.getLogger(SupervisorFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void FinshedOrder(ActionEvent event) {
        OrderDTO or = new OrderDTO();
        or = tblOrders11.getItems().get(tblOrders11.getSelectionModel().getSelectedIndex());
        if (or != null) {
            try {
                btnDesign.setVisible(true);
                btnFinish.setVisible(true);
                OrderDTO orders = new OrderDTO();
                orders.setCustomerName(or.getCustomerName());
                orders.setDesignId(or.getDesignId());
                orders.setDesignName(or.getDesignName());
                orders.setDesignType(or.getDesignType());
                orders.setFabricName(or.getFabricName());
                orders.setFabricQty(or.getFabricQty());
                orders.setOrderDate(or.getOrderDate());
                orders.setOrderId(or.getOrderId());
                orders.setOrderQty(or.getOrderQty());
                orders.setPribtingTechnic(or.getPribtingTechnic());
                orders.setPrintingMethod(or.getPrintingMethod());
                orders.setStage("Finished");
                tblOrders11.getItems().remove(or);

                boolean update = fabricCuttingService.updateOrders(orders);
                if (update) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Order Sucsess");

                    alert.showAndWait();
                }
            } catch (Exception ex) {
                Logger.getLogger(SupervisorFormController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @FXML
    private void designDamaged(ActionEvent event) {

        OrderDTO or = new OrderDTO();
        or = tblOrders11.getItems().get(tblOrders11.getSelectionModel().getSelectedIndex());
        if (or != null) {
            try {
                btnDesign.setVisible(true);
                btnFinish.setVisible(true);
                OrderDTO orders = new OrderDTO();
                orders.setCustomerName(or.getCustomerName());
                orders.setDesignId(or.getDesignId());
                orders.setDesignName(or.getDesignName());
                orders.setDesignType(or.getDesignType());
                orders.setFabricName(or.getFabricName());
                orders.setFabricQty(or.getFabricQty());
                orders.setOrderDate(or.getOrderDate());
                orders.setOrderId(or.getOrderId());
                orders.setOrderQty(or.getOrderQty());
                orders.setPribtingTechnic(or.getPribtingTechnic());
                orders.setPrintingMethod(or.getPrintingMethod());
                orders.setStage("Damaged");
                tblOrders11.getItems().remove(or);

                boolean update = fabricCuttingService.updateOrders(orders);
                if (update) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Order Sucsess");

                    alert.showAndWait();
                }
            } catch (Exception ex) {
                Logger.getLogger(SupervisorFormController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @FXML
    private void setTabelData(MouseEvent event) {
        OrderDTO or = new OrderDTO();
        or = tblOrders1.getItems().get(tblOrders1.getSelectionModel().getSelectedIndex());

        txtDesignId.setText(or.getDesignId());
        txtDesignName.setText(or.getDesignName());
        txtDesignType.setText(or.getDesignType());
        FabricName = or.getFabricName();
        FabricQty = or.getOrderQty();
        OrderDate = or.getOrderDate();
        OrderQty = or.getOrderQty();
        CustomerName = or.getCustomerName();
        OrderID = or.getOrderId();
        txtDesignTecnic.setText(or.getPribtingTechnic());
        txthowPrinttedesign.setText(or.getPrintingMethod());
        PribtingMethod = or.getPrintingMethod();
    }

    @FXML
    private void addSeconTableData(MouseEvent event) {

    }

    @FXML
    private void btnget(ActionEvent event) {
        try {
            OrderDTO dto = new OrderDTO();
            dto.setCustomerName(CustomerName);
            dto.setCustomerId(CustomerID);
            dto.setDesignId(txtDesignId.getText());
            dto.setDesignName(txtDesignName.getText());
            dto.setDesignType(txtDesignType.getText());
            dto.setFabricName(FabricName);
            dto.setFabricQty(FabricQty);
            dto.setOrderDate(OrderDate);
            dto.setOrderQty(OrderQty);
            dto.setOrderId(OrderID);
            dto.setPribtingTechnic(txtDesignTecnic.getText());
            String tem = txthowPrinttedesign.getText();
            System.out.println(tem);
            dto.setPrintingMethod(tem);
            setOrders.add(dto);

            tblOrders11.setItems(setOrders);

            tblOrders1.getItems().remove(tblOrders1.getSelectionModel().getSelectedIndex());

        } catch (Exception ex) {
            Logger.getLogger(SupervisorFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Tbale2MouceClick(MouseEvent event) {
        btnDesign.setVisible(true);
        btnFinish.setVisible(true);
    }

}
