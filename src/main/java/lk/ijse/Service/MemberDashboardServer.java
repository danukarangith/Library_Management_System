package lk.ijse.Service;

import lk.ijse.Dto.MemberDto;

public interface MemberDashboardServer extends SuperService{
    MemberDto getData(String username);

    void Update(MemberDto memberDto);
}
