package lk.ijse.Dao;

import lk.ijse.Entity.Admin;

public interface AdminRepository extends CrudUtil<Admin> {
    Admin getData();
}
