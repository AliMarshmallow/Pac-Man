package sample.model;

import java.util.Random;

public class MapGenerator {


    public static char[][] getMap() {
        int width = 10, length = 8;
        char[][] maze = new char[2 * width + 1][2 * length + 1];
        createFirstMaze(width, length, maze);
        int xLocate = getRandomNumber(width), yLocate = getRandomNumber(length);
        createMaze(maze, xLocate, yLocate, width, length);
        return maze;
    }


    private static void createMaze(char[][] maze, int xLocate, int yLocate, int width, int length) {
        maze[xLocate * 2 - 1][yLocate * 2 - 1] = '*';
        int randomNumber = getRandomNumber(4);
        switch (randomNumber) {   //create random maze
            case 1:
                upNeighbor(maze, xLocate, yLocate, width, length);
                downNeighbor(maze, xLocate, yLocate, width, length);
                leftNeighbor(maze, xLocate, yLocate, width, length);
                rightNeighbor(maze, xLocate, yLocate, width, length);
                break;
            case 2:
                rightNeighbor(maze, xLocate, yLocate, width, length);
                upNeighbor(maze, xLocate, yLocate, width, length);
                downNeighbor(maze, xLocate, yLocate, width, length);
                leftNeighbor(maze, xLocate, yLocate, width, length);
                break;
            case 3:
                leftNeighbor(maze, xLocate, yLocate, width, length);
                rightNeighbor(maze, xLocate, yLocate, width, length);
                upNeighbor(maze, xLocate, yLocate, width, length);
                downNeighbor(maze, xLocate, yLocate, width, length);
                break;
            case 4:
                downNeighbor(maze, xLocate, yLocate, width, length);
                leftNeighbor(maze, xLocate, yLocate, width, length);
                rightNeighbor(maze, xLocate, yLocate, width, length);
                upNeighbor(maze, xLocate, yLocate, width, length);
        }
    }

    private static void rightNeighbor(char[][] maze, int xLocate, int yLocate, int width, int length) {
        if (yLocate < length && checkNeighbor(xLocate, yLocate + 1, maze)) {
            maze[xLocate * 2 - 1][yLocate * 2] = '0';
            createMaze(maze, xLocate, yLocate + 1, width, length);
        }
    }

    private static void leftNeighbor(char[][] maze, int xLocate, int yLocate, int width, int length) {
        if (yLocate > 1 && checkNeighbor(xLocate, yLocate - 1, maze)) {
            maze[xLocate * 2 - 1][yLocate * 2 - 2] = '0';
            createMaze(maze, xLocate, yLocate - 1, width, length);
        }
    }

    private static void downNeighbor(char[][] maze, int xLocate, int yLocate, int width, int length) {
        if (xLocate < width && checkNeighbor(xLocate + 1, yLocate, maze)) {
            maze[xLocate * 2][yLocate * 2 - 1] = '0';
            createMaze(maze, xLocate + 1, yLocate, width, length);
        }
    }

    private static void upNeighbor(char[][] maze, int xLocate, int yLocate, int width, int length) {
        if (xLocate > 1 && checkNeighbor(xLocate - 1, yLocate, maze)) {
            maze[xLocate * 2 - 2][yLocate * 2 - 1] = '0';
            createMaze(maze, xLocate - 1, yLocate, width, length);
        }
    }

    public static boolean checkNeighbor(int xLocate, int yLocate, char[][] maze) {
        return maze[xLocate * 2 - 1][yLocate * 2 - 1] == '+';
    }

    private static int getRandomNumber(int number) {
        Random random = new Random();
        int randomNumber = random.nextInt(number);
        return randomNumber + 1;
    }

    private static void createFirstMaze(int width, int length, char[][] maze) {
        for (int j = 0; j < width * 2 + 1; j++) {
            for (int k = 0; k < length * 2 + 1; k++) {
                if (j % 2 == 0 || k % 2 == 0) maze[j][k] = '1';
                else maze[j][k] = '+';
            }
        }
    }


}
