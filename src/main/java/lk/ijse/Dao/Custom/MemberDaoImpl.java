package lk.ijse.Dao.Custom;

import lk.ijse.Dao.MemberDao;
import lk.ijse.Entity.Member;
import lk.ijse.util.SessionFactoryConfiguration;
import org.hibernate.Session;

import java.util.List;

public class MemberDaoImpl implements MemberDao {
    Session session = SessionFactoryConfiguration.getInstance().getSession();

    @Override
    public Member getData (int Id ) {
        return session.get(Member.class, Id);
    }

    @Override
    public List<String> getOneData() {
        return null;
    }
}
