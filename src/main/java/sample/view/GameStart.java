package sample.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.cotroller.GameController;
import sample.cotroller.GameStartController;

import java.io.IOException;

public class GameStart {

    public static Stage stage = new Stage();
    public static Label lifePoint;
    public static GridPane firstMap;
    public static GridPane secondMap;
    public static char[][] mapOne;
    public static char[][] mapTwo;
    public static final double size = 10.0;
    public static AnchorPane anchorPaneStart;
    public static Image wallImage;
    public static Image bigDotImage;
    public static Image smallDotImage;
    public static Image pacmanRightImage;
    public static Image ghost1Image;
    public static Image ghost2Image;
    public static Image ghost3Image;
    public static Image ghost4Image;


    public void setImages() {
        this.ghost1Image = new Image(getClass().getResource("/sample/png/ghost1.gif").toExternalForm());
        this.ghost2Image = new Image(getClass().getResource("/sample/png/ghost2.gif").toExternalForm());
        this.ghost3Image = new Image(getClass().getResource("/sample/png/ghost3.gif").toExternalForm());
        this.ghost4Image = new Image(getClass().getResource("/sample/png/ghost4.gif").toExternalForm());
        this.pacmanRightImage = new Image(getClass().getResource("/sample/png/pacmanRight.gif").toExternalForm());
        this.wallImage = new Image(getClass().getResource("/sample/png/wall.png").toExternalForm());
        this.bigDotImage = new Image(getClass().getResource("/sample/png/bigdot.png").toExternalForm());
        this.smallDotImage = new Image(getClass().getResource("/sample/png/smalldot.png").toExternalForm());
    }

    public void run(String username) throws IOException {
        anchorPaneStart = FXMLLoader.load(getClass().getResource("/sample/fxml/preGame.fxml"));
        lifePoint = (Label) anchorPaneStart.getChildren().get(0);
        firstMap = (GridPane) anchorPaneStart.getChildren().get(4);
        secondMap = (GridPane) anchorPaneStart.getChildren().get(5);
        stage.setScene(new Scene(anchorPaneStart));
        stage.setTitle("Pac-Man");
        boolean isMute = FirstMenu.isIsMute();
        Button button = (Button) anchorPaneStart.getChildren().get(10);
        if (isMute){
            button.setText("Unmute");
        }
        stage.show();
        GameStartController.setUsername(username);
        GameController.setScorePoint(0);
        setImages();
        showMaps(GameStartController.getMap(2), GameStartController.getMap(3));
        GameStartController.setId1(2);
        GameStartController.setId2(3);
    }


    public void increaseLive(MouseEvent mouseEvent) {
        if (lifePoint.getText().charAt(13) == '5') {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Your life point is already maximum");
            alert.show();
        } else {
            char number = lifePoint.getText().charAt(13);
            if (number == '2')
                lifePoint.setText("Life point : 3");
            else if (number == '3')
                lifePoint.setText("Life point : 4");
            else if (number == '4')
                lifePoint.setText("Life point : 5");
        }
    }

    public void decreaseLive(MouseEvent mouseEvent) {
        if (lifePoint.getText().charAt(13) == '2') {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Your life point is already minimum");
            alert.show();
        } else {
            char number = lifePoint.getText().charAt(13);
            if (number == '4')
                lifePoint.setText("Life point : 3");
            else if (number == '5')
                lifePoint.setText("Life point : 4");
            else if (number == '3')
                lifePoint.setText("Life point : 2");
        }
    }

    public static void showMaps(char[][] map1, char[][] map2) {
        mapOne = map1;
        ImageView[][] mapImage = new ImageView[21][17];
        showMap(mapOne, mapImage, wallImage, bigDotImage, smallDotImage, size, firstMap, pacmanRightImage);
        mapTwo = map2;
        showMap(mapTwo, mapImage, wallImage, bigDotImage, smallDotImage, size, secondMap, pacmanRightImage);
    }

    public static void showMap(char[][] data, ImageView[][] mapImage, Image wallImage, Image bigDotImage, Image smallDotImage, double size, GridPane firstMap, Image pacman) {
        firstMap.getChildren().clear();
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 17; j++) {
                if (data[i][j] == 'W') {
                    mapImage[i][j] = new ImageView(wallImage);

                } else if (data[i][j] == 'B') {
                    mapImage[i][j] = new ImageView(bigDotImage);
                } else if (data[i][j] == '1') {
                    mapImage[i][j] = new ImageView(ghost1Image);
                } else if (data[i][j] == '2') {
                    mapImage[i][j] = new ImageView(ghost2Image);
                } else if (data[i][j] == '3') {
                    mapImage[i][j] = new ImageView(ghost3Image);
                } else if (data[i][j] == '4') {
                    mapImage[i][j] = new ImageView(ghost4Image);
                } else if (data[i][j] != 'P') {
                    mapImage[i][j] = new ImageView(smallDotImage);
                } else {
                    mapImage[i][j] = new ImageView(pacman);
                }
                mapImage[i][j].setFitWidth(size);
                mapImage[i][j].setFitHeight(size);
            }
        }
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 17; j++) {
                firstMap.add(mapImage[i][j], i, j, 1, 1);
            }
        }
    }

    public void playMapOne(MouseEvent mouseEvent) throws IOException {
        Game game = new Game();
        GameController.setMap(mapOne);
        stage.close();
        game.run(GameStartController.getUsername(), Integer.parseInt(String.valueOf(lifePoint.getText().charAt(13))),0);

    }

    public void playMapTwo(MouseEvent mouseEvent) throws IOException {
        Game game = new Game();
        GameController.setMap(mapTwo);
        stage.close();
        game.run(GameStartController.getUsername(), Integer.parseInt(String.valueOf(lifePoint.getText().charAt(13))),0);
    }

    public void randomMap(MouseEvent mouseEvent) {
        showMaps(GameStartController.getNewMap(), GameStartController.getNewMap());
    }

    public void nextMap(MouseEvent mouseEvent) {
        showMaps(GameStartController.getNextMap(1),GameStartController.getNextMap(2));
    }

    public void mute(MouseEvent mouseEvent) {
        boolean isMute = FirstMenu.isIsMute();
        Button button = (Button) anchorPaneStart.getChildren().get(10);
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

    public void changeSong(MouseEvent mouseEvent) {
        FirstMenu.change();
    }
}
