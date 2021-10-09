package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.dto.UserDTO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;

public interface UserBO extends SuperBO {
    ModelMapper mapper();
    void saveUser(UserDTO dto);
    void updateUser(UserDTO dto)throws Exception;
    void deleteUser(String id);
    void getUser(String id)throws Exception;
    ArrayList<UserDTO> getAllUsers()throws Exception;
    boolean UserLogin(String password) throws Exception;
}
