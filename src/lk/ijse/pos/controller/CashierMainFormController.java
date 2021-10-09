package lk.ijse.pos.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

import static javafx.scene.control.ButtonType.NO;
import static javafx.scene.control.ButtonType.YES;

public class CashierMainFormController {
    public AnchorPane broot;
    public JFXButton btnCustomerManage;
    public JFXButton btnLogOut;
    public JFXButton btnOrderManage;

    private void initUi(String location) throws IOException {
        this.broot.getChildren().clear();
        this.broot.getChildren().add(FXMLLoader.load(this.getClass().getResource("/lk/ijse/pos/view/" + location)));
    }

    public void initialize() throws IOException {
        initUi("CustomerManageForm.fxml");
    }

    public void customerManageOnAction(ActionEvent actionEvent) throws IOException {
        initUi("CustomerManageForm.fxml");
    }

    public void orderManageOnAction(ActionEvent actionEvent) throws IOException {
        initUi("OrderManageForm.fxml");
    }

    public void logoutAdminFormOnAction(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Are You Sure?", YES, NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get() == ButtonType.YES) {
            btnLogOut.getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/lk/ijse/pos/view/LoginForm.fxml"))));
            stage.show();
        } else if (buttonType.get() == ButtonType.NO) {

        }
    }
}
