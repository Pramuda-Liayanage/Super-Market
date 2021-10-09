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
import lk.ijse.pos.bo.custom.CustomerBO;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.view.tm.CustomerTM;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static sun.net.www.MimeTable.loadTable;

public class CustomerManageFormController implements Initializable {
    public JFXTextField txtID;
    public JFXTextField txtName;
    public JFXButton btnDelete;
    public JFXButton btnAdd;
    public JFXButton btnUpdate;
    public TableView tblCustomer;
    public JFXComboBox txtType;
    public JFXTextField txtProvince;
    public JFXTextField txtAddress;
    public JFXTextField txtCity;
    public JFXTextField txtContact;
    public TableColumn tblID;
    public TableColumn tblType;
    public TableColumn tblName;
    public TableColumn tblAddress;
    public TableColumn tblCity;
    public TableColumn tblProvince;
    public TableColumn tblContact;

    CustomerBO bo = BoFactory.getInstance().getBo(BoFactory.BOType.CUSTOMER);

    public void addOnAction(ActionEvent actionEvent) {
        try {
            bo.saveCustomer(new CustomerDTO(txtID.getText(), txtType.getValue().toString(), txtName.getText(), txtAddress.getText(), txtCity.getText(), txtProvince.getText(), txtContact.getText()));

        } catch (Exception e) {
            e.getCause();
        }
    }


    public void updateOnAction(ActionEvent actionEvent) throws Exception {
        bo.updateCustomer(new CustomerDTO(txtType.getValue().toString(), txtName.getText(), txtAddress.getText(), txtCity.getText(), txtProvince.getText(), txtContact.getText(),txtID.getText()));
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        try {
            bo.deleteCustomer(txtID.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> customer = FXCollections.observableArrayList("Customer 1", "Customer 2","Customer 3","Customer 4");
        txtType.setItems(customer);
    }


    public void initialize() {
        tblID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblType.setCellValueFactory(new PropertyValueFactory<>("type"));
        tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tblCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        tblProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        tblContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        loadTable();
    }

    ObservableList<CustomerDTO> list = FXCollections.observableArrayList();

    void loadTable() {
        try {
            ArrayList<CustomerDTO> arrayList = bo.getAllCustomers();
            for (CustomerDTO dto : arrayList) {
                CustomerTM tm = new CustomerTM(
                        dto.getId(),
                        dto.getType(),
                        dto.getName(),
                        dto.getAddress(),
                        dto.getCity(),
                        dto.getProvince(),
                        dto.getContact());
                list.add(tm);
            }
            tblCustomer.setItems(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}