package lk.ijse.Dao.Custom;

import com.mysql.cj.Session;
import lk.ijse.Dao.BookDao;
import lk.ijse.Entity.Books;
import lk.ijse.util.SessionFactoryConfiguration;
import org.hibernate.Query;
 


import java.util.List;

public class BookDaoImpl implements BookDao {
    Session session = SessionFactoryConfiguration.getInstance().getSession();
    @Override
    public Books getData(String title) {
        String sql = "SELECT B FROM Books AS B WHERE B.title =: title";
        Query query = session.createQuery(sql);
        query.setParameter("title",title);
        return (Books) query.getSingleResult();
    }

    @Override
    public Books getData(int Id) {
        return null;
    }

    @Override
    public List<String> getOneData() {
        String sql = "SELECT B.title FROM Books AS B";
        Query query = session.createQuery(sql);
        List<String> titles = query.getResultList();
        return titles;
    }
}
