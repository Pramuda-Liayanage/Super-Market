package lk.ijse.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import lk.ijse.pos.bo.BoFactory;
import lk.ijse.pos.bo.custom.UserBO;

import java.io.IOException;

public class LoginFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public JFXButton btnLogin;
    public Hyperlink btnLink;

    UserBO bo = BoFactory.getInstance().getBo(BoFactory.BOType.USER);

    public void loginOnAction(ActionEvent actionEvent) throws Exception {


        String user = txtUserName.getText();
        String password = txtPassword.getText();

        boolean isSuccess = false;

        isSuccess = bo.UserLogin(password);

        if (isSuccess) {

            if (user.equals("Admin") && password.equals(password)) {

                btnLogin.getScene().getWindow().hide();
                Stage stage = new Stage();
                stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/lk/ijse/pos/view/AdminMainForm.fxml"))));
                stage.show();

            }
            if (user.equals("Cashier") && password.equals(password)) {

                btnLogin.getScene().getWindow().hide();
                Stage stage = new Stage();
                stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/lk/ijse/pos/view/CashierMainForm.fxml"))));
                stage.show();

            }

        }


    }

    public void newUserOnAction(ActionEvent actionEvent) throws IOException {
        btnLogin.getScene().getWindow().hide();
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/lk/ijse/pos/view/UserForm.fxml"))));
        stage.show();
    }
}
