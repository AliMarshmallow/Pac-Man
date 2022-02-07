package sample.model;

import java.util.ArrayList;
import java.util.Random;

public class Map {
    public char[][] map = new char[21][17];
    public static ArrayList<Map> allMaps = new ArrayList<>();
    public int id;

    public Map() {
        setMap(MapGenerator.getMap());
        this.id = getMaxId();
        allMaps.add(this);
    }

    public int getMaxId(){
        int max = 0;
        for (Map allMap : allMaps) {
            if (max< allMap.getId()){
                max= allMap.getId();
            }
        }
        return ++max;
    }

    public int getId() {
        return id;
    }

    public void setMap(char[][] map) {
        int counter = 12;
        while (counter != 0) {
            int x = getRandomNumber(19);
            int y = getRandomNumber(15);
            if (map[x][y] == '1') {
                map[x][y] = '0';
                counter -= 1;
            }
        }
        for (int i = 1; i < 16; i++) {
            map[1][i] = '0';
            map[19][i] = '0';
        }
        for (int i = 1; i < 20; i++) {
            map[i][1] = '0';
            map[i][15] = '0';
        }
        counter = 4;
        while (counter != 0) {
            int x = getRandomNumber(19);
            int y = getRandomNumber(15);
            if (map[x][y] == '0') {
                map[x][y] = '2';
                counter -= 1;
            }
        }
        int x = getRandomNumber(19);
        int y = getRandomNumber(15);
        map[x][y] = 'P';
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 17; j++) {
                if (map[i][j] == '0' || map[i][j] == '*') {
                    map[i][j] = 'S';
                } else if (map[i][j] == '2') {
                    map[i][j] = 'B';
                } else if (map[i][j]!='P'){
                    map[i][j] = 'W';
                }
            }
        }
        map[1][1] = '1';
        map[1][15] = '2';
        map[19][1] = '3';
        map[19][15] = '4';
        this.map = map;
    }

    public char[][] getMap() {
        return map;
    }

    public static char[][] getMapsFromAllMap(int i) {
        if (allMaps.size()>i) {
            return allMaps.get(i).getMap();
        }
        return null;
    }

    public static void addMap(Map map) {
        allMaps.add(map);
    }

    public static ArrayList<Map> getAllMaps() {
        return allMaps;
    }

    private static int getRandomNumber(int number) {
        Random random = new Random();
        int randomNumber = random.nextInt(number);
        return randomNumber + 1;
    }
}
