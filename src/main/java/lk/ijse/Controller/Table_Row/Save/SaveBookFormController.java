package lk.ijse.Controller.Table_Row.Save;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.Service.ManagebookService;
import lk.ijse.Service.ServiceFactor;
import lk.ijse.Controller.AdminController.ManageBookFormController;
import lk.ijse.Dto.BookDto;
import lk.ijse.util.Validation;

public class SaveBookFormController {
    @FXML
    private TextField Genre;

    @FXML
    private TextField autor;

    @FXML
    private TextField dis;

    @FXML
    private TextField title;

    @FXML
    void saveBtnOnActhion(ActionEvent event) {
        if (Validation.isValidAddress(this.Genre.getText()) && Validation.isValidName(autor.getText()) && Validation.validateBookTitle(title.getText())){
            ManagebookService manageBookService = (ManagebookService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.Manage_Book);
            int yes = manageBookService.Save(new BookDto(0, title.getText(), autor.getText(), dis.getText(), Genre.getText(), "Yes"));
            if (yes > 0){
                title.setText("");
                autor.setText("");
                dis.setText("");
                Genre.setText("");
                new Alert(Alert.AlertType.INFORMATION, "Saved").show();
                ManageBookFormController manageBookFormController = new ManageBookFormController();
                manageBookFormController.initialize(null,null);
            }
        }
        else {
            new Alert(Alert.AlertType.ERROR, "Invalid Input").show();
        }
    }
}
