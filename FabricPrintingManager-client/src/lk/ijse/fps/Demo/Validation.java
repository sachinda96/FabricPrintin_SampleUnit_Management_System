/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.Demo;

import com.jfoenix.controls.JFXTextField;

/**
 *
 * @author Sachinda Nipun
 */
public class Validation {
    

    public static boolean phoneNumber(JFXTextField textFild) {
        String txt = textFild.getText();
        if (txt.matches("^[0-9]{10}$")) {
            return true;
        }else{
            return false;
            }
        

    }

   public static boolean priceText(JFXTextField textField) {
        String text = textField.getText();
        if (text.matches("[0-9]+[.]?[0-9]{0,2}")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean nicValidation(JFXTextField nicTextField) {
        String text = nicTextField.getText();
        if (text.matches("[0-9]{9}[vV]")) {
            return true;
        } else {

            return false;
        }

    }

    public static boolean dobValidation(JFXTextField dobTextField) {
        String text = dobTextField.getText();
        if (text.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean numberOnly(JFXTextField textField) {
        String text = textField.getText();
        if (text.matches("^[\\d]*")) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean name(JFXTextField textFild) {
        String text = textFild.getText();
         if (text.matches("^[A-Za-z// ]*$")) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean date(String text) {
        if (text.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean time(JFXTextField textFild) {
        String text = textFild.getText();
        if (text.matches("^\\d\\d:\\d\\d$")) {
            return true;
        } else {
            return false;
        }
    }
    
     public static boolean validationEmail(JFXTextField textField) {
        String text = textField.getText();
        if (text.matches("^[(a-zA-Z-0-9-\\\\_\\\\+\\\\.)]+@[(a-z-A-z)]+\\\\.[(a-zA-z)]{2,3}$")) {
           return true;
        }else{
            return false;
        }
     }



}
