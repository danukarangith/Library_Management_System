package lk.ijse.Service.Custom;

import lk.ijse.Service.RegisterService;
import lk.ijse.Repository.Custom.RepositoryFactory;
import lk.ijse.Repository.MemberRepository;
import lk.ijse.Dto.MemberDto;
import lk.ijse.Entity.Member;
import lk.ijse.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RegisterServiceImpl implements RegisterService {
    private final MemberRepository memberRepository = (MemberRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Member);
    private Session session;
    private Transaction transaction;
    @Override
    public int Register(MemberDto member) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);
        int saved = memberRepository.saved(new Member(member.getId(),member.getFull_name(),member.getUsername(),member.getPassword(),member.getEmail()));
        transaction = session.beginTransaction();
        if (saved > 0) {
            transaction.commit();
        }
        else {
            transaction.rollback();
        }
        return saved;
    }
}
