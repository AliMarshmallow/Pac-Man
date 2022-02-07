package sample.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.cotroller.ScoreboardMenu;

import java.io.IOException;
import java.util.ArrayList;

public class Scoreboard {

    public static Stage stage = new Stage();


    public void writeUsers() throws IOException {
        ArrayList<String> users = ScoreboardMenu.getUsers();
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/sample/fxml/scoreboard.fxml"));
        Scoreboard.stage.setScene(new Scene(anchorPane));
        stage.setTitle("Pac-Man");
        Scoreboard.stage.show();
        Label[] labels = new Label[10];
        for (int i = 2; i < 12; i++) {
            labels[i-2] = (Label) anchorPane.getChildren().get(i);
        }
        int counter = 0;
        for (String user : users) {
            labels[counter].setText(user);
            counter+=1;
        }
    }

    public void exit(){
        stage.close();
        FirstMenu.stage1.show();
    }

}
