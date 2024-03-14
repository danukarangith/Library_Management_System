package lk.ijse.Controller.Table_Row.Update;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import lk.ijse.Bo.Custom.AdminServiceImpl;
import lk.ijse.Bo.DashboardService;
import lk.ijse.Bo.ServiceFactor;
import lk.ijse.Dto.AdminDto;
import lk.ijse.util.Validation;

public class UpdateUserFormController {
    @FXML
    private TextField email;

    @FXML
    private TextField name;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    AdminDto adminDto = AdminServiceImpl.data;

    DashboardService userMangeBo = (DashboardService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.DashBoard);
    @FXML
    void updateBtnOnActhion(ActionEvent event) {
        if(Validation.isValidName(name.getText()) && Validation.isValidEmail(email.getText())){
            try {
                userMangeBo.Update(new AdminDto(adminDto.getId(),name.getText(),username.getText(),password.getText(),email.getText()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
        }
        else {
            new Alert(Alert.AlertType.ERROR,"Invalid Input").show();
        }
    }

    public void setData() {
        name.setText(adminDto.getName());
        username.setText(adminDto.getUsername());
        password.setText(adminDto.getPassword());
        email.setText(adminDto.getEmail());
    }

    public void DeleteBtnOnActhion(ActionEvent actionEvent) {
        new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this branch?", ButtonType.YES, ButtonType.NO).showAndWait().ifPresent(buttonType -> {
            if (buttonType == ButtonType.YES){
                userMangeBo.Delete(adminDto.getId());
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted", ButtonType.OK).show();
                System.exit(0);
            }
        });
    }
}
