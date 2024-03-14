package lk.ijse.Dto;

import lk.ijse.Entity.Books;
import lk.ijse.Entity.BorrowBook;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Book_TransactionDto {
    private int id;
    private BorrowBook transaction;
    private Books book;
}
