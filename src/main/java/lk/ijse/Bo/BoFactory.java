package lk.ijse.Bo;

import lk.ijse.Bo.Custom.AdminBoImpl;
import lk.ijse.Bo.Custom.MemberBoImpl;
import lk.ijse.Bo.Custom.RegisterBoImpl;
import lk.ijse.Bo.Custom.SearchBookBoImpl;

public class BoFactory {

    private static BoFactory boFactory;
    private BoFactory(){

    }

    public static BoFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BoFactory() : boFactory;
    }

    public enum BoType{
        Member,Admin,Search_Book,Register,Manage_Book,UserMange,Branch,DashBoard
    }

    public SuperBo getBo(BoType boType){
        switch (boType){
            case Member :
                return new MemberBoImpl();
            case Admin:
                return new AdminBoImpl();
            case Search_Book:
                return new SearchBookBoImpl();
            case Register:
                return new RegisterBoImpl();
//            case Manage_Book:
//                return new ManageBookBoImpl();
//            case UserMange:
//                return new UserManageBImpl();
//            case Branch:
//                return new BranchBoImpl();
//            case DashBoard:
//                return new DashboardBoImpl();
            default:
                return null;
        }
    }
}
