package lk.ijse.Service;

import lk.ijse.Dto.BookDto;

import java.util.List;

public interface SearchBookService extends SuperService{
    BookDto getData(String title);
    List<String> getTitles();
}
