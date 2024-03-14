package lk.ijse.Controller.AdminController;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.Bo.Custom.AdminServiceImpl;
import lk.ijse.Bo.DashboardService;
import lk.ijse.Bo.ServiceFactor;
import lk.ijse.Controller.Table_Row.Update.UpdateUserFormController;
import lk.ijse.Dto.AdminDto;
import lk.ijse.util.ChangeForm;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MainDashboardFormController implements Initializable {

    @FXML
    private Label clock;
    @FXML
    private Label dateSet;




    public AnchorPane ChangePane;
    public void ManageBookOnActhion(ActionEvent actionEvent) {
        ChangeForm.ChangePane(ChangePane,"Admin/ManageBook.fxml");
    }
    public void DashboardbtnOnActhion(ActionEvent actionEvent) {
        ChangeForm.ChangePane(ChangePane,"Admin/DashboardForm.fxml");
    }



  public void ManageBranchOnActhion(ActionEvent actionEvent) {
      ChangeForm.ChangePane(ChangePane,"Admin/BranchForm.fxml");
  }
//
//    public void ReturnBookBtnOnActhion(ActionEvent actionEvent) {
//        ChangeForm.ChangePane(ChangePane,"Admin/ReturnBookFrom.fxml");
//    }
//
//    public void ExitBtnOnActhion(ActionEvent actionEvent) {
//        System.exit(0);
//    }
//
//    public void UserbtnOnActhion(ActionEvent actionEvent) {
//        ChangeForm.ChangePane(ChangePane,"Admin/UserManageFrom.fxml");
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChangeForm.ChangePane(ChangePane,"Admin/DashboardForm.fxml");
    }

    public void initialize() {


        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0), event -> {
                    LocalTime time = LocalTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss a");
                    String formattedTime = time.format(formatter);
                    clock.setText(formattedTime);
                }),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();


        timeline = new Timeline(
                new KeyFrame(Duration.seconds(0), event -> {
                    LocalDate date = LocalDate.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
                    String formattedDate = date.format(formatter);
                    dateSet.setText(formattedDate);
                }),
                new KeyFrame(Duration.minutes(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();



    }





}
