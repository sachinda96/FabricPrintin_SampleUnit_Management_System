/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.controller;

import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.fps.dto.FabricDTO;
import lk.ijse.fps.observer.Observer;
import lk.ijse.fps.observer.Subject;
import lk.ijse.fps.proxy.ProxyHandler;
import lk.ijse.fps.service.ServiceFactory;
import lk.ijse.fps.service.custom.FabricService;

/**
 * FXML Controller class
 *
 * @author Sachinda Nipun
 */
public class FabricDetailsController implements Initializable ,Observer{

    @FXML
    private TableView<FabricDTO> tblFbaricDetails;
    
    private ObservableList<FabricDTO> allFabric;
    
    private FabricService fabricService;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            Subject sub=(Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FABRIC);
            fabricService=(FabricService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FABRIC);
            
            allFabric = FXCollections.observableArrayList();
            tblFbaricDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("FabricName"));
            tblFbaricDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Colorway"));
            tblFbaricDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("FabricItem"));
            tblFbaricDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Colorway"));
            updateObservers();
        } catch (RemoteException ex) {
            Logger.getLogger(FabricDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FabricDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }    

    @Override
    public void updateObservers() throws Exception {
        loadFabric();
    }
    
    private void loadFabric(){
        try {
            List<FabricDTO> fabric=fabricService.getAllFabric();
            for (FabricDTO fabricDTO : fabric) {
                FabricDTO fabrictbl=new FabricDTO();
                fabrictbl.setFabricName(fabricDTO.getFabricName());
                fabrictbl.setFabricItem(fabricDTO.getFabricItem());
                fabrictbl.setFabricTypes(fabricDTO.getFabricTypes());
                fabrictbl.setColorway(fabricDTO.getColorway());
                
                allFabric.add(fabrictbl);
            }
            tblFbaricDetails.setItems(allFabric);
        } catch (Exception ex) {
            Logger.getLogger(FabricDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
