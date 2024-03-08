package lk.ijse.Dao;

import lk.ijse.Entity.Member;

public interface MemberDao extends CrudUtil<Member> {
    Member getData(int Id);
}
