package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.UserBO;
import lk.ijse.pos.dao.DaoFactory;
import lk.ijse.pos.dao.QueryDAO;
import lk.ijse.pos.dao.custom.UserDAO;
import lk.ijse.pos.dto.UserDTO;
import lk.ijse.pos.entity.User;
import javafx.scene.control.Alert;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;

public class UserBoImpl implements UserBO {
    private UserDAO dao= DaoFactory.getInstance().getDao(DaoFactory.DAOType.USER);
    private QueryDAO qdao= DaoFactory.getInstance().getDao(DaoFactory.DAOType.QUERY);

    @Override
    public ModelMapper mapper() {
        return new ModelMapper();
    }

    @Override
    public void saveUser(UserDTO dto) {
        try {
            boolean save = dao.save(mapper().map(dto,User.class));
            if(save){
                new Alert(Alert.AlertType.CONFIRMATION,"User Saved").showAndWait();
            }else{
                new Alert(Alert.AlertType.WARNING,"Something Wrong").showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(UserDTO dto) throws Exception {

    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public void getUser(String id) throws Exception {

    }

    @Override
    public ArrayList<UserDTO> getAllUsers() throws Exception {
        return null;
    }

    @Override
    public boolean UserLogin(String password) throws Exception {
        User user = dao.UserLogin(password);
        if (user != null)
            return true;

        return false;

    }
}
