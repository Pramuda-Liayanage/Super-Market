package lk.ijse.pos.dao;

import lk.ijse.pos.bo.custom.impl.ProductBoImpl;
import lk.ijse.pos.dao.custom.impl.*;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory(){}

    public static DaoFactory getInstance(){
        return (daoFactory==null) ? (daoFactory = new DaoFactory()) : (daoFactory);
    }

    public enum DAOType{
        CUSTOMER,ORDER,PRODUCT,USER,QUERY
    }
    public <T> T getDao(DaoFactory.DAOType type){
        switch (type){
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case ORDER:
                return (T) new OrderDAOImpl();
            case PRODUCT:
                return (T) new ProductDAOImpl();
            case USER:
                return (T) new UserDAOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            default:
                return null;
        }
    }
}
