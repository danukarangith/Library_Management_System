package lk.ijse.Dao;

import lk.ijse.Entity.Books;

public interface BookDao extends CrudUtil<Books> {
    Books getData(String title);
}
