package lk.ijse.Repository.Custom;

import lk.ijse.Repository.MemberRepository;
import lk.ijse.Entity.Member;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MemberRepositoryImpl implements MemberRepository {
    private Session session;;

    @Override
    public Member getData ( String Id ) {
        System.out.println(Id);
        String hql = "FROM Member WHERE username = :username";
        Query<Member> query = session.createQuery(hql, Member.class);
        query.setParameter("username",Id);
        return query.uniqueResult();
    }
    @Override
    public Member getId(int id){
        System.out.println(id);
        return session.get(Member.class, id);
    }

    @Override
    public List<String> getOneData() {
        return null;
    }

    @Override
    public int saved(Member data) {
        int value = (int) session.save(data);
        return value;
    }

    @Override
    public ArrayList<Member> getAll() {
        String sqlQuery = "FROM Member";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();
        return (ArrayList<Member>) list;
    }

    @Override
    public void Update(Member Data) {
        session.update(Data);
    }

    @Override
    public void Delete(int Id) {
        Member member = session.get(Member.class, Id);
        session.delete(member);
    }

    @Override
    public long Count() {
        String sql = "select count(*) from Member";
        org.hibernate.Query query = session.createQuery(sql);
        return (long) query.uniqueResult();
    }

    @Override
    public void SetSession(Session session) {
        this.session = session;
    }
}
