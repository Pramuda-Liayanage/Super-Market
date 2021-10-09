package lk.ijse.pos.bo;

import lk.ijse.pos.bo.custom.impl.CustomerBoImpl;
import lk.ijse.pos.bo.custom.impl.OrderBoImpl;
import lk.ijse.pos.bo.custom.impl.ProductBoImpl;
import lk.ijse.pos.bo.custom.impl.UserBoImpl;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory(){}

    public static BoFactory getInstance(){
        return (boFactory==null) ? (boFactory = new BoFactory()) : (boFactory);
    }

    public enum BOType{
        CUSTOMER,ORDER,PRODUCT,USER
    }
    public <T> T getBo(BOType type){
        switch (type){
            case CUSTOMER:
                return (T) new CustomerBoImpl();
            case ORDER:
                return (T) new OrderBoImpl();
            case PRODUCT:
                return (T) new ProductBoImpl();
            case USER:
                return (T) new UserBoImpl();
            default:
                return null;
        }
    }
}
