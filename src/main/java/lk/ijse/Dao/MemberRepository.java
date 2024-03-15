package lk.ijse.Dao;

import lk.ijse.Entity.Member;

public interface MemberRepository extends CrudUtil<Member> {

    Member getId(int id);
}
