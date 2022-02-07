package sample.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.cotroller.RegisterMenu;


public class RegisterView {
    public RegisterMenu registerMenu = new RegisterMenu();
    public static Stage stage = new Stage();
    @FXML
    public TextField usernameText;
    @FXML
    public PasswordField passwordText;


    public void register(ActionEvent actionEvent) throws InterruptedException {
        String username = usernameText.getText();
        String password = passwordText.getText();
        if (registerMenu.isUserExist(username)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            String message = "This username is already taken";
            alert.setTitle("Error");
            alert.setHeaderText(message);
            alert.show();
            usernameText.setText("");
            passwordText.setText("");
            return;
        }
        registerMenu.registerNewUser(username,password);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String message = "You register successfully";
        alert.setTitle("Successful");
        alert.setHeaderText(message);
        alert.show();
        usernameText.setText("");
        passwordText.setText("");
    }


    public void exit(MouseEvent mouseEvent) {
        FirstMenu.stage1.show();
        stage.close();
    }

}
