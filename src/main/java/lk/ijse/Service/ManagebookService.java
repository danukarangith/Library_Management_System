package lk.ijse.Service;

import lk.ijse.Dto.BookDto;

import java.util.ArrayList;
import java.util.List;

public interface ManagebookService extends SuperService{
    ArrayList<BookDto> getAll();
    void Update(BookDto memberDto);

    void Delete(int Id);

    int Save(BookDto yes);

    BookDto search(String text);

    List<String> getTitles();
}
