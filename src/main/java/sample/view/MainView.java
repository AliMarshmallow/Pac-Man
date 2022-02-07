package sample.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.cotroller.Finisher;
import sample.cotroller.MainMenu;

import java.io.IOException;


public class MainView {

    public static Stage stage = new Stage();
    public static AnchorPane anchorPane2;

    public static void setAnchorPane(AnchorPane anchorPane) {
        MainView.anchorPane2 = anchorPane;
    }

    public static AnchorPane getAnchorPane2() {
        return anchorPane2;
    }

    public void exit(MouseEvent mouseEvent) {
        Finisher.writeFile();
        System.exit(0);
    }

    public void logout(MouseEvent mouseEvent) {
        stage.close();
        FirstMenu.stage1.show();
    }

    public void deleteAccount(MouseEvent mouseEvent) {
        TextInputDialog inputText = new TextInputDialog();
        inputText.setHeaderText("If you sure write 'Yes'");
        inputText.showAndWait();
        String inputData = inputText.getEditor().getText();
        System.out.println(inputData);
        if (inputData.equals("Yes")) {
            MainMenu.deleteUser();
            stage.close();
            FirstMenu.stage1.show();
        }
    }

    public void changePassword(MouseEvent mouseEvent) {
        TextInputDialog getPassword = new TextInputDialog();
        getPassword.setHeaderText("Enter your new password");
        getPassword.showAndWait();
        String newPassword = getPassword.getEditor().getText();
        MainMenu.changePassword(newPassword);
    }

    public void play(MouseEvent mouseEvent) throws IOException {
        stage.close();
        GameStart gameStart = new GameStart();
        gameStart.run(MainMenu.getUsernameLogin());
    }

    public void mute(MouseEvent mouseEvent) {
        boolean isMute = FirstMenu.isIsMute();
        Button button = (Button) anchorPane2.getChildren().get(6);
        if (!isMute){
            button.setText("Unmute");
            FirstMenu.mediaPlayer.stop();
            FirstMenu.isMute = true;
        }
        else {
            FirstMenu.mediaPlayer.play();
            FirstMenu.isMute = false;
            button.setText("Mute");
        }
    }

    public void changeMedia(MouseEvent mouseEvent) {
        FirstMenu.change();
    }
}
