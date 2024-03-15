package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Bo.MemberDashboardServer;
import lk.ijse.Bo.ServiceFactor;
import lk.ijse.Dto.MemberDto;
import lk.ijse.util.ChangeForm;
import lk.ijse.util.Validation;

import java.net.URL;
import java.util.ResourceBundle;

public class MainDashboardPageFormController implements Initializable {
    public AnchorPane ChangePane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChangeForm.ChangePane(ChangePane,"DashboardPage.fxml");
    }

    public void DashboardbtnOnActhion(ActionEvent actionEvent) {
        ChangeForm.ChangePane(ChangePane,"DashboardPage.fxml");
    }

    public void SearchBookOnActhion(ActionEvent actionEvent) {
        ChangeForm.ChangePane(ChangePane,"BookView.fxml");
    }

//    public void ReturnBookBtnOnActhion(ActionEvent actionEvent) {
//        ChangeForm.ChangePane(ChangePane,"ReturnBookPage.fxml");
//    }
//
    public void BookBorrowBtnOnActhion(ActionEvent actionEvent) {
        ChangeForm.ChangePane(ChangePane,"BorrowBoookPage.fxml");
    }

    public void ExitBtnOnActhion(ActionEvent actionEvent) {
        System.exit(0);
    }

}
