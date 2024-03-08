package lk.ijse.Dao.Custom;

import lk.ijse.Dao.SuperDao;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory(){}

    public static  DaoFactory getDaoFactory() {
        return  (daoFactory == null) ? daoFactory = new DaoFactory() : daoFactory;
    }

    public enum DaoType{
        Member ,admin, Books
    }

    public SuperDao getDao(DaoType daoType ){
        switch ( daoType ){
            case Member :
                return new MemberDaoImpl();

            case admin:
                return new AdminDaoImpl();
            case Books:
                return new BookDaoImpl();
            default:
                return null;
        }
    }
}
