package lk.ijse.Dto;

import lk.ijse.Entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class BorrowBookDto {
    private int id;

    private int qty;

    private Date dueDate;

    private String status;

    private Timestamp addedDate;

    private Member member;
}
