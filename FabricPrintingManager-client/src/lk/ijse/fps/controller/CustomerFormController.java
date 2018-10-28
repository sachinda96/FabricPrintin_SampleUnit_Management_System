/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.fps.dto.CustomerDTO;
import lk.ijse.fps.dto.OrderDTO;
import lk.ijse.fps.observer.Observer;
import lk.ijse.fps.observer.Subject;
import lk.ijse.fps.proxy.ProxyHandler;
import lk.ijse.fps.service.ServiceFactory;
import lk.ijse.fps.service.custom.CustomerService;

/**
 * FXML Controller class
 *
 * @author Sachinda Nipun
 */
public class CustomerFormController implements Initializable, Observer {

    private JFXTextField txtCName;
    private JFXTextField txtCTel;
    @FXML
    private TableView<CustomerDTO> tblOrders;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnDelet;

    private ObservableList<CustomerDTO> allCustomers;

    private CustomerService customerService;

    private int CustomerId;

    private boolean update = false;

    private String ReserveCustomerID ;
    @FXML
    private JFXTextField txtCFName;
    @FXML
    private JFXTextField txtCLName;
    @FXML
    private JFXTextField txtCCompany;
    @FXML
    private JFXTextField txtTelNo;
    @FXML
    private JFXTextField txtEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            Subject sub = (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
            sub.registerObserver(this);
            customerService = (CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
            allCustomers = FXCollections.observableArrayList();
            tblOrders.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("customerID"));
            tblOrders.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Firstname"));
            tblOrders.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Lastname"));
            tblOrders.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Company"));
            tblOrders.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("telNumber"));
            tblOrders.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("Email"));

              
            updateObservers();
        } catch (Exception ex) {
            Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void onAdd(ActionEvent event) {
        try {
            CustomerDTO c = new CustomerDTO();
            c.setFirstname(txtCFName.getText());
            c.setLastname(txtCLName.getText());
            c.setCompany(txtCCompany.getText());
            c.setTelNumber(txtTelNo.getText());
            c.setEmail(txtEmail.getText());
            
            boolean added = customerService.addCustomer(c);
            if (added) {
                for (int i = 0; i < tblOrders.getItems().size(); i++) {
                    tblOrders.getItems().clear();
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Customer Added");
                alert.showAndWait();
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onDelet(ActionEvent event) {
        try {
            if (customerService.deleteCustomer(CustomerId)) {
                btnAdd.setVisible(true);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Customer Deleted");
                alert.showAndWait();
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onUpdate(ActionEvent event) {
        try {
            CustomerDTO c = new CustomerDTO();
            c.setCustomerID(CustomerId);
            c.setFirstname(txtCFName.getText());
            c.setLastname(txtCLName.getText());
            c.setCompany(txtCCompany.getText());
            c.setTelNumber(txtTelNo.getText());
            c.setEmail(txtEmail.getText());

            boolean update = customerService.addCustomer(c);
            if (update) {
                for (int i = 0; i < tblOrders.getItems().size(); i++) {
                    tblOrders.getItems().clear();
                }
                btnAdd.setVisible(true);
                System.out.println("goda");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Customer updated");
                alert.showAndWait();
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateObservers() throws Exception {
        loadAllCustomers();
    }

    @FXML
    private void setTabelData(MouseEvent event) throws Exception {

        
        
        if (ReserveCustomerID == "") {
                //ustomerService.release(ReserveCustomerID);
        }
        TablePosition pos = tblOrders.getSelectionModel().getSelectedCells().get(0);
                int row = pos.getRow();
           TableColumn col = pos.getTableColumn();
            // this gives the value in the selected cell:
            ReserveCustomerID = col.getCellObservableValue(row).getValue().toString();
                System.out.println("Sucsess "+ReserveCustomerID);
                boolean ReserveCustomer = customerService.reserve(ReserveCustomerID);
                if (ReserveCustomer) {
                    //update = true;
                    CustomerDTO c = new CustomerDTO();
                    c = tblOrders.getItems().get(tblOrders.getSelectionModel().getSelectedIndex());
                    txtCFName.setText(c.getFirstname());
                    txtCLName.setText(c.getLastname());
                    txtCCompany.setText(c.getCompany());
                    txtTelNo.setText(c.getTelNumber());
                    txtEmail.setText(c.getEmail());
                    CustomerId = c.getCustomerID();
                    btnAdd.setVisible(false);
                } else {
                   // update = false;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Customer has been already reserved");
                    alert.showAndWait();
                }

         
        

    }
    
    private void loadAllCustomers(){
        try {
            List<CustomerDTO> customer = customerService.getAllCustomers();
            
            for (CustomerDTO c : customer) {
                c.getCustomerID();
                c.getFirstname();
                c.getLastname();
                c.getCompany();
                c.getTelNumber();
                c.getEmail();
                
                allCustomers.add(c);
                
            }
            tblOrders.setItems(allCustomers);
        } catch (Exception ex) {
            Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
