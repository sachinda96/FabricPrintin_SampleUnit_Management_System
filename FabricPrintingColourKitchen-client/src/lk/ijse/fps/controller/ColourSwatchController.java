/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.controller;

import com.jfoenix.controls.JFXColorPicker;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

/**
 * FXML Controller class
 *
 * @author Sachinda Nipun
 */
public class ColourSwatchController implements Initializable {

    @FXML
    private JFXColorPicker clpicker;
    @FXML
    private Label lblBackground;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clpickerOnAction(ActionEvent event) {
        Paint value0 = Paint.valueOf(clpicker.getValue().toString());
   
   lblBackground.setBackground(new Background(new BackgroundFill(value0, CornerRadii.EMPTY, Insets.EMPTY)));
    
    
    }

    @FXML
    private void clpickerOnActionMouse(MouseEvent event) {
        System.out.println("mouse");
        
    }
    
}
