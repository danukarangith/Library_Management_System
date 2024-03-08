package lk.ijse.Bo.Custom;

import lk.ijse.Bo.SearchBookBo;
import lk.ijse.Dao.BookDao;
import lk.ijse.Dao.Custom.DaoFactory;
import lk.ijse.Dto.BookDTO;
import lk.ijse.Entity.Books;

import java.util.List;

public class SearchBookBoImpl implements SearchBookBo {
    BookDao bookDao = (BookDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.Books);

    @Override
    public BookDTO getData(String title) {

        Books data = bookDao.getData(title);

        return new BookDTO( data.getId() , data.getTitle() , data.getAutor(), data.getDis(), data.getGenre() , data.getAvailable());
    }

    @Override
    public List<String> getTitles() {
        return bookDao.getOneData();
    }
}
