package lk.ijse.Bo.Custom;

import lk.ijse.Bo.RegisterBo;
import lk.ijse.Dao.Custom.DaoFactory;
import lk.ijse.Dao.MemberDao;
import lk.ijse.Dto.MemberDTO;
import lk.ijse.Entity.Member;

public class RegisterBoImpl implements RegisterBo {
    MemberDao memberDao = (MemberDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.Member);
    @Override
    public int Register(MemberDTO member) {
        int saved = memberDao.saved(new Member(member.getId(),member.getFull_name(),member.getUsername(),member.getPassword(),member.getEmail()));
        return saved;
    }

}
