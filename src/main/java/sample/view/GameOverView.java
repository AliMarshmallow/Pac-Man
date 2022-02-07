package sample.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.cotroller.Finisher;
import sample.cotroller.GameController;

import java.io.IOException;

public class GameOverView {


    public static Stage stage = new Stage();

    public static void run(int score) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(GameOverView.class.getResource("/sample/fxml/resetGame.fxml"));
        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Pac-Man");
        stage.show();
        Label label = (Label) anchorPane.getChildren().get(3);
        label.setText("Score: "+ score);
    }


    public void exit(MouseEvent mouseEvent) {
        Finisher.writeFile();
        System.exit(0);
    }

    public void back(MouseEvent mouseEvent) {
        if (GameController.getName().equals("Guest")){
            stage.close();
            FirstMenu.stage1.show();
        }
        else{
            stage.close();
            MainView.stage.show();
        }
    }

    public void restart(MouseEvent mouseEvent) throws IOException {
        stage.close();
        GameStart gameStart = new GameStart();
        gameStart.run(GameController.getName());
    }
}
