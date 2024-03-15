package lk.ijse.Service.Custom;

import lk.ijse.Service.AdminService;
import lk.ijse.Repository.AdminRepository;
import lk.ijse.Repository.Custom.RepositoryFactory;
import lk.ijse.Dto.AdminDto;
import lk.ijse.Entity.Admin;
import lk.ijse.util.SessionFactoryConfiguration;
import org.hibernate.Session;

public class AdminServiceImpl implements AdminService {
    private Session session;
    AdminRepository adminRepository = (AdminRepository) RepositoryFactory.getDaoFactory().getDao( RepositoryFactory.DaoType.admin );

    public static AdminDto data;

    public static Admin admin;
    @Override
    public boolean getData(String Id, String Password) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        adminRepository.SetSession(session);
        Admin data = adminRepository.getData(Id);

        if (data != null && Password.equals(data.getPassword())){
            this.data = new AdminDto(data.getId(),data.getName(),data.getUsername(),data.getPassword(),data.getEmail());
            admin = data;
            return true;
        }
        else {
            return false;
        }
    }
}
