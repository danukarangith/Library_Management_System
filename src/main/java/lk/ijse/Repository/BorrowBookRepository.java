package lk.ijse.Repository;

import lk.ijse.Entity.BorrowBook;
import lk.ijse.Entity.Member;

public interface BorrowBookRepository extends CrudUtil<BorrowBook> {
    BorrowBook getData(Member Id);

    int BookCount(Member data);
}
