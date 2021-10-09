package lk.ijse.pos.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.UserDAO;
import lk.ijse.pos.entity.User;

import java.sql.ResultSet;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean save(User user) throws Exception {
        return CrudUtil.execute("Insert into User values(?,?,?,?)", user.getId(), user.getName(), user.getPassword(), user.getType());
    }

    @Override
    public boolean update(User user) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public User get(String s) throws Exception {
        return null;
    }

    @Override
    public List<User> getAll() throws Exception {
        return null;
    }

    @Override
    public User UserLogin(String password) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM User WHERE password =?",password);
        if (rst.next()) {
            return new User(
                    rst.getString(1),
                    (rst.getString(2)),
                    (rst.getString(3)),
                    (rst.getString(4)));

        }
        return null;
    }
}
