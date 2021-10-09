package lk.ijse.pos.bo.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.pos.bo.custom.ProductBO;
import lk.ijse.pos.dao.DaoFactory;
import lk.ijse.pos.dao.custom.ProductDAO;
import lk.ijse.pos.dto.ProductDTO;
import lk.ijse.pos.entity.Product;
import lk.ijse.pos.view.tm.ProductTM;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class ProductBoImpl implements ProductBO {
    ProductDAO dao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.PRODUCT);

    @Override
    public ModelMapper mapper() {
        return new ModelMapper();
    }

    @Override
    public void saveItem(ProductDTO dto) {
        try {
            boolean save = dao.save(mapper().map(dto, Product.class));
            if (save) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item Saved");
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Wrong!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateItem(ProductDTO dto) {
        try {
            boolean update = dao.update(mapper().map(dto, Product.class));
            if (update) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item Updated");
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Wrong!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteItem(String id) {
        try {
            boolean delete = dao.delete(id);
            if (delete == true) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item Deleted");
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Wrong!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void getItem(String id) {

    }

    @Override
    public ArrayList<ProductDTO> getAllItems() throws Exception {
        List<Product> list = dao.getAll();
        ArrayList<ProductDTO> arrayList = new ArrayList<>();
        for (Product c : list) {
            arrayList.add(mapper().map(c, ProductTM.class));
        }
        return arrayList;
    }
}
