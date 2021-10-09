package lk.ijse.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.pos.bo.BoFactory;
import lk.ijse.pos.bo.custom.ProductBO;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.dto.ProductDTO;
import lk.ijse.pos.view.tm.CustomerTM;
import lk.ijse.pos.view.tm.ProductTM;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ItemManageFormController implements Initializable {


    public JFXTextField txtID;
    public JFXTextField txtName;
    public JFXTextField txtDesc;
    public JFXTextField txtSpec;
    public JFXTextField txtDisplayName;
    public JFXTextField txtBrand;
    public JFXButton btnDelete;
    public JFXButton btnAdd;
    public JFXButton btnUpdate;
    public TableView tblItem;
    public JFXComboBox txtAvailability;
    public JFXComboBox txtState;
    public TableColumn tblId;
    public TableColumn tblName;
    public TableColumn tblDesc;
    public TableColumn tblSpec;
    public TableColumn tblDisplayName;
    public TableColumn tblAvailability;
    public TableColumn tblState;
    public TableColumn tblBrand;

    ProductBO bo = BoFactory.getInstance().getBo(BoFactory.BOType.PRODUCT);

    public void addOnAction(ActionEvent actionEvent) {
        bo.saveItem(new ProductDTO(txtID.getText(), txtName.getText(), txtDesc.getText(),
                txtSpec.getText(), txtDisplayName.getText(), txtAvailability.getValue().toString(),
                txtState.getValue().toString(), txtBrand.getText()));
    }

    public void updateOnAction(ActionEvent actionEvent) {
        bo.updateItem(new ProductDTO(txtName.getText(), txtDesc.getText(), txtSpec.getText(),
                txtDisplayName.getText(), txtAvailability.getValue().toString(), txtState.getValue().toString(),
                txtBrand.getText(),txtID.getText()));
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        bo.deleteItem(txtID.getText());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> availability = FXCollections.observableArrayList("10", "20","30","40");
        txtAvailability.setItems(availability);

        ObservableList<String> state = FXCollections.observableArrayList("10","40");
        txtState.setItems(state);
    }

    public void initialize() {
        tblId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        tblSpec.setCellValueFactory(new PropertyValueFactory<>("specification"));
        tblDisplayName.setCellValueFactory(new PropertyValueFactory<>("display_name"));
        tblAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        tblState.setCellValueFactory(new PropertyValueFactory<>("state"));
        tblBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        loadTable();
    }

    ObservableList<ProductDTO> list = FXCollections.observableArrayList();

    void loadTable() {
        try {
            ArrayList<ProductDTO> arrayList = bo.getAllItems();
            for (ProductDTO dto : arrayList) {
                ProductTM tm = new ProductTM(
                        dto.getId(),
                        dto.getName(),
                        dto.getDescription(),
                        dto.getSpecification(),
                        dto.getDisplay_name(),
                        dto.getAvailability(),
                        dto.getState(),
                        dto.getAvailable_brands());
                list.add(tm);
            }
            tblItem.setItems(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
