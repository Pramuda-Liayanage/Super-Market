package lk.ijse.pos.dao;

import java.io.Serializable;
import java.util.List;

public interface CrudDAO<T extends Serializable, ID> extends SuperDAO {
    boolean save(T t) throws Exception;

    boolean update(T t) throws Exception;

    boolean delete(ID id) throws Exception;

    T get(ID id) throws Exception;

    List<T> getAll() throws Exception;
}
