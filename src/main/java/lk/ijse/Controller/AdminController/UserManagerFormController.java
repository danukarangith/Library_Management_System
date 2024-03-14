package lk.ijse.Controller.AdminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import lk.ijse.Bo.ServiceFactor;
import lk.ijse.Bo.UserManageService;
import lk.ijse.Controller.Table_Row.UserRowController;

import java.io.IOException;

public class UserManagerFormController {
    public VBox TableBox;

    UserManageService userMangeBo = (UserManageService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.UserMange);
    public void initialize() {
        TableBox.getChildren().clear();
        userMangeBo.getAll().forEach(MemberDto -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Forms/Table_Row/UserRow.fxml"));
                Parent root = fxmlLoader.load();
                UserRowController controller = fxmlLoader.getController();
                controller.setData(MemberDto);
                TableBox.getChildren().add(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void AddUserOnActhion(ActionEvent actionEvent) {

    }

    public void UpdateuserOnActhion(ActionEvent actionEvent) {

    }
}
