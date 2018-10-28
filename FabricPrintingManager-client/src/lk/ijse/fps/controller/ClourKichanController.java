/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javax.imageio.ImageIO;
import lk.ijse.fps.Demo.Validation;
import lk.ijse.fps.dto.ColourDTO;
import lk.ijse.fps.dto.ColourQueuDTO;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.observer.Observer;
import lk.ijse.fps.observer.Subject;
import lk.ijse.fps.proxy.ProxyHandler;
import lk.ijse.fps.service.ServiceFactory;
import lk.ijse.fps.service.custom.ColorQueuService;
import lk.ijse.fps.service.custom.ColorService;
import lk.ijse.fps.service.custom.FabricCuttingService;
import lk.ijse.fps.service.custom.FabricQueuService;
import lk.ijse.fps.service.custom.OrderService;

/**
 * FXML Controller class
 *
 * @author Sachinda Nipun
 */
public class ClourKichanController implements Initializable, Observer {

    private JFXTextField txtCustName;
    private JFXTextField txtDesingNumber;
    @FXML
    private JFXTextField txtDesignName;
    @FXML
    private JFXTextField txtFabricName;
    private JFXTextField txtQty;

    private ObservableList<OrderDTO> tblOrders;

    @FXML
    private JFXTextField txtColurId;
    @FXML
    private JFXTextArea txtClourdiscrption;
    @FXML
    private JFXTextField txtTechnicId;

    private String customerID;

    private String CustomerTel;

    private int OrddrID;

    private String OrderDate;

    private String OrderQty;

    private int designID;

    private int fabricId;
    private Label lblImages;

    private byte[] images;
    private Label lblSetImage;

    private ColorService colorService;

    private OrderService orderService;

    private FabricCuttingService fabricCuttingService;
    @FXML
    private TableView<OrderDTO> tblOrders1;
    @FXML
    private JFXTextField txtDesignId;
    @FXML
    private JFXTextField txtcustomerName;
    @FXML
    private JFXTextField txtFabricQty;
    @FXML
    private JFXTextField txtCustomerTel;
    @FXML
    private JFXTextField txtDesignType;
    @FXML
    private JFXTextField txtOrderDate;
    @FXML
    private JFXTextField txtOrdrQty;
    @FXML
    private JFXTextField OrderId;
    @FXML
    private JFXTextField txtTecnicType;
    @FXML
    private Label lblCid;
    @FXML
    private Label lblcId;
    @FXML
    private Label lblTType;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            fabricCuttingService = (FabricCuttingService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FABRICCUTTING);
            orderService = (OrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERS);
            colorService = (ColorService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.COLORS);

            tblOrders = FXCollections.observableArrayList();
            tblOrders1.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
            tblOrders1.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderQty"));
            tblOrders1.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("fabricName"));
            tblOrders1.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fabricQty"));
            tblOrders1.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("orderDate"));
            tblOrders1.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("designId"));
            tblOrders1.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("designName"));
            tblOrders1.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("DesignType"));
            tblOrders1.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("orderId"));

          
                UnicastRemoteObject.exportObject(this, 0);
                Subject subject = (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FABRICCUTTING);
                subject.registerObserver(this);
           
            try {
                updateObservers();
              
                lblTType.setVisible(false);
            } catch (Exception ex) {
                Logger.getLogger(ClourKichanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(ClourKichanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getOrderAction(ActionEvent event) throws Exception {
        FabricQueuService FabricList = (FabricQueuService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FabricQueuService);
        OrderDTO Orders = FabricList.getFabric();
        txtCustName.setText(Orders.getCustomerName());
        txtDesingNumber.setText(Orders.getDesignId());
        txtDesignName.setText(Orders.getDesignName());
        txtFabricName.setText(Orders.getFabricId());
        txtQty.setText(Orders.getFabricQty());

        images = Orders.getImage();
        System.out.println(images);

        customerID = Orders.getCustomerId();
        CustomerTel = Orders.getCustomerTelephone();
        OrddrID = Orders.getOrderId();
        OrderDate = Orders.getOrderDate();
        OrderQty = Orders.getOrderQty();
        fabricId = Orders.getOrderId();
        //designID=Orders.getDesignId();

    }

    @Override
    public void updateObservers() throws Exception {
        List<OrderDTO> Orders = fabricCuttingService.getColourKitchenOrders();
        if (Orders!=null) {
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

            tblOrders.add(orderDTO);

        }
        tblOrders1.setItems(tblOrders);
        }
        

    }

    private void FinshedAction(ActionEvent event) throws Exception {

    }

    public void setImages() {
        try {
            FabricQueuService fabricQueuService = (FabricQueuService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FabricQueuService);
            OrderDTO ord = fabricQueuService.getFabric();
            images = ord.getImage();
            ByteArrayInputStream byteInput = new ByteArrayInputStream(images);
            BufferedImage img = ImageIO.read(byteInput);
            javafx.scene.image.Image image = new javafx.scene.image.Image(byteInput);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(200);
            imageView.setFitHeight(150);
            lblImages.setGraphic(imageView);
        } catch (Exception ex) {
            Logger.getLogger(ClourKichanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void added(ActionEvent event) {
        try {
            System.out.println("errors");
            ColorQueuService colorQueuService = (ColorQueuService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ColorQueuService);

            OrderDTO orders = new OrderDTO();

            orders.setCustomerName(txtcustomerName.getText());
            orders.setDesignId(txtDesignId.getText());
            orders.setDesignName(txtDesignName.getText());
            orders.setDesignType(txtDesignType.getText());
            orders.setFabricName(txtFabricName.getText());
            orders.setFabricQty(txtFabricQty.getText());
            orders.setOrderDate(txtOrderDate.getText());
            orders.setOrderId(Integer.parseInt(OrderId.getText()));
            orders.setOrderQty(txtOrdrQty.getText());
            orders.setImage(images);
            orders.setPribtingTechnic(txtTecnicType.getText());
            orders.setPrintingMethod(txtClourdiscrption.getText());
            orders.setStage("Supervisor Unit");

            ColourDTO clor = new ColourDTO();
            clor.setClourDescription(txtClourdiscrption.getText());
            clor.setTechnicType(txtTecnicType.getText());
            colorService.addColor(clor);

            boolean adeed = fabricCuttingService.updateOrders(orders);
            if (adeed) {
                tblOrders1.getItems().remove(tblOrders1.getSelectionModel().getFocusedIndex());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Order Sucsess");

                alert.showAndWait();
            }
        } catch (Exception ex) {
            Logger.getLogger(ClourKichanController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setButtonOnAction(ActionEvent event) {
        System.out.println("test 1");
        try {
            // WritableImage write=new WritableImage(50, 50);
            ByteArrayInputStream byteInput = new ByteArrayInputStream(images);

            // BufferedImage img=ImageIO.read(byteInput);
            ImageIO.read(byteInput);
            Image image = new Image(byteInput);
            System.out.println(image);
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitWidth(200);
            imageView.setFitHeight(150);
            lblSetImage.setGraphic(imageView);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void setTabelData(MouseEvent event) {
        OrderDTO or = new OrderDTO();
        or = tblOrders1.getItems().get(tblOrders1.getSelectionModel().getSelectedIndex());
        txtDesignId.setText(or.getDesignId());
        txtDesignName.setText(or.getDesignName());
        txtDesignType.setText(or.getDesignType());
        txtFabricName.setText(or.getFabricName());
        txtFabricQty.setText(or.getFabricQty());
        txtOrderDate.setText(or.getOrderDate());
        txtOrdrQty.setText(or.getOrderQty());
        txtcustomerName.setText(or.getCustomerName());
        OrderId.setText(Integer.toString(or.getOrderId()));
    }

    @FXML
    private void coid(ActionEvent event) {
        try {
            if (colorService.viewcolorId(Integer.parseInt(txtColurId.getText()))==true) {
                lblCid.setVisible(true);
            }else{
                txtTechnicId.requestFocus();
                lblCid.setVisible(false);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ClourKichanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void techid(ActionEvent event) {
        if (Validation.numberOnly(txtTechnicId)) {
            txtTecnicType.requestFocus();
            lblcId.setVisible(false);
        }else{
            lblcId.setVisible(true);
        }
    }

    @FXML
    private void tecnictype(ActionEvent event) {
     if (Validation.name(txtTecnicType)) {
            txtClourdiscrption.requestFocus();
            lblTType.setVisible(false);
        }else{
            lblTType.setVisible(true);
        }
    }

}
