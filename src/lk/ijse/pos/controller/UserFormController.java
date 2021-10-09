package lk.ijse.pos.controller;

import lk.ijse.pos.bo.BoFactory;
import lk.ijse.pos.bo.custom.UserBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import lk.ijse.pos.dto.UserDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserFormController implements Initializable {
    public JFXTextField txtUserId;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public JFXComboBox txtUserType;
    public JFXButton btnCreate;
    UserBO bo=BoFactory.getInstance().getBo(BoFactory.BOType.USER);
    public JFXButton btnBack;



    public void backOnAction(ActionEvent actionEvent) throws IOException {
        btnBack.getScene().getWindow().hide();
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/lk/ijse/pos/view/LoginForm.fxml"))));
        stage.setTitle("Login Form");
        stage.show();


    }

    public void createOnAction(ActionEvent actionEvent) throws Exception {
        bo.saveUser(new UserDTO(txtUserId.getText(),txtUserName.getText(),txtPassword.getText(),txtUserType.getValue().toString()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> admin = FXCollections.observableArrayList("Admin","Cashier");
        txtUserType.setItems(admin);
    }
}
