package lk.ijse.Bo.Custom;

import lk.ijse.Bo.MemberBo;
import lk.ijse.Dao.Custom.DaoFactory;
import lk.ijse.Dao.MemberDao;
import lk.ijse.Entity.Member;

public class MemberBoImpl implements MemberBo {
    MemberDao memberDao = (MemberDao) DaoFactory.getDaoFactory().getDao( DaoFactory.DaoType.Member );
    @Override
    public boolean Login(int Username, String Password) {
        try {
            Member allData = memberDao.getData(Username);

            if (allData !=null || Password.equals(allData.getPassword())){
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
