package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.entity.Order;

import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public boolean save(Order order) throws Exception {
        return false;
    }

    @Override
    public boolean update(Order order) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Order get(String s) throws Exception {
        return null;
    }

    @Override
    public List<Order> getAll() throws Exception {
        return null;
    }
}
