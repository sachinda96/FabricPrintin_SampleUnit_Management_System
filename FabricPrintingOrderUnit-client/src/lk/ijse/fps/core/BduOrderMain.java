/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.core;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lk.ijse.fps.controller.BDUOrderFormController;
import lk.ijse.fps.observer.Subject;
import lk.ijse.fps.proxy.ProxyHandler;
import lk.ijse.fps.service.ServiceFactory;

/**
 *
 * @author Sachinda Nipun
 */
public class BduOrderMain extends Application{

    /**
     * @param args the command line arguments
     */
    
    private BDUOrderFormController bdu;
    public static void main(String[] args) {
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
       Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/fps/views/LoginForm.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setResizable(false);
//        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//           @Override
//           public void handle(WindowEvent event) {
//               Subject sub;
//               try {
//                   sub = (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.OrderQueuService);
//                   sub.unregisterObserver(bdu);
//               } catch (Exception ex) {
//                   Logger.getLogger(BduOrderMain.class.getName()).log(Level.SEVERE, null, ex);
//               }
//              
//               
//           }
//       });
    }
    
}
