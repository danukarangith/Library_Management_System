package lk.ijse.Bo.Custom;

import lk.ijse.Bo.BranchService;
import lk.ijse.Dao.BranchRepository;
import lk.ijse.Dao.Custom.RepositoryFactory;
import lk.ijse.Dto.BranchDto;
import lk.ijse.Entity.Branch;
import lk.ijse.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class BranchServiceImpl implements BranchService {
    private Session session;

    private Transaction transaction;
    private final BranchRepository branchRepository = (BranchRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Branch);

    @Override
    public ArrayList<BranchDto> getAll() {
        session = SessionFactoryConfiguration.getInstance().getSession();
        branchRepository.SetSession(session);
        ArrayList<Branch> all = branchRepository.getAll();
        ArrayList<BranchDto> branchDtos = new ArrayList<>();
        for (Branch branch : all) {
            branchDtos.add(new BranchDto(branch.getId(), branch.getName(), branch.getLocation(), branch.getEmail()));
        }
        return branchDtos;
    }

    @Override
    public int save(BranchDto branchDto) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        branchRepository.SetSession(session);
        int saved =  branchRepository.saved(new Branch(branchDto.getId(), branchDto.getName(), branchDto.getLocation(), branchDto.getEmail(), AdminServiceImpl.admin));
        transaction = session.beginTransaction();
        transaction.commit();
        if (saved > 0) {
            return saved;
        }
        else {
            transaction.rollback();
            return -1;
        }
    }

    @Override
    public void update(BranchDto branchDto) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        branchRepository.SetSession(session);
        branchRepository.Update(new Branch(branchDto.getId(), branchDto.getName(), branchDto.getLocation(), branchDto.getEmail(),AdminServiceImpl.admin));
        transaction = session.beginTransaction();
        transaction.commit();
    }

    @Override
    public void delete(int id) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        branchRepository.SetSession(session);
        branchRepository.Delete(id);
        transaction = session.beginTransaction();
        transaction.commit();
    }
}
