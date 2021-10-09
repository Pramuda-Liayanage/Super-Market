package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.ProductDAO;
import lk.ijse.pos.entity.Product;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public boolean save(Product product) throws Exception {
        return CrudUtil.execute("Insert into Product values(?,?,?,?,?,?,?,?)", product.getId()
                , product.getName(), product.getDescription(), product.getSpecification(), product.getDisplay_name(), product.getAvailability()
                , product.getState(), product.getAvailable_brands());
    }

    @Override
    public boolean update(Product product) throws Exception {
        return CrudUtil.execute("Update Product set name=?,description=?,specification=?,display_name=?,availability=?,state=?,brand=? where id=?",
                product.getName(), product.getDescription(), product.getSpecification(),
                product.getDisplay_name(), product.getAvailability()
                , product.getState(), product.getAvailable_brands(), product.getId());
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("Delete from Product where id=?", s);
    }

    @Override
    public Product get(String s) throws Exception {
        return null;
    }

    @Override
    public List<Product> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Product");
        ArrayList<Product> arrayList = new ArrayList<>();
        while (resultSet.next()) {
            arrayList.add(new Product(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8)));
        }
        return arrayList;
    }
}
