package dao;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO<T> {
    List<T> showALl() throws SQLException, ClassNotFoundException;
    void insert (T t)throws SQLException, ClassNotFoundException;
    T select(String id) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;
    boolean update(T t) throws SQLException;
}
