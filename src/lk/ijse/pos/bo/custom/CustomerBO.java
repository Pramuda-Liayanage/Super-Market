package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    ModelMapper mapper();
    void saveCustomer(CustomerDTO dto);
    void updateCustomer(CustomerDTO dto) throws Exception;
    void deleteCustomer(String id);
    void getCustomer(String id)throws Exception;
    ArrayList<CustomerDTO> getAllCustomers() throws Exception;
}
