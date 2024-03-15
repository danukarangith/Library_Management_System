package lk.ijse.Service;

import lk.ijse.Dto.MemberDto;

import java.util.ArrayList;

public interface UserManageService extends SuperService{
    ArrayList<MemberDto> getAll();

    void delete(int Id);
}
