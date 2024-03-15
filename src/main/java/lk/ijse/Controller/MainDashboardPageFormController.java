package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import lk.ijse.util.ChangeForm;

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

    public void ReturnBookBtnOnActhion(ActionEvent actionEvent) {
        ChangeForm.ChangePane(ChangePane,"ReturnBookPage.fxml");
    }

    public void BookBorrowBtnOnActhion(ActionEvent actionEvent) {
        ChangeForm.ChangePane(ChangePane,"BorrowBoookPage.fxml");
    }

    public void ExitBtnOnActhion(ActionEvent actionEvent) {
        System.exit(0);
    }

}
