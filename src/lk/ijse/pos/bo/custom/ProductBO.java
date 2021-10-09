package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.dto.ProductDTO;
import lk.ijse.pos.dto.UserDTO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;

public interface ProductBO extends SuperBO {
    ModelMapper mapper();
    void saveItem(ProductDTO dto) ;
    void updateItem(ProductDTO dto);
    void deleteItem(String id);
    void getItem(String id);
    ArrayList<ProductDTO> getAllItems() throws Exception;
}
