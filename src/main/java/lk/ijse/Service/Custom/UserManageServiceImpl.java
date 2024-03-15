package lk.ijse.Service.Custom;

import lk.ijse.Service.UserManageService;
import lk.ijse.Repository.Custom.RepositoryFactory;
import lk.ijse.Repository.MemberRepository;
import lk.ijse.Dto.MemberDto;
import lk.ijse.Entity.Member;
import lk.ijse.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class UserManageServiceImpl implements UserManageService {
    private final MemberRepository memberRepository = (MemberRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Member);
    private Session session = SessionFactoryConfiguration.getInstance().getSession();

    private Transaction transaction;
    @Override
    public ArrayList<MemberDto> getAll() {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);

        ArrayList<Member> all = memberRepository.getAll();

        ArrayList<MemberDto> admins = new ArrayList<>();

        for (Member admin : all) {
            admins.add(new MemberDto(admin.getId(), admin.getFull_name(), admin.getUsername(), admin.getPassword(), admin.getEmail()));
        }

        return admins;
    }

    @Override
    public void delete(int Id) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);
        memberRepository.Delete(Id);
        transaction = session.beginTransaction();
        transaction.commit();
    }
}
