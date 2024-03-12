package lk.ijse.Bo;

import lk.ijse.Dto.BranchDto;

import java.util.ArrayList;

public interface BranchService extends SuperService{
    ArrayList<BranchDto> getAll();

    int save(BranchDto branchDto);

    void update(BranchDto branchDto);

    void delete(int id);
}
