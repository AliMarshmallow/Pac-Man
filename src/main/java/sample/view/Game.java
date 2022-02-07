package sample.view;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.cotroller.Finisher;
import sample.cotroller.GameController;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Game {

    public final static double size = 27;
    public static Scene scene;
    public static Stage stage = new Stage();
    public ImageView[][] mapImage = new ImageView[21][17];
    public GridPane map;
    public Label score;
    public Label name;
    public Label lives;
    public static Image pacmanRightImage;
    public static Image pacmanUpImage;
    public static Image pacmanDownImage;
    public static Image pacmanLeftImage;
    public static Image ghost1Image;
    public static Image ghost2Image;
    public static Image ghost3Image;
    public static Image ghost4Image;
    public static Image blueGhostImage;
    public static Image wallImage;
    public static Image bigDotImage;
    public static Image smallDotImage;
    public static Image blackWall;
    public static int movePacman;
    public static int checker = -11;
    public static int numberOfGhostEat;
    public static int timer2 = 0;
    public static Image ghost1On;
    public static Image ghost2On;
    public static Image ghost3On;
    public static Image ghost4On;
    public static boolean isGameOn;
    public static int timerForGhost1 = 0;
    public static int timerForGhost2 = 0;
    public static int timerForGhost3 = 0;
    public static int timerForGhost4 = 0;
    public static boolean isBigDot = false;
    private static Timer timer = new java.util.Timer();


    public void setImages() {
        this.blackWall = new Image(getClass().getResource("/sample/png/blackWall.png").toExternalForm());
        this.pacmanRightImage = new Image(getClass().getResource("/sample/png/pacmanRight.gif").toExternalForm());
        this.pacmanUpImage = new Image(getClass().getResource("/sample/png/pacmanUp.gif").toExternalForm());
        this.pacmanDownImage = new Image(getClass().getResource("/sample/png/pacmanDown.gif").toExternalForm());
        this.pacmanLeftImage = new Image(getClass().getResource("/sample/png/pacmanLeft.gif").toExternalForm());
        this.ghost1Image = new Image(getClass().getResource("/sample/png/ghost1.gif").toExternalForm());
        this.ghost2Image = new Image(getClass().getResource("/sample/png/ghost2.gif").toExternalForm());
        this.ghost3Image = new Image(getClass().getResource("/sample/png/ghost3.gif").toExternalForm());
        this.ghost4Image = new Image(getClass().getResource("/sample/png/ghost4.gif").toExternalForm());
        this.blueGhostImage = new Image(getClass().getResource("/sample/png/blueghost.gif").toExternalForm());
        this.wallImage = new Image(getClass().getResource("/sample/png/wall.png").toExternalForm());
        this.bigDotImage = new Image(getClass().getResource("/sample/png/bigdot.png").toExternalForm());
        this.smallDotImage = new Image(getClass().getResource("/sample/png/smalldot.png").toExternalForm());
        ghost1On = smallDotImage;
        ghost2On = smallDotImage;
        ghost3On = smallDotImage;
        ghost4On = smallDotImage;
    }

    private void startTimer() {
        if (isGameOn) {
            timer = new java.util.Timer();
        }
        TimerTask timerTask = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        if (timerForGhost1 < 0) {
                            timerForGhost1 += 1;
                            if (timerForGhost1 == 0) {
                                GameController.resetGhost(1);
                            }
                        }
                        if (timerForGhost2 < 0) {
                            timerForGhost2 += 1;
                            if (timerForGhost2 == 0) {
                                GameController.resetGhost(2);
                            }
                        }
                        if (timerForGhost3 < 0) {
                            timerForGhost3 += 1;
                            if (timerForGhost3 == 0) {
                                GameController.resetGhost(3);
                            }
                        }
                        if (timerForGhost4 < 0) {
                            timerForGhost4 += 1;
                            if (timerForGhost4 == 0) {
                                GameController.resetGhost(4);
                            }
                        }
                        checker += 1;
                        if (checker != 3) {
                            if (isBigDot) {
                                changeGhostToBlue();
                            } else {
                                changeGhostToNormal();
                            }
                        }
                        if (checker == 3) {
                            checker = 0;
                            GameController.moveGhosts(size);
                        }
                        if (isBigDot && timer2 == 50) {
                            isBigDot = false;
                            timer2 = 0;
                        }
                        if(isBigDot){
                            timer2+=1;
                        }
                        if (checker >= 0)
                            isEatGhostOrPacman();
                        scene.setOnKeyPressed(e -> {
                            if (e.getCode() == KeyCode.W) {
                                setPacman(3);
                                movePacman = 3;
                            } else if (e.getCode() == KeyCode.S) {
                                setPacman(1);
                                movePacman = 1;
                            } else if (e.getCode() == KeyCode.D) {
                                setPacman(0);
                                movePacman = 0;
                            } else if (e.getCode() == KeyCode.A) {
                                setPacman(2);
                                movePacman = 2;
                            } else if (e.getCode() == KeyCode.M) {
                                movePacman = 4;
                                if (!FirstMenu.isIsMute()) {
                                    FirstMenu.mediaPlayer.stop();
                                    FirstMenu.isMute = true;
                                } else {
                                    FirstMenu.mediaPlayer.play();
                                    FirstMenu.isMute = false;
                                }
                            } else if (e.getCode() == KeyCode.C) {
                                movePacman = 4;
                                FirstMenu.change();
                            } else if (e.getCode() == KeyCode.ESCAPE) {
                                movePacman = 4;
                                int holder = checker;
                                checker = -10000000;
                                TextInputDialog textInputDialog = new TextInputDialog();
                                textInputDialog.setHeaderText("Pause");
                                textInputDialog.setContentText("if you want play inset 'play' else you want exit");
                                textInputDialog.showAndWait();
                                String input = textInputDialog.getEditor().getText();
                                if (!input.equals("play")) {
                                    stage.close();
                                    FirstMenu.stage1.show();
                                } else {
                                    checker = holder;
                                }
                            } else {
                                movePacman = 4;
                            }
                            pacmanMove();
                            if (checker >= 0)
                                isEatGhostOrPacman();
                        });
                        isEnd();
                    }
                });
            }
        };
        long frameTimeInMilliseconds = (long) (1000.0 / 5.0);
        this.timer.schedule(timerTask, 0, frameTimeInMilliseconds);
    }

    private void isEnd() {
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 17; j++) {
                if (((ImageView) getNodeByCoordinate(i, j)).getImage().equals(smallDotImage)
                        || ((ImageView) getNodeByCoordinate(i, j)).getImage().equals(bigDotImage)) {
                    return;
                }
            }
        }
        GameController.setLives(GameController.getLives() + 1);
        timer.cancel();
        timer2 = 0;
        timerForGhost1 = 0;
        timerForGhost2 = 0;
        timerForGhost3 = 0;
        timerForGhost4 = 0;
        isBigDot = false;
        for (int i = 4; i < 5; i++) {
            GameController.resetGhost(i);
        }
        try {
            run(GameController.getName(), GameController.getLives() + 1, GameController.getScorePoint());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void isEatGhostOrPacman() {
        if (GameController.isCrossed()) {
            if (isBigDot) {
                GameController.changeScore(200 * (numberOfGhostEat + 1));
                numberOfGhostEat += 1;
            } else {
                if (GameController.getLives() == 1) {
                    GameController.setScore();
                    //map.getChildren().clear();
                    stage.close();
                    isGameOn = false;
                    timer.cancel();
                    try {
                        GameOverView.run(GameController.getScorePoint());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    checker = -11;
                    timer2 = 0;
                    isBigDot = false;
                    lives.setText("Life Point: " + (GameController.getLives() - 1));
                    GameController.setLives(GameController.getLives() - 1);
                    GameController.resetImages();
                    GameController.resetPacman();
                }
            }
        }
    }


    private void changeGhostToNormal() {
        changeImageOfGhost(ghost1Image, ghost2Image, ghost3Image, ghost4Image);
    }

    private void changeGhostToBlue() {
        changeImageOfGhost(blueGhostImage, blueGhostImage, blueGhostImage, blueGhostImage);
    }

    private void changeImageOfGhost(Image ghost1Image, Image ghost2Image, Image ghost3Image, Image ghost4Image) {
        ImageView ghost = new ImageView(ghost1Image);
        ghost.setFitWidth(size);
        ghost.setFitHeight(size);
        if (timerForGhost1 == 0) {
            map.getChildren().remove(getNodeByCoordinate(GameController.getGhost1X(), GameController.getGhost1Y()));
            map.add(ghost, GameController.getGhost1X(), GameController.getGhost1Y(), 1, 1);
        }
        ghost = new ImageView(ghost2Image);
        ghost.setFitWidth(size);
        ghost.setFitHeight(size);
        if (timerForGhost2 == 0) {
            map.getChildren().remove(getNodeByCoordinate(GameController.getGhost2X(), GameController.getGhost2Y()));
            map.add(ghost, GameController.getGhost2X(), GameController.getGhost2Y(), 1, 1);
        }
        ghost = new ImageView(ghost3Image);
        ghost.setFitWidth(size);
        ghost.setFitHeight(size);
        if (timerForGhost3 == 0) {
            map.getChildren().remove(getNodeByCoordinate(GameController.getGhost3X(), GameController.getGhost3Y()));
            map.add(ghost, GameController.getGhost3X(), GameController.getGhost3Y(), 1, 1);
        }
        ghost = new ImageView(ghost4Image);
        ghost.setFitWidth(size);
        ghost.setFitHeight(size);
        if (timerForGhost4 == 0) {
            map.getChildren().remove(getNodeByCoordinate(GameController.getGhost4X(), GameController.getGhost4Y()));
            map.add(ghost, GameController.getGhost4X(), GameController.getGhost4Y(), 1, 1);
        }
    }


    public Node getNodeByCoordinate(int column, int row) {
        for (Node node : map.getChildren()) {
            if (GridPane.getColumnIndex(node) == column && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }


    public void pacmanMove() {
        int x = GameController.getPacmanX();
        int y = GameController.getPacmanY();
        ImageView blackWall = new ImageView(Game.blackWall);
        blackWall.setFitHeight(size);
        blackWall.setFitWidth(size);
        if (movePacman == 0) {
            ImageView imageView = (ImageView) getNodeByCoordinate(x + 1, y);
            if (imageView.getImage().equals(smallDotImage)) {
                changeImageAndScoreRight(x, y, blackWall);
            } else if (imageView.getImage().equals(bigDotImage)) {
                if (!isBigDot){
                    numberOfGhostEat = 0;
                }
                isBigDot = true;
                timer2 = 0;
                changeImageAndScoreRight(x, y, blackWall);
            } else if (!imageView.getImage().equals(Game.wallImage)) {
                changeImageAndScoreRight(x, y, blackWall);
                GameController.changeScore(-5);
                score.setText(String.valueOf(GameController.getScorePoint()));
            }
        }
        if (movePacman == 1) {
            ImageView imageView = (ImageView) getNodeByCoordinate(x, y + 1);
            if (imageView.getImage().equals(smallDotImage)) {
                changeImageAndScoreDown(x, y, blackWall);
            } else if (imageView.getImage().equals(bigDotImage)) {
                if (!isBigDot){
                    numberOfGhostEat = 0;
                }
                isBigDot = true;
                timer2 = 0;
                changeImageAndScoreDown(x, y, blackWall);
            } else if (!imageView.getImage().equals(Game.wallImage)) {
                changeImageAndScoreDown(x, y, blackWall);
                GameController.changeScore(-5);
                score.setText(String.valueOf(GameController.getScorePoint()));
            }
        }
        if (movePacman == 2) {
            ImageView imageView = (ImageView) getNodeByCoordinate(x - 1, y);
            if (imageView.getImage().equals(smallDotImage)) {
                changeImageAndScoreLeft(x, y, blackWall);
            } else if (imageView.getImage().equals(bigDotImage)) {
                if (!isBigDot){
                    numberOfGhostEat = 0;
                }
                isBigDot = true;
                timer2 = 0;
                changeImageAndScoreLeft(x, y, blackWall);
            } else if (!imageView.getImage().equals(Game.wallImage)) {
                changeImageAndScoreLeft(x, y, blackWall);
                GameController.changeScore(-5);
                score.setText(String.valueOf(GameController.getScorePoint()));
            }
        }
        if (movePacman == 3) {
            ImageView imageView = (ImageView) getNodeByCoordinate(x, y - 1);
            if (imageView.getImage().equals(smallDotImage)) {
                changeImageAndScoreUp(x, y, blackWall);
            } else if (imageView.getImage().equals(bigDotImage)) {
                if (!isBigDot){
                    numberOfGhostEat = 0;
                }
                isBigDot = true;
                timer2 = 0;
                changeImageAndScoreUp(x, y, blackWall);
            } else if (!imageView.getImage().equals(Game.wallImage)) {
                changeImageAndScoreUp(x, y, blackWall);
                GameController.changeScore(-5);
                score.setText(String.valueOf(GameController.getScorePoint()));
            }
        }
    }

    private void changeImageAndScoreUp(int x, int y, ImageView blackWall) {
        GameController.changeScore(5);
        score.setText(String.valueOf(GameController.getScorePoint()));
        ImageView pacman = new ImageView(pacmanUpImage);
        pacman.setFitWidth(size);
        pacman.setFitHeight(size);
        map.getChildren().remove(getNodeByCoordinate(x, y));
        map.getChildren().remove(getNodeByCoordinate(x, y - 1));
        map.add(blackWall, x, y, 1, 1);
        map.add(pacman, x, y - 1, 1, 1);
        GameController.setPacmanY(y - 1);
    }

    private void changeImageAndScoreLeft(int x, int y, ImageView blackWall) {
        GameController.changeScore(5);
        score.setText(String.valueOf(GameController.getScorePoint()));
        ImageView pacman = new ImageView(pacmanLeftImage);
        pacman.setFitWidth(size);
        pacman.setFitHeight(size);
        map.getChildren().remove(getNodeByCoordinate(x, y));
        map.getChildren().remove(getNodeByCoordinate(x - 1, y));
        map.add(blackWall, x, y, 1, 1);
        map.add(pacman, x - 1, y, 1, 1);
        GameController.setPacmanX(x - 1);
    }

    private void changeImageAndScoreDown(int x, int y, ImageView blackWall) {
        GameController.changeScore(5);
        score.setText(String.valueOf(GameController.getScorePoint()));
        ImageView pacman = new ImageView(pacmanDownImage);
        pacman.setFitWidth(size);
        pacman.setFitHeight(size);
        map.getChildren().remove(getNodeByCoordinate(x, y));
        map.getChildren().remove(getNodeByCoordinate(x, y + 1));
        map.add(blackWall, x, y, 1, 1);
        map.add(pacman, x, y + 1, 1, 1);
        GameController.setPacmanY(y + 1);
    }

    private void changeImageAndScoreRight(int x, int y, ImageView blackWall) {
        GameController.changeScore(5);
        score.setText(String.valueOf(GameController.getScorePoint()));
        ImageView pacman = new ImageView(pacmanRightImage);
        pacman.setFitWidth(size);
        pacman.setFitHeight(size);
        map.getChildren().remove(getNodeByCoordinate(x, y));
        map.getChildren().remove(getNodeByCoordinate(x + 1, y));
        map.add(blackWall, x, y, 1, 1);
        map.add(pacman, x + 1, y, 1, 1);
        GameController.setPacmanX(x + 1);
    }

    public void run(String username, int live, int scorePoint) throws IOException {
        BorderPane borderPane = FXMLLoader.load(getClass().getResource("/sample/fxml/game.fxml"));
        isGameOn = true;
        scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setTitle("Pac-Man");
        stage.show();
        map = (GridPane) borderPane.getCenter();
        map.getChildren().clear();
        map.setAlignment(Pos.CENTER);
        setImages();
        AnchorPane anchorPane = (AnchorPane) borderPane.getTop();
        defineLabel(anchorPane, username, live, scorePoint);
        setImageView();
        GameController.setMap(map);
        GameController.resetPacman();
        checker = -11;
        timer2 = 0;
        startTimer();
    }

    public void defineLabel(AnchorPane anchorPane, String username, int live, int scorePoint) {
        score = (Label) anchorPane.getChildren().get(1);
        name = (Label) anchorPane.getChildren().get(0);
        lives = (Label) anchorPane.getChildren().get(2);
        GameController.setLives(live);
        GameController.setName(username);
        GameController.setScorePoint(scorePoint);
        score.setText("Score: " + scorePoint);
        name.setText(username);
        lives.setText("Life Point: " + live);
    }

    public void setImageView() {
        char[][] data = GameController.getMap2();
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 17; j++) {
                if (data[i][j] == 'P') {
                    GameController.setPacmanX(i);
                    GameController.setPacmanY(j);
                    break;
                }
            }
        }
        GameStart.showMap(data, mapImage, wallImage, bigDotImage, smallDotImage, size, map, pacmanRightImage);
    }

    public void setPacman(int flag) {
        if (flag == 0) {
            clear(pacmanRightImage);
        }
        if (flag == 1) {
            clear(pacmanDownImage);
        }
        if (flag == 2) {
            clear(pacmanLeftImage);
        }
        if (flag == 3) {
            clear(pacmanUpImage);
        }
    }

    private void clear(Image pacmanUpImage) {
        ImageView imageView;
        Node node = getNodeByCoordinate(GameController.getPacmanX(), GameController.getPacmanY());
        map.getChildren().remove(node);
        imageView = new ImageView(pacmanUpImage);
        imageView.setFitHeight(size);
        imageView.setFitWidth(size);
        map.add(imageView, GameController.getPacmanX(), GameController.getPacmanY(), 1, 1);
    }

    public void exit(MouseEvent mouseEvent) {
        Finisher.writeFile();
        System.exit(0);
    }

    public void back(MouseEvent mouseEvent) {
        isGameOn = false;
        timer.cancel();
        stage.close();
        FirstMenu.stage1.show();
    }

}
