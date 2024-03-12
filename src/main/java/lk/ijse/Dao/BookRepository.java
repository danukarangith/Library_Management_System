package lk.ijse.Dao;

import lk.ijse.Entity.Books;

public interface BookRepository extends CrudUtil<Books> {
    Books getData(String title);
}
