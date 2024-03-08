package lk.ijse.Bo;

import lk.ijse.Dto.BookDTO;

import java.util.List;

public interface SearchBookBo extends SuperBo{
    BookDTO getData(String title);
    List<String> getTitles();
}
