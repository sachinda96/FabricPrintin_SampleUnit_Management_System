/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.controller;

import java.awt.Dialog;
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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JFrame;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.observer.Observer;
import lk.ijse.fps.proxy.ProxyHandler;
import lk.ijse.fps.service.ServiceFactory;
import lk.ijse.fps.service.custom.FabricCuttingService;
import lk.ijse.fps.service.custom.RepoerService;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Sachinda Nipun
 */
public class ViewFinishOrdersController implements Initializable,Observer {

    @FXML
    private TableView<OrderDTO> tblOrders;

    private ObservableList<OrderDTO> tblData;
    
    private FabricCuttingService fabricCuttingService;
    
    private RepoerService repoerService;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            fabricCuttingService=(FabricCuttingService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FABRICCUTTING);
            repoerService=(RepoerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.REPORT);
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
        } catch (Exception ex) {
            Logger.getLogger(ViewFinishOrdersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void setTabelData(MouseEvent event) {
       
    }

    @Override
    public void updateObservers() throws Exception {
        List<OrderDTO> Orders = fabricCuttingService.getOrdersFinished();

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

    @FXML
    private void ViewReport(ActionEvent event) throws Exception {
         
            JasperPrint jasperReport= repoerService.getTelephoneOperatorReport();
            JasperViewer jasper=new JasperViewer(jasperReport);
            jasper.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jasper.setTitle("Finished Orders");
            jasper.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
            jasper.setVisible(true);

    }
    
}
