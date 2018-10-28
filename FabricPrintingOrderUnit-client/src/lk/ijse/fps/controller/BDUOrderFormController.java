/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import javax.management.Notification;
import static javax.management.Query.value;
import lk.ijse.fps.Demo.Validation;
import lk.ijse.fps.proxy.ProxyHandler;
import lk.ijse.fps.dto.CustomerDTO;
import lk.ijse.fps.dto.DesignDTO;
import lk.ijse.fps.dto.ItemDTO;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.dto.OrderDetailDto;
import lk.ijse.fps.dto.OrderDetail_PKDto;
import lk.ijse.fps.dto.PlaceOrderDTO;
import lk.ijse.fps.observer.Observer;
import lk.ijse.fps.observer.Subject;
import lk.ijse.fps.service.ServiceFactory;
import lk.ijse.fps.service.custom.CustomerService;
import lk.ijse.fps.service.custom.DesignService;
import lk.ijse.fps.service.custom.FabricCuttingService;
import lk.ijse.fps.service.custom.OrderQueuService;
import lk.ijse.fps.service.custom.OrderService;

/**
 * FXML Controller class
 *
 * @author Sachinda Nipun
 */
public class BDUOrderFormController implements Initializable, Observer {

    @FXML
    private JFXButton btnPlaceOrder;

    @FXML
    private JFXTextField txtDesignName;

    @FXML
    private JFXTextField txtFabricName;
    @FXML
    private JFXTextField txtFabricIdQty;

    @FXML
    private JFXTextField txtOrderQty;

    private byte[] Images;

    private OrderService orderService;
    @FXML
    private JFXTextField txtDesignType;
    @FXML
    private JFXDatePicker txtDate;
    @FXML
    private TableView<OrderDTO> tblOrder;

    private ObservableList<OrderDTO> orders;
    @FXML
    private JFXTextField txtOrderPrice;
    @FXML
    private JFXTextField txtTotalOrder;

    private String OrderDate;

    private String DeliveryDate;

    private JFXTextField txtOrderID;
    private JFXTextField txtDesignID;
    @FXML
    private JFXDatePicker txtDeliveryDate;

    private Subject subject;

    private FabricCuttingService fabricCuttingService;

    private int Total;

    private DesignService designService;

    private Label inCname;
    private Label inCtel;

    private Label inOdate;
    @FXML
    private Label inOrderQty;
    @FXML
    private Label inFabName;
    @FXML
    private Label infabqty;

    private Label indId;
    @FXML
    private Label indnme;
    @FXML
    private Label indTyp;
    @FXML
    private Label inpr;
    @FXML
    private Label lblSetComplet;
    @FXML
    private JFXProgressBar prograss;
    @FXML
    private JFXComboBox<String> cmbCustomers;

    private CustomerService customerService;

    private ObservableList<String> allCustomers;
    @FXML
    private JFXButton btnNewCustomer;
    @FXML
    private JFXTextField txtDesignNumber;
    @FXML
    private Label lblDID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            allCustomers = FXCollections.observableArrayList();
            UnicastRemoteObject.exportObject(this, 0);
            subject = (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERS);
            subject.registerObserver(this);
            System.out.println(subject);
            LoadCustomers();
            designService = (DesignService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.DESIGN);
            orderService = (OrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERS);
            fabricCuttingService = (FabricCuttingService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FABRICCUTTING);
            customerService = (CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
            orders = FXCollections.observableArrayList();
            tblOrder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
            tblOrder.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderQty"));
            tblOrder.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("fabricName"));
            tblOrder.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fabricQty"));
            tblOrder.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("designName"));
            tblOrder.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("DesignType"));
            updateObservers();
        } catch (Exception ex) {
            Logger.getLogger(BDUOrderFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

        inFabName.setVisible(false);
        inOrderQty.setVisible(false);
        indTyp.setVisible(false);
        indnme.setVisible(false);
        infabqty.setVisible(false);
        inpr.setVisible(false);
        lblDID.setVisible(false);

        prograss.setProgress(0.0);

    }

    private void addbtn(ActionEvent event) throws MalformedURLException {

    }

    @Override
    public void updateObservers() throws Exception {
        List<CustomerDTO> customerDTOs = customerService.getAllCustomers();
        for (CustomerDTO customerDTO : customerDTOs) {
            String cus = customerDTO.getFirstname();
            allCustomers.add(cus);
        }

        cmbCustomers.setItems(allCustomers);

    }

    @FXML
    private void OnPlaceOrder(ActionEvent event) {
        try {
            String DesignName = null;
            String DesignType = null;
            CustomerDTO cust = new CustomerDTO();
            cust.setFirstname(cmbCustomers.getValue().toString());

            OrderDTO order = new OrderDTO();

            LocalDate date = txtDate.getValue();
            OrderDate = date.toString();

            LocalDate dateDelivery = txtDeliveryDate.getValue();
            DeliveryDate = dateDelivery.toString();

            order.setCustomerName(cmbCustomers.getValue().toString());
            order.setDesignName(txtDesignName.getText());
            order.setFabricQty(txtFabricIdQty.getText());
            order.setDesignType(txtDesignType.getText());
            order.setFabricName(txtFabricName.getText());
            order.setFabricName(txtFabricName.getText());
            order.setFabricQty(txtFabricIdQty.getText());

            OrderDetailDto orderDetail = null;
            OrderDetail_PKDto pk = null;
            List<OrderDetailDto> orderList = new ArrayList<>();
            List<OrderDTO> ordersList = new ArrayList<>();
            DesignDTO design = null;
            OrderDTO orders = null;
            for (int i = 0; i < tblOrder.getItems().size(); i++) {

                DesignName = tblOrder.getColumns().get(4).getCellData(i).toString();
                DesignType = tblOrder.getColumns().get(5).getCellData(i).toString();
                design = new DesignDTO();
                design.setDesignNumber(txtDesignNumber.getText());
                design.setDesignName(DesignName);
                design.setDesignType(DesignType);
                design.setImages(Images);

                orderDetail = new OrderDetailDto();
                orderDetail.setItem(design);
                orderDetail.setOrders(order);
                orderDetail.setPrice(Double.parseDouble(txtTotalOrder.getText()));
                orderDetail.setOrderDate(OrderDate);
                orderDetail.setDeliveryDate(DeliveryDate);

                pk = new OrderDetail_PKDto();
                pk.setDesigID(design.getDesignID());
                pk.setOrderId(order.getOrderId());
                orderDetail.setOrderDetail_PKDto(pk);
                System.out.println(pk);
                orderList.add(orderDetail);
            }

            order = new OrderDTO();
            order.setOrderId(order.getOrderId());
            order.setCustomerName(cmbCustomers.getValue().toString());
            order.setDesignId(txtDesignNumber.getText());
            order.setDesignName(DesignName);
            order.setDesignType(DesignType);
            order.setFabricName(txtFabricName.getText());
            order.setFabricQty(txtFabricIdQty.getText());
            order.setOrderDate(OrderDate);
            order.setOrderQty(txtOrderQty.getText());
            order.setAvailable("pending");
            order.setStage("Fabric unit");

            order.setOrderDate(date.toString());
            order.setOrderQty(txtOrderQty.getText());

            PlaceOrderDTO placeorder = new PlaceOrderDTO();
            placeorder.setCustomerDTO(cust);
            placeorder.setOrderDTO(order);
            placeorder.setDesignDTO(design);
            placeorder.setOrderDetails(orderList);
            placeorder.setOrderDetailPKDto(pk);

            boolean addeds = orderService.addOrders(placeorder);
            if (addeds) {
                for (int i = 0; i < tblOrder.getItems().size(); i++) {
                    tblOrder.getItems().clear();
                }

                txtDesignType.clear();
                txtFabricName.clear();
                txtFabricIdQty.clear();
                txtOrderPrice.clear();
                txtOrderQty.clear();
                txtDesignName.clear();

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Order Sucsess");

                alert.showAndWait();

            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Order Faield");

                alert.showAndWait();
            }
        } catch (Exception ex) {
            Logger.getLogger(BDUOrderFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void setPrice(ActionEvent event) {
        if (Validation.priceText(txtOrderPrice)) {
            btnPlaceOrder.requestFocus();

            OrderDTO order = new OrderDTO();
            order.setCustomerName(cmbCustomers.getSelectionModel().getSelectedItem());
            order.setOrderQty(txtOrderQty.getText());
            order.setFabricName(txtFabricName.getText());
            order.setFabricQty(txtFabricIdQty.getText());
            order.setDesignName(txtDesignName.getText());
            order.setDesignType(txtDesignType.getText());

            int tot = Integer.parseInt(txtOrderPrice.getText());

            Total = tot + Total;
            txtTotalOrder.setText(Integer.toString(Total));

            orders.add(order);
            tblOrder.setItems(orders);
        } else {

        }
    }


    private void oId(ActionEvent event) {
        try {
            if (orderService.viewOrderId(Integer.parseInt(txtOrderID.getText())) == true) {
                //  txtOrderDate.requestFocus();

                inOdate.setVisible(true);
            } else {
                txtDate.show();
                inOdate.setVisible(false);
            }
        } catch (Exception ex) {
            Logger.getLogger(BDUOrderFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void oQty(ActionEvent event) {
        if (Validation.numberOnly(txtOrderQty)) {
            txtDeliveryDate.requestFocus();
            txtDeliveryDate.show();
            inOrderQty.setVisible(false);
        } else {

            inOrderQty.setVisible(true);
        }
    }

    @FXML
    private void FabName(ActionEvent event) {
        prograss.setProgress(0.50);
        lblSetComplet.setText("Complet 50%");
        if (Validation.name(txtFabricName)) {
            txtFabricIdQty.requestFocus();
            inFabName.setVisible(false);
        } else {
            inFabName.setVisible(true);
        }
    }

    @FXML
    private void fabQty(ActionEvent event) {
        if (Validation.numberOnly(txtFabricIdQty)) {
            txtDesignNumber.requestFocus();
            infabqty.setVisible(false);
        } else {

            infabqty.setVisible(true);
        }
    }

    private void Did(ActionEvent event) {
        try {
            if (designService.viewDeignId(Integer.parseInt(txtDesignID.getText())) == true) {
                indId.setVisible(true);
            } else {
                indId.setVisible(false);
                txtDesignName.requestFocus();
            }
        } catch (Exception ex) {
            Logger.getLogger(BDUOrderFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Dname(ActionEvent event) {
        if (Validation.name(txtDesignName)) {
            txtDesignType.requestFocus();
            indnme.setVisible(false);
        } else {

            indnme.setVisible(true);
        }
    }

    @FXML
    private void Dtype(ActionEvent event) {
        prograss.setProgress(1.0);
        lblSetComplet.setText("Complet 100%");
        if (Validation.name(txtDesignType)) {
            txtOrderPrice.requestFocus();
            indTyp.setVisible(false);
        } else {
            indTyp.setVisible(true);
        }
    }

    @FXML
    private void setCustomers(ActionEvent event) {
    }

    private void LoadCustomers() throws Exception {

//            System.out.println(customerService.getAllCustomers());
    }

    @FXML
    private void NewCustomerOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/fps/views/CustomerForm.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(BDUOrderFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void fabDNumber(ActionEvent event) {
        try {
             
            if (designService.viewDeignId(Integer.parseInt(txtDesignNumber.getText()))==true) {
                lblDID.setVisible(true);
            }else{
                lblDID.setVisible(false);
                txtDesignName.requestFocus();
                
            }
        } catch (Exception ex) {
            Logger.getLogger(BDUOrderFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnLogOut(MouseEvent event) {
        System.exit(0);
    }

}
