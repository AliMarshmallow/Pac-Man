package sample.cotroller;

import sample.model.Map;

public class GameStartController {

    public static int id1;
    public static int id2;


    public static void setId1(int id1) {
        GameStartController.id1 = id1;
    }


    public static void setId2(int id2) {
        GameStartController.id2 = id2;
    }

    public static String username;

    public static char[][] getMap(int i) {
        return Map.getMapsFromAllMap(i - 1);
    }

    public static void setUsername(String username) {
        GameStartController.username = username;
    }

    public static String getUsername() {
        return username;
    }

    public static char[][] getNewMap() {
        return new Map().getMap();
    }

    public static char[][] getNextMap(int flag){
        if (flag == 1){
            if (getMap(id1+2) != null){
                id1+=2;
                return getMap(id1);
            }
            id1 = 2;
            return getMap(id1);
        }
        else {
            if (getMap(id2+2) != null){
                id2+=2;
                return getMap(id2);
            }
            id2 = 3;
            return getMap(id2);
        }
    }
}
