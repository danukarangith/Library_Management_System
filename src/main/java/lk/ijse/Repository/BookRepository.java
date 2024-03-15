package lk.ijse.Repository;

import lk.ijse.Entity.Books;

public interface BookRepository extends CrudUtil<Books> {
    Books getData(String title);
}
