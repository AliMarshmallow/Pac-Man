package sample.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import sample.cotroller.Finisher;
import sample.cotroller.Initializer;

import java.io.IOException;



public class FirstMenu extends Application {
    private static AnchorPane anchorPane;
    public static Stage stage1;
    public static MediaPlayer mediaPlayer;
    public static boolean isMute;
    public static int musicId;

    @Override
    public void start(Stage stage) throws Exception {
        stage1 = stage;
        anchorPane = FXMLLoader.load(getClass().getResource("/sample/fxml/firstMenu.fxml"));
        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Pac-Man");
        Media media = new Media(getClass().getResource("/sample/media/track1.mp3").toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        musicId = 1;
        stage.show();
    }

    public static void main(String[] args) {
        Initializer.addUsersAndMaps();
        launch(args);
    }


    public void exitClicked(MouseEvent mouseEvent) {
        Finisher.writeFile();
        System.exit(0);
    }

    public void login(MouseEvent mouseEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(LoginView.class.getResource("/sample/fxml/loginMenu.fxml"));
        LoginView.stage.setScene(new Scene(anchorPane));
        LoginView.stage.setTitle("Pac-Man");
        LoginView.stage.show();
        stage1.close();
    }

    public void register(MouseEvent mouseEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(RegisterView.class.getResource("/sample/fxml/registerMenu.fxml"));
        RegisterView.stage.setTitle("Pac-Man");
        RegisterView.stage.setScene(new Scene(anchorPane));
        RegisterView.stage.show();
        stage1.close();
    }

    public void playAsGuest(MouseEvent mouseEvent) throws IOException {
        stage1.close();
        GameStart gameStart = new GameStart();
        gameStart.run("Guest");
    }

    public void scoreboard(MouseEvent mouseEvent) throws IOException {
        FirstMenu.stage1.close();
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.writeUsers();
    }

    public void changeMedia(MouseEvent mouseEvent) {
        change();
    }

    public static void change(){
        mediaPlayer.stop();
        if (musicId == 3){
            musicId = 1;
            Media media = new Media(FirstMenu.class.getResource("/sample/media/track1.mp3").toExternalForm());
            mediaPlayer = new MediaPlayer(media);
        }
        else if (musicId == 2){
            musicId = 3;
            Media media = new Media(FirstMenu.class.getResource("/sample/media/sweet.mp3").toExternalForm());
            mediaPlayer = new MediaPlayer(media);
        }else if (musicId == 1){
            musicId = 2;
            Media media = new Media(FirstMenu.class.getResource("/sample/media/Aulus.mp3").toExternalForm());
            mediaPlayer = new MediaPlayer(media);
        }else if (musicId == 3){
            musicId = 4;
            Media media = new Media(FirstMenu.class.getResource("/sample/media/delam.mp3").toExternalForm());
            mediaPlayer = new MediaPlayer(media);
        }
        mediaPlayer.play();
    }

    public void mute(MouseEvent mouseEvent) {
        Button button = (Button) anchorPane.getChildren().get(9);
        if (!isMute){
            mediaPlayer.stop();
            isMute = true;
            button.setText("Unmute");
        }
        else {
            mediaPlayer.play();
            isMute = false;
            button.setText("Mute");
        }
    }

    public static boolean isIsMute() {
        return isMute;
    }
}
