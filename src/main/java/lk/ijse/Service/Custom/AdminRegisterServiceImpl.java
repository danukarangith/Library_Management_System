package lk.ijse.Service.Custom;

import lk.ijse.Service.AdminRegisterservice;
import lk.ijse.Repository.AdminRepository;
import lk.ijse.Repository.Custom.RepositoryFactory;
import lk.ijse.Dto.AdminDto;
import lk.ijse.Entity.Admin;
import lk.ijse.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminRegisterServiceImpl implements AdminRegisterservice {
    private final AdminRepository adminRepository = (AdminRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.admin);

    private Session session;

    private Transaction transaction;

    @Override
    public int saveAdmin(AdminDto adminDto) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        adminRepository.SetSession(session);
        int saved = adminRepository.saved(new Admin(adminDto.getId(), adminDto.getName(), adminDto.getUsername(), adminDto.getPassword(), adminDto.getEmail()));

        transaction = session.beginTransaction();
        transaction.commit();
        if (saved > 0) {
            return saved;
        } else {
            transaction.rollback();
            return -1;
        }
    }
}
