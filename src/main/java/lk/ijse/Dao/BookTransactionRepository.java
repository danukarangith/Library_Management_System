package lk.ijse.Dao;

import lk.ijse.Entity.Book_Transaction;

import java.util.List;

public interface BookTransactionRepository extends CrudUtil<Book_Transaction> {
    List<Book_Transaction> bookTransactionData(String id);
}
