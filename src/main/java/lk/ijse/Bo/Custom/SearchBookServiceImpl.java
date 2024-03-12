package lk.ijse.Bo.Custom;

import lk.ijse.Bo.SearchBookService;
import lk.ijse.Dao.BookRepository;
import lk.ijse.Dao.Custom.RepositoryFactory;
import lk.ijse.Dto.BookDto;
import lk.ijse.Entity.Books;
import lk.ijse.util.SessionFactoryConfiguration;
import org.hibernate.Session;

import java.util.List;

public class SearchBookServiceImpl implements SearchBookService {
    private final BookRepository bookRepository = (BookRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Books);
    private Session session;
    @Override
    public BookDto getData(String title) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        bookRepository.SetSession(session);
        Books data = bookRepository.getData(title);

        return new BookDto( data.getId() , data.getTitle() , data.getAutor(), data.getDis(), data.getGenre() , data.getAvailable());
    }

    @Override
    public List<String> getTitles() {
        session = SessionFactoryConfiguration.getInstance().getSession();
        bookRepository.SetSession(session);
        return bookRepository.getOneData();
    }
}
