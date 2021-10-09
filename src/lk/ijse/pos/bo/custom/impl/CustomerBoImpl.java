package lk.ijse.pos.bo.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.pos.bo.custom.CustomerBO;
import lk.ijse.pos.dao.DaoFactory;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.view.tm.CustomerTM;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class CustomerBoImpl implements CustomerBO {
    CustomerDAO dao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.CUSTOMER);

    @Override
    public ModelMapper mapper() {
        return new ModelMapper();
    }

    @Override
    public void saveCustomer(CustomerDTO dto) {
        try {
            boolean save = dao.save(mapper().map(dto,Customer.class));
            if(save){
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Saved").showAndWait();
            }else{
                new Alert(Alert.AlertType.WARNING,"Something Wrong").showAndWait();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        try {
            boolean update = dao.update(mapper().map(dto, Customer.class));
            if(update){
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Updated").showAndWait();
            }else{
                new Alert(Alert.AlertType.WARNING,"Something Wrong").showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(String id)  {
        try {
            boolean delete = dao.delete(id);
            if(delete){
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Deleted").showAndWait();
            }else{
                new Alert(Alert.AlertType.WARNING,"Something Wrong").showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getCustomer(String id) throws Exception {

    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws Exception {
        List<Customer> list = dao.getAll();
        ArrayList<CustomerDTO> arrayList = new ArrayList<>();
        for (Customer c : list){
            arrayList.add(mapper().map(c, CustomerTM.class));
        }
        return arrayList;
    }
}
