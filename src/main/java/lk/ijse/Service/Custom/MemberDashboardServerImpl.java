package lk.ijse.Service.Custom;

import lk.ijse.Repository.BorrowBookRepository;
import lk.ijse.Service.MemberDashboardServer;
import lk.ijse.Repository.Custom.RepositoryFactory;
import lk.ijse.Repository.MemberRepository;
import lk.ijse.Dto.MemberDto;
import lk.ijse.Entity.Member;
import lk.ijse.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MemberDashboardServerImpl implements MemberDashboardServer {
    private final MemberRepository memberRepository = (MemberRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Member);

    private final BorrowBookRepository borrowBook = (BorrowBookRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.BorrowBook);
    private Session session;
    private Transaction transaction;
    @Override
    public MemberDto getData(String username) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);
        Member data = memberRepository.getData(username);
        session.close();
        return new MemberDto(data.getId(), data.getFull_name(), data.getUsername(), data.getPassword(), data.getEmail());
    }

    @Override
    public void Update(MemberDto memberDto) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);
        memberRepository.Update(new Member(memberDto.getId(), memberDto.getFull_name(), memberDto.getUsername(), memberDto.getPassword(), memberDto.getEmail()));
        transaction = session.beginTransaction();
        transaction.commit();
        session.close();
    }
}
