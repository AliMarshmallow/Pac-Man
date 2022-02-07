package sample.cotroller;

import com.google.gson.Gson;
import sample.model.Map;
import sample.model.User;

import java.io.*;

public class Initializer {

    public static void addUsersAndMaps() {
        File directoryPath = new File("resources/Users");
        File[] filesList = directoryPath.listFiles();
        assert filesList != null;
        for (File file : filesList) {

            Gson gson = new Gson();
            Reader reader = null;
            try {
                reader = new FileReader(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            User user = gson.fromJson(reader, User.class);
            User.addToAllUsers(user);
        }
        File directoryPath2 = new File("resources/Maps");
        File[] filesList2 = directoryPath2.listFiles();
        assert filesList2 != null;
        for (File file : filesList2) {

            Gson gson = new Gson();
            Reader reader = null;
            try {
                reader = new FileReader(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Map map = gson.fromJson(reader, Map.class);
            Map.addMap(map);
        }
    }

}
