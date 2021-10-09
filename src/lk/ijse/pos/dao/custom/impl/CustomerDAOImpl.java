package lk.ijse.pos.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.entity.Customer;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean save(Customer customer) throws Exception {
        Boolean execute = CrudUtil.execute("Insert into Customer Values(?,?,?,?,?,?,?)", customer.getId(), customer.getType(), customer.getName(), customer.getAddress(), customer.getCity(), customer.getProvince(), customer.getContact());
        return execute;
    }

    @Override
    public boolean update(Customer customer) throws Exception {
        boolean execute = CrudUtil.execute("UPDATE Customer SET type=?,name=?,address=?,city=?,province=?,contact=? WHERE id=?",  customer.getId(),customer.getType(), customer.getName(), customer.getAddress(), customer.getCity(), customer.getProvince(), customer.getContact());
        return execute;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("Delete from Customer where id=?", s);
    }

    @Override
    public Customer get(String s) throws Exception {
        return null;
    }

    @Override
    public List<Customer> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Customer");
        ArrayList<Customer> arrayList = new ArrayList<>();
        while (resultSet.next()){
            arrayList.add(new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)));
        }
        return arrayList;
    }
}
