package lk.ijse.Dao;

import java.util.List;

public interface CrudUtil<T> extends SuperDao{
    T getData(int Id);
    int saved(T data);

    List<String> getOneData();
}
