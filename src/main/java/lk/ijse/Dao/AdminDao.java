package lk.ijse.Dao;

import lk.ijse.Entity.Admin;

public interface AdminDao extends CrudUtil<Admin> {
    Admin getData(int Id);
}
