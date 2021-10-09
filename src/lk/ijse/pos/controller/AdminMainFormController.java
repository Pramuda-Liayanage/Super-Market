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

public class AdminMainFormController {
    public AnchorPane aroot;
    public JFXButton btnItemManage;
    public JFXButton btnLogOut;

    private void initUi(String location) throws IOException {
        this.aroot.getChildren().clear();
        this.aroot.getChildren().add(FXMLLoader.load(this.getClass().getResource("/lk/ijse/pos/view/" + location)));
    }

    public void initialize() throws IOException {
        initUi("ItemManageForm.fxml");
    }

    public void itemManageOnAction(ActionEvent actionEvent) throws IOException {
        initUi("ItemManageForm.fxml");
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

//        }
    }
}
