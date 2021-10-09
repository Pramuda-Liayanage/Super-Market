package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBO;
import org.modelmapper.ModelMapper;

public interface OrderBO extends SuperBO {
    ModelMapper mapper();
}
