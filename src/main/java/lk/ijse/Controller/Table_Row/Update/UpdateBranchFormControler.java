package lk.ijse.Controller.Table_Row.Update;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import lk.ijse.Service.BranchService;
import lk.ijse.Service.ServiceFactor;
import lk.ijse.Dto.BranchDto;
import lk.ijse.util.Validation;

public class UpdateBranchFormControler {
    @FXML
    private TextField email;

    @FXML
    private TextField locationtext;

    @FXML
    private TextField name;

    BranchDto branchDto;

    public void setData(BranchDto branchDto){
        name.setText(branchDto.getName());
        locationtext.setText(branchDto.getLocation());
        email.setText(branchDto.getEmail());
        this.branchDto = branchDto;
    }

    BranchService branchService = (BranchService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.Branch);

    @FXML
    void UpdateBtnOnActhion(ActionEvent event) {
        if (Validation.isValidName(name.getText()) && Validation.isValidAddress(locationtext.getText()) && Validation.isValidEmail(email.getText())){
            branchService.update(new BranchDto(branchDto.getId(), name.getText(), locationtext.getText(), email.getText()));
            new Alert(Alert.AlertType.CONFIRMATION, "Updated", ButtonType.OK).show();

        }
        else {
            new Alert(Alert.AlertType.ERROR, "Invalid Input", ButtonType.OK).show();
        }
    }
}
