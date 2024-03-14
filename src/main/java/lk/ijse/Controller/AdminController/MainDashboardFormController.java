package lk.ijse.Controller.AdminController;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.Bo.Custom.AdminServiceImpl;
import lk.ijse.Bo.DashboardService;
import lk.ijse.Bo.ServiceFactor;
import lk.ijse.Controller.Table_Row.Update.UpdateUserFormController;
import lk.ijse.Dto.AdminDto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MainDashboardFormController {
//    public Label BookCount;
//    public Label BranchCount;
//    public Label PaymentCount;
//    public Label MemberCount;
    @FXML
    private PasswordField PasswordFild;

    @FXML
    private TextField PasswordTextFild;

    @FXML
    private TextField Username;

    @FXML
    private TextField email;
    @FXML
    private Label clock;
    @FXML
    private Label dateSet;


//    @FXML
//    private Button viewPass;

    Boolean flag = false;

    AdminDto adminDto = AdminServiceImpl.data;

    DashboardService dashboardService = (DashboardService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.DashBoard);

    public void initialize() {
        PasswordTextFild.setVisible(false);
        Username.setText(adminDto.getUsername());
        email.setText(adminDto.getEmail());
        PasswordFild.setText(adminDto.getPassword());
        PasswordTextFild.setText(adminDto.getPassword());
       // setData();

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


//    void setData(){
//        BookCount.setText(String.valueOf(dashboardService.BookCount()));
//        BranchCount.setText(String.valueOf(dashboardService.BranchCount()));
//        MemberCount.setText(String.valueOf(dashboardService.MemberCount()));
//    }

//    @FXML
//    void viewPassOnActhion(ActionEvent event) {
//        String Password = PasswordFild.getText();
//        String TExtPass = PasswordTextFild.getText();
//
//        if (flag == false){
//            PasswordFild.setVisible(false);
//            PasswordTextFild.setVisible(true);
//            PasswordTextFild.setText(Password);
//            flag = true;
//        }
//        else {
//            PasswordFild.setVisible(true);
//            PasswordTextFild.setVisible(false);
//            PasswordFild.setText(TExtPass);
//            flag = false;
//        }
//    }

    public void settingsBtnOnActhion(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Forms/Table_Row/Update/UpdateAdmin.fxml"));
        try {
            fxmlLoader.load();
            UpdateUserFormController controller = fxmlLoader.getController();
            controller.setData();
            Stage stage = new Stage();
            stage.setScene(new Scene(fxmlLoader.getRoot()));
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
