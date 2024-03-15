package lk.ijse.Repository;

import lk.ijse.Entity.Member;

public interface MemberRepository extends CrudUtil<Member> {

    Member getId(int id);
}
