package lk.ijse.Bo.Custom;

import lk.ijse.Bo.AdminBo;
import lk.ijse.Dao.AdminDao;
import lk.ijse.Dao.Custom.DaoFactory;
import lk.ijse.Entity.Admin;

public class AdminBoImpl implements AdminBo {
    AdminDao adminDao = (AdminDao) DaoFactory.getDaoFactory().getDao( DaoFactory.DaoType.admin );
    @Override
    public boolean getData(int Id, String Password) {
        try {

            Admin data = adminDao.getData(Id);

            if (data !=null || Password.equals(data.getPassword())){
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
