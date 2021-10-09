package lk.ijse.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class OrderFormController {
    public JFXTextField txtOrderID;
    public JFXTextField txtCost;
    public JFXComboBox txtCustomerID;
    public JFXComboBox txtUserID;
    public JFXDatePicker txtDate;
    public JFXButton btnPlaceOrder;
    public TableView btlOrder;
    public TableColumn tblOrderID;
    public TableColumn tblCost;
    public TableColumn tblCustomerID;
    public TableColumn tblUserID;
    public TableColumn tblDate;

    public void placeOrderOnAction(ActionEvent actionEvent) {

    }
}
