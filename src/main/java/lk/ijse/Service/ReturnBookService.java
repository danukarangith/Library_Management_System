package lk.ijse.Service;

import lk.ijse.Entity.BorrowBook;

import java.util.List;

public interface ReturnBookService extends SuperService{
    List<Integer> getAllId();

    BorrowBook getPendingData(String value);

    boolean returnBook(BorrowBook borrowBook);

    List<BorrowBook> getAllTableData();
}
