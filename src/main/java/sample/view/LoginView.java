package sample.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.cotroller.LoginMenu;
import sample.cotroller.MainMenu;

import java.io.IOException;

public class LoginView {

    public LoginMenu loginMenu = new LoginMenu();
    public static Stage stage = new Stage();
    @FXML
    public TextField usernameText;
    @FXML
    public PasswordField passwordText;


    public void login(ActionEvent actionEvent) throws IOException {
        String username = usernameText.getText();
        String password = passwordText.getText();
        if (!loginMenu.isUserExist(username)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            String message = "This username not exist";
            alert.setTitle("Error");
            alert.setHeaderText(message);
            alert.show();
            usernameText.setText("");
            passwordText.setText("");
            return;
        }
        if (loginMenu.isPasswordWrong(username, password)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            String message = "Password wrong";
            alert.setTitle("Error");
            alert.setHeaderText(message);
            alert.show();
            passwordText.setText("");
            return;
        }
        usernameText.setText("");
        passwordText.setText("");
        stage.close();
        MainMenu.setUsernameLogin(username);
        MainView.setAnchorPane(FXMLLoader.load(getClass().getResource("/sample/fxml/mainMenu.fxm")));
        MainView.stage.setScene(new Scene(MainView.getAnchorPane2()));
        MainView.stage.setTitle("Pac-Man");
        if (FirstMenu.isMute){
            ((Button)MainView.anchorPane2.getChildren().get(6)).setText("Unmute");
        }
        MainView.stage.show();

    }

    public void exit(MouseEvent mouseEvent) {
        FirstMenu.stage1.show();
        stage.close();
    }

    public void hashem(MouseEvent mouseEvent) {
    }
}
