package sample.cotroller;


import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import sample.model.User;
import sample.view.Game;

import java.util.Random;

import static sample.view.Game.*;

public class GameController {

    public static String name;
    public static int lives;
    public static int scorePoint;
    public static char[][] map2;
    public static GridPane map;
    public static int pacmanX;
    public static int pacmanY;
    public static int ghost1X = 1;
    public static int ghost1Y = 1;
    public static int ghost2X = 1;
    public static int ghost2Y = 15;
    public static int ghost3X = 19;
    public static int ghost3Y = 1;
    public static int ghost4X = 19;
    public static int ghost4Y = 15;


    public static void setMap(GridPane map) {
        GameController.map = map;
    }

    public static int getGhost1X() {
        return ghost1X;
    }

    public static void setGhost1X(int ghost1X) {
        GameController.ghost1X = ghost1X;
    }

    public static int getGhost1Y() {
        return ghost1Y;
    }

    public static void setGhost1Y(int ghost1Y) {
        GameController.ghost1Y = ghost1Y;
    }

    public static int getGhost2X() {
        return ghost2X;
    }

    public static void setGhost2X(int ghost2X) {
        GameController.ghost2X = ghost2X;
    }

    public static int getGhost2Y() {
        return ghost2Y;
    }

    public static void setGhost2Y(int ghost2Y) {
        GameController.ghost2Y = ghost2Y;
    }

    public static int getGhost3X() {
        return ghost3X;
    }

    public static void setGhost3X(int ghost3X) {
        GameController.ghost3X = ghost3X;
    }

    public static int getGhost3Y() {
        return ghost3Y;
    }

    public static void setGhost3Y(int ghost3Y) {
        GameController.ghost3Y = ghost3Y;
    }

    public static int getGhost4X() {
        return ghost4X;
    }

    public static void setGhost4X(int ghost4X) {
        GameController.ghost4X = ghost4X;
    }

    public static int getGhost4Y() {
        return ghost4Y;
    }

    public static void setGhost4Y(int ghost4Y) {
        GameController.ghost4Y = ghost4Y;
    }

    public static void setPacmanX(int pacmanX) {
        GameController.pacmanX = pacmanX;
    }

    public static void setPacmanY(int pacmanY) {
        GameController.pacmanY = pacmanY;
    }

    public static int getPacmanX() {
        return pacmanX;
    }

    public static int getPacmanY() {
        return pacmanY;
    }

    public static void setMap(char[][] map) {
        GameController.map2 = map;
    }

    public static char[][] getMap2() {
        return map2;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        GameController.name = name;
    }

    public static int getLives() {
        return lives;
    }

    public static void setLives(int lives) {
        GameController.lives = lives;
    }

    public static int getScorePoint() {
        return scorePoint;
    }

    public static void changeScore(int score) {
        GameController.scorePoint += score;
    }

    public static void setScorePoint(int scorePoint) {
        GameController.scorePoint = scorePoint;
    }

    public static boolean isCrossed() {
        if (pacmanX == ghost1X && pacmanY == ghost1Y) {
            if (isBigDot) {
                timerForGhost1 = -22;
                ghost1X = -100;
                ghost1Y = -100;
                ghost1On = smallDotImage;
            }
            return true;
        } else if (pacmanX == ghost2X && pacmanY == ghost2Y) {
            if (isBigDot) {
                timerForGhost2 = -22;
                ghost2X = -100;
                ghost2Y = -100;
                ghost2On = smallDotImage;
            }
            return true;
        } else if (pacmanX == ghost3X && pacmanY == ghost3Y) {
            if (isBigDot) {
                timerForGhost3 = -22;
                ghost3X = -100;
                ghost3Y = -100;
                ghost3On = smallDotImage;
            }
            return true;
        } else if (pacmanX == ghost4X && pacmanY == ghost4Y) {
            if (isBigDot) {
                timerForGhost4 = -22;
                ghost4X = -100;
                ghost4Y = -100;
                ghost4On = smallDotImage;
            }
            return true;
        }
        return false;
    }

    public static void moveGhosts(double size) {
        while (timerForGhost1 == 0) {
            int x = GameController.getGhost1X();
            int y = GameController.getGhost1Y();
            int randomNumber = GameController.getRandomNumber(4);
            if (randomNumber == 1 && isCanMove(x + 1, y)) {
                map.getChildren().remove(getNodeByCoordinate(x, y));
                ImageView imageView = new ImageView(ghost1On);
                imageView.setFitHeight(size);
                imageView.setFitWidth(size);
                map.add(imageView, x, y, 1, 1);
                ghost1On = ((ImageView) getNodeByCoordinate(x + 1, y)).getImage();
                map.getChildren().remove(getNodeByCoordinate(x + 1, y));
                ImageView ghost;
                if (isBigDot) {
                    ghost = new ImageView(blueGhostImage);
                } else {
                    ghost = new ImageView(ghost1Image);
                }
                ghost.setFitWidth(size);
                ghost.setFitHeight(size);
                map.add(ghost, x + 1, y, 1, 1);
                GameController.setGhost1X(x + 1);
                break;
            }
            if (randomNumber == 2 && isCanMove(x - 1, y)) {
                map.getChildren().remove(getNodeByCoordinate(x, y));
                ImageView imageView = new ImageView(ghost1On);
                imageView.setFitHeight(size);
                imageView.setFitWidth(size);
                map.add(imageView, x, y, 1, 1);
                ghost1On = ((ImageView) getNodeByCoordinate(x - 1, y)).getImage();
                map.getChildren().remove(getNodeByCoordinate(x - 1, y));
                ImageView ghost;
                if (isBigDot) {
                    ghost = new ImageView(blueGhostImage);
                } else {
                    ghost = new ImageView(ghost1Image);
                }
                ghost.setFitWidth(size);
                ghost.setFitHeight(size);
                map.add(ghost, x - 1, y, 1, 1);
                GameController.setGhost1X(x - 1);
                break;
            }
            if (randomNumber == 3 && isCanMove(x, y + 1)) {
                map.getChildren().remove(getNodeByCoordinate(x, y));
                ImageView imageView = new ImageView(ghost1On);
                imageView.setFitHeight(size);
                imageView.setFitWidth(size);
                map.add(imageView, x, y, 1, 1);
                ghost1On = ((ImageView) getNodeByCoordinate(x, y + 1)).getImage();
                map.getChildren().remove(getNodeByCoordinate(x, y + 1));
                ImageView ghost;
                if (isBigDot) {
                    ghost = new ImageView(blueGhostImage);
                } else {
                    ghost = new ImageView(ghost1Image);
                }
                ghost.setFitWidth(size);
                ghost.setFitHeight(size);
                map.add(ghost, x, y + 1, 1, 1);
                GameController.setGhost1Y(y + 1);
                break;
            }
            if (randomNumber == 4 && isCanMove(x, y - 1)) {
                map.getChildren().remove(getNodeByCoordinate(x, y));
                ImageView imageView = new ImageView(ghost1On);
                imageView.setFitHeight(size);
                imageView.setFitWidth(size);
                map.add(imageView, x, y, 1, 1);
                ghost1On = ((ImageView) getNodeByCoordinate(x, y - 1)).getImage();
                map.getChildren().remove(getNodeByCoordinate(x, y - 1));
                ImageView ghost;
                if (isBigDot) {
                    ghost = new ImageView(blueGhostImage);
                } else {
                    ghost = new ImageView(ghost1Image);
                }
                ghost.setFitWidth(size);
                ghost.setFitHeight(size);
                map.add(ghost, x, y - 1, 1, 1);
                GameController.setGhost1Y(y - 1);
                break;
            }
        }
        while (timerForGhost2 == 0) {
            int x = GameController.getGhost2X();
            int y = GameController.getGhost2Y();
            int randomNumber = GameController.getRandomNumber(4);
            if (randomNumber == 1 && isCanMove(x + 1, y)) {
                map.getChildren().remove(getNodeByCoordinate(x, y));
                ImageView imageView = new ImageView(ghost2On);
                imageView.setFitHeight(size);
                imageView.setFitWidth(size);
                map.add(imageView, x, y, 1, 1);
                ghost2On = ((ImageView) getNodeByCoordinate(x + 1, y)).getImage();
                map.getChildren().remove(getNodeByCoordinate(x + 1, y));
                ImageView ghost;
                if (isBigDot) {
                    ghost = new ImageView(blueGhostImage);
                } else {
                    ghost = new ImageView(ghost2Image);
                }
                ghost.setFitWidth(size);
                ghost.setFitHeight(size);
                map.add(ghost, x + 1, y, 1, 1);
                GameController.setGhost2X(x + 1);
                break;
            }
            if (randomNumber == 2 && isCanMove(x - 1, y)) {
                map.getChildren().remove(getNodeByCoordinate(x, y));
                ImageView imageView = new ImageView(ghost2On);
                imageView.setFitHeight(size);
                imageView.setFitWidth(size);
                map.add(imageView, x, y, 1, 1);
                ghost2On = ((ImageView) getNodeByCoordinate(x - 1, y)).getImage();
                map.getChildren().remove(getNodeByCoordinate(x - 1, y));
                ImageView ghost;
                if (isBigDot) {
                    ghost = new ImageView(blueGhostImage);
                } else {
                    ghost = new ImageView(ghost2Image);
                }
                ghost.setFitWidth(size);
                ghost.setFitHeight(size);
                map.add(ghost, x - 1, y, 1, 1);
                GameController.setGhost2X(x - 1);
                break;
            }
            if (randomNumber == 3 && isCanMove(x, y + 1)) {
                map.getChildren().remove(getNodeByCoordinate(x, y));
                ImageView imageView = new ImageView(ghost2On);
                imageView.setFitHeight(size);
                imageView.setFitWidth(size);
                map.add(imageView, x, y, 1, 1);
                ghost2On = ((ImageView) getNodeByCoordinate(x, y + 1)).getImage();
                map.getChildren().remove(getNodeByCoordinate(x, y + 1));
                ImageView ghost;
                if (isBigDot) {
                    ghost = new ImageView(blueGhostImage);
                } else {
                    ghost = new ImageView(ghost2Image);
                }
                ghost.setFitWidth(size);
                ghost.setFitHeight(size);
                map.add(ghost, x, y + 1, 1, 1);
                GameController.setGhost2Y(y + 1);
                break;
            }
            if (randomNumber == 4 && isCanMove(x, y - 1)) {
                map.getChildren().remove(getNodeByCoordinate(x, y));
                ImageView imageView = new ImageView(ghost2On);
                imageView.setFitHeight(size);
                imageView.setFitWidth(size);
                map.add(imageView, x, y, 1, 1);
                ghost2On = ((ImageView) getNodeByCoordinate(x, y - 1)).getImage();
                map.getChildren().remove(getNodeByCoordinate(x, y - 1));
                ImageView ghost;
                if (isBigDot) {
                    ghost = new ImageView(blueGhostImage);
                } else {
                    ghost = new ImageView(ghost2Image);
                }
                ghost.setFitWidth(size);
                ghost.setFitHeight(size);
                map.add(ghost, x, y - 1, 1, 1);
                GameController.setGhost2Y(y - 1);
                break;
            }
        }
        while (timerForGhost3 == 0) {
            int x = GameController.getGhost3X();
            int y = GameController.getGhost3Y();
            int randomNumber = GameController.getRandomNumber(4);
            if (randomNumber == 1 && isCanMove(x + 1, y)) {
                map.getChildren().remove(getNodeByCoordinate(x, y));
                ImageView imageView = new ImageView(ghost3On);
                imageView.setFitHeight(size);
                imageView.setFitWidth(size);
                map.add(imageView, x, y, 1, 1);
                ghost3On = ((ImageView) getNodeByCoordinate(x + 1, y)).getImage();
                map.getChildren().remove(getNodeByCoordinate(x + 1, y));
                ImageView ghost;
                if (isBigDot) {
                    ghost = new ImageView(blueGhostImage);
                } else {
                    ghost = new ImageView(ghost3Image);
                }
                ghost.setFitWidth(size);
                ghost.setFitHeight(size);
                map.add(ghost, x + 1, y, 1, 1);
                GameController.setGhost3X(x + 1);
                break;
            }
            if (randomNumber == 2 && isCanMove(x - 1, y)) {
                map.getChildren().remove(getNodeByCoordinate(x, y));
                ImageView imageView = new ImageView(ghost3On);
                imageView.setFitHeight(size);
                imageView.setFitWidth(size);
                map.add(imageView, x, y, 1, 1);
                ghost3On = ((ImageView) getNodeByCoordinate(x - 1, y)).getImage();
                map.getChildren().remove(getNodeByCoordinate(x - 1, y));
                ImageView ghost;
                if (isBigDot) {
                    ghost = new ImageView(blueGhostImage);
                } else {
                    ghost = new ImageView(ghost3Image);
                }
                ghost.setFitWidth(size);
                ghost.setFitHeight(size);
                map.add(ghost, x - 1, y, 1, 1);
                GameController.setGhost3X(x - 1);
                break;
            }
            if (randomNumber == 3 && isCanMove(x, y + 1)) {
                map.getChildren().remove(getNodeByCoordinate(x, y));
                ImageView imageView = new ImageView(ghost3On);
                imageView.setFitHeight(size);
                imageView.setFitWidth(size);
                map.add(imageView, x, y, 1, 1);
                ghost3On = ((ImageView) getNodeByCoordinate(x, y + 1)).getImage();
                map.getChildren().remove(getNodeByCoordinate(x, y + 1));
                ImageView ghost;
                if (isBigDot) {
                    ghost = new ImageView(blueGhostImage);
                } else {
                    ghost = new ImageView(ghost3Image);
                }
                ghost.setFitWidth(size);
                ghost.setFitHeight(size);
                map.add(ghost, x, y + 1, 1, 1);
                GameController.setGhost3Y(y + 1);
                break;
            }
            if (randomNumber == 4 && isCanMove(x, y - 1)) {
                map.getChildren().remove(getNodeByCoordinate(x, y));
                ImageView imageView = new ImageView(ghost3On);
                imageView.setFitHeight(size);
                imageView.setFitWidth(size);
                map.add(imageView, x, y, 1, 1);
                ghost3On = ((ImageView) getNodeByCoordinate(x, y - 1)).getImage();
                map.getChildren().remove(getNodeByCoordinate(x, y - 1));
                ImageView ghost;
                if (isBigDot) {
                    ghost = new ImageView(blueGhostImage);
                } else {
                    ghost = new ImageView(ghost3Image);
                }
                ghost.setFitWidth(size);
                ghost.setFitHeight(size);
                map.add(ghost, x, y - 1, 1, 1);
                GameController.setGhost3Y(y - 1);
                break;
            }
        }
        while (timerForGhost4 == 0) {
            int x = GameController.getGhost4X();
            int y = GameController.getGhost4Y();
            int randomNumber = GameController.getRandomNumber(4);
            if (randomNumber == 1 && isCanMove(x + 1, y)) {
                map.getChildren().remove(getNodeByCoordinate(x, y));
                ImageView imageView = new ImageView(ghost4On);
                imageView.setFitHeight(size);
                imageView.setFitWidth(size);
                map.add(imageView, x, y, 1, 1);
                ghost4On = ((ImageView) getNodeByCoordinate(x + 1, y)).getImage();
                map.getChildren().remove(getNodeByCoordinate(x + 1, y));
                ImageView ghost;
                if (isBigDot) {
                    ghost = new ImageView(blueGhostImage);
                } else {
                    ghost = new ImageView(ghost4Image);
                }
                ghost.setFitWidth(size);
                ghost.setFitHeight(size);
                map.add(ghost, x + 1, y, 1, 1);
                GameController.setGhost4X(x + 1);
                break;
            }
            if (randomNumber == 2 && isCanMove(x - 1, y)) {
                map.getChildren().remove(getNodeByCoordinate(x, y));
                ImageView imageView = new ImageView(ghost4On);
                imageView.setFitHeight(size);
                imageView.setFitWidth(size);
                map.add(imageView, x, y, 1, 1);
                ghost4On = ((ImageView) getNodeByCoordinate(x - 1, y)).getImage();
                map.getChildren().remove(getNodeByCoordinate(x - 1, y));
                ImageView ghost;
                if (isBigDot) {
                    ghost = new ImageView(blueGhostImage);
                } else {
                    ghost = new ImageView(ghost4Image);
                }
                ghost.setFitWidth(size);
                ghost.setFitHeight(size);
                map.add(ghost, x - 1, y, 1, 1);
                GameController.setGhost4X(x - 1);
                break;
            }
            if (randomNumber == 3 && isCanMove(x, y + 1)) {
                map.getChildren().remove(getNodeByCoordinate(x, y));
                ImageView imageView = new ImageView(ghost4On);
                imageView.setFitHeight(size);
                imageView.setFitWidth(size);
                map.add(imageView, x, y, 1, 1);
                ghost4On = ((ImageView) getNodeByCoordinate(x, y + 1)).getImage();
                map.getChildren().remove(getNodeByCoordinate(x, y + 1));
                ImageView ghost;
                if (isBigDot) {
                    ghost = new ImageView(blueGhostImage);
                } else {
                    ghost = new ImageView(ghost4Image);
                }
                ghost.setFitWidth(size);
                ghost.setFitHeight(size);
                map.add(ghost, x, y + 1, 1, 1);
                GameController.setGhost4Y(y + 1);
                break;
            }
            if (randomNumber == 4 && isCanMove(x, y - 1)) {
                map.getChildren().remove(getNodeByCoordinate(x, y));
                ImageView imageView = new ImageView(ghost4On);
                imageView.setFitHeight(size);
                imageView.setFitWidth(size);
                map.add(imageView, x, y, 1, 1);
                ghost4On = ((ImageView) getNodeByCoordinate(x, y - 1)).getImage();
                map.getChildren().remove(getNodeByCoordinate(x, y - 1));
                ImageView ghost;
                if (isBigDot) {
                    ghost = new ImageView(blueGhostImage);
                } else {
                    ghost = new ImageView(ghost4Image);
                }
                ghost.setFitWidth(size);
                ghost.setFitHeight(size);
                map.add(ghost, x, y - 1, 1, 1);
                GameController.setGhost4Y(y - 1);
                break;
            }
        }
    }

    public static Node getNodeByCoordinate(int column, int row) {
        for (Node node : map.getChildren()) {
            if (GridPane.getColumnIndex(node) == column && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    public static boolean isCanMove(int x, int y) {
        return ((((ImageView) getNodeByCoordinate(x, y)).getImage().equals(smallDotImage))
                || ((ImageView) getNodeByCoordinate(x, y)).getImage().equals(bigDotImage)
                || ((ImageView) getNodeByCoordinate(x, y)).getImage().equals(blackWall)
                || ((ImageView) getNodeByCoordinate(x, y)).getImage().equals(pacmanDownImage)
                || ((ImageView) getNodeByCoordinate(x, y)).getImage().equals(pacmanUpImage)
                || ((ImageView) getNodeByCoordinate(x, y)).getImage().equals(pacmanLeftImage)
                || ((ImageView) getNodeByCoordinate(x, y)).getImage().equals(pacmanRightImage));

    }

    public static void resetPacman() {
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 17; j++) {
                if (map2[i][j] == 'P') {
                    setPacmanX(i);
                    setPacmanY(j);
                }
            }
        }
        ghost1X = 1;
        ghost1Y = 1;
        ghost2X = 1;
        ghost2Y = 15;
        ghost3X = 19;
        ghost3Y = 1;
        ghost4X = 19;
        ghost4Y = 15;
    }

    public static void resetImages() {
        if (!ghost1On.equals(pacmanRightImage) && !ghost1On.equals(pacmanDownImage)
                && !ghost1On.equals(pacmanUpImage) && !ghost1On.equals(pacmanLeftImage)) {
            map.getChildren().remove(getNodeByCoordinate(GameController.getGhost1X(), GameController.getGhost1Y()));
            ImageView ghost = new ImageView(ghost1On);
            ghost.setFitHeight(size);
            ghost.setFitWidth(size);
            if (!(ghost1X == -100))
                map.add(ghost, GameController.getGhost1X(), GameController.getGhost1Y(), 1, 1);
        } else {
            map.getChildren().remove(getNodeByCoordinate(GameController.getGhost1X(), GameController.getGhost1Y()));
            ImageView blackWall = new ImageView(Game.blackWall);
            blackWall.setFitWidth(size);
            blackWall.setFitHeight(size);
            map.add(blackWall, GameController.getGhost1X(), GameController.getGhost1Y(), 1, 1);
        }
        ghost1On = ((ImageView) getNodeByCoordinate(1, 1)).getImage();
        if (!ghost2On.equals(pacmanRightImage) && !ghost2On.equals(pacmanDownImage)
                && !ghost2On.equals(pacmanUpImage) && !ghost2On.equals(pacmanLeftImage)) {
            map.getChildren().remove(getNodeByCoordinate(GameController.getGhost2X(), GameController.getGhost2Y()));
            ImageView ghost = new ImageView(ghost2On);
            ghost.setFitHeight(size);
            ghost.setFitWidth(size);
            if (!(ghost2X == -100)){
            map.add(ghost, GameController.getGhost2X(), GameController.getGhost2Y(), 1, 1);
            }
        } else {
            map.getChildren().remove(getNodeByCoordinate(GameController.getGhost2X(), GameController.getGhost2Y()));
            ImageView blackWall = new ImageView(Game.blackWall);
            blackWall.setFitWidth(size);
            blackWall.setFitHeight(size);
            map.add(blackWall, GameController.getGhost2X(), GameController.getGhost2Y(), 1, 1);
        }
        ghost2On = ((ImageView) getNodeByCoordinate(1, 15)).getImage();
        if (!ghost3On.equals(pacmanRightImage) && !ghost3On.equals(pacmanDownImage)
                && !ghost3On.equals(pacmanUpImage) && !ghost3On.equals(pacmanLeftImage)) {
            map.getChildren().remove(getNodeByCoordinate(GameController.getGhost3X(), GameController.getGhost3Y()));
            ImageView ghost = new ImageView(ghost3On);
            ghost.setFitHeight(size);
            ghost.setFitWidth(size);
            if (!(ghost3X == -100))
                map.add(ghost, GameController.getGhost3X(), GameController.getGhost3Y(), 1, 1);
        } else {
            map.getChildren().remove(getNodeByCoordinate(GameController.getGhost3X(), GameController.getGhost3Y()));
            ImageView blackWall = new ImageView(Game.blackWall);
            blackWall.setFitWidth(size);
            blackWall.setFitHeight(size);
            map.add(blackWall, GameController.getGhost3X(), GameController.getGhost3Y(), 1, 1);

        }
        ghost3On = ((ImageView) getNodeByCoordinate(19, 1)).getImage();
        if (!ghost4On.equals(pacmanRightImage) && !ghost4On.equals(pacmanDownImage)
                && !ghost4On.equals(pacmanUpImage) && !ghost4On.equals(pacmanLeftImage)) {
            map.getChildren().remove(getNodeByCoordinate(GameController.getGhost4X(), GameController.getGhost4Y()));
            ImageView ghost = new ImageView(ghost4On);
            ghost.setFitHeight(size);
            ghost.setFitWidth(size);
            if (ghost4X != -100)
                map.add(ghost, GameController.getGhost4X(), GameController.getGhost4Y(), 1, 1);
        } else {
            map.getChildren().remove(getNodeByCoordinate(GameController.getGhost4X(), GameController.getGhost4Y()));
            ImageView blackWall = new ImageView(Game.blackWall);
            blackWall.setFitWidth(size);
            blackWall.setFitHeight(size);
            map.add(blackWall, GameController.getGhost4X(), GameController.getGhost4Y(), 1, 1);

        }
        ghost4On = ((ImageView) getNodeByCoordinate(19, 15)).getImage();
        GameController.resetPacman();
        map.getChildren().remove(getNodeByCoordinate(GameController.getPacmanX(), GameController.getPacmanY()));
        ImageView creator = new ImageView(pacmanRightImage);
        creator.setFitHeight(size);
        creator.setFitWidth(size);
        map.add(creator, GameController.getPacmanX(), GameController.getPacmanY(), 1, 1);
        map.getChildren().remove(getNodeByCoordinate(GameController.getGhost1X(), GameController.getGhost1Y()));
        creator = new ImageView(ghost1Image);
        creator.setFitHeight(size);
        creator.setFitWidth(size);
        map.add(creator, GameController.getGhost1X(), GameController.getGhost1Y(), 1, 1);
        map.getChildren().remove(getNodeByCoordinate(GameController.getGhost2X(), GameController.getGhost2Y()));
        creator = new ImageView(ghost2Image);
        creator.setFitHeight(size);
        creator.setFitWidth(size);
        map.add(creator, GameController.getGhost2X(), GameController.getGhost2Y(), 1, 1);
        map.getChildren().remove(getNodeByCoordinate(GameController.getGhost3X(), GameController.getGhost3Y()));
        creator = new ImageView(ghost3Image);
        creator.setFitHeight(size);
        creator.setFitWidth(size);
        map.add(creator, GameController.getGhost3X(), GameController.getGhost3Y(), 1, 1);
        map.getChildren().remove(getNodeByCoordinate(GameController.getGhost4X(), GameController.getGhost4Y()));
        creator = new ImageView(ghost4Image);
        creator.setFitHeight(size);
        creator.setFitWidth(size);
        map.add(creator, GameController.getGhost4X(), GameController.getGhost4Y(), 1, 1);
    }


    public static void setScore() {
        if (User.getUserByName(name) != null) {
            User.getUserByName(name).setScore(scorePoint);
        }
    }

    public static int getRandomNumber(int number) {
        Random random = new Random();
        int randomNumber = random.nextInt(number);
        return randomNumber + 1;
    }

    public static void resetGhost(int i) {
        if (i == 1) {
            ghost1X = 1;
            ghost1Y = 1;
            ghost1On = ((ImageView) getNodeByCoordinate(1, 1)).getImage();
        }
        if (i == 2) {
            ghost2X = 1;
            ghost2Y = 15;
            ghost2On = ((ImageView) getNodeByCoordinate(1, 15)).getImage();
        }
        if (i == 3) {
            ghost3X = 19;
            ghost3Y = 1;
            ghost3On = ((ImageView) getNodeByCoordinate(19, 1)).getImage();
        }
        if (i == 4) {
            ghost4X = 19;
            ghost4Y = 15;
            ghost4On = ((ImageView) getNodeByCoordinate(19, 15)).getImage();
        }
    }
}
