package lk.ijse.Service;

import lk.ijse.Dto.AdminDto;

public interface AdminRegisterservice extends SuperService{
    int saveAdmin(AdminDto adminDto);
}
