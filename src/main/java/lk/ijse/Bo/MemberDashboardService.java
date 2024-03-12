package lk.ijse.Bo;

import lk.ijse.Dto.MemberDto;

public interface MemberDashboardService extends SuperService{
    MemberDto getData(String username);

    void Update(MemberDto memberDto);
}
