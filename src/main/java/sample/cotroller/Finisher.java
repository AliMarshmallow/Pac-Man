package sample.cotroller;

import com.google.gson.Gson;
import sample.model.Map;
import sample.model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Finisher {

    public static void writeFile(){
        ArrayList<User> allUsers = User.getAllUsers();
        for (User user : allUsers) {
            Gson gson = new Gson();
            String fileAddress = "resources/Users/" + user.getName() + ".json";

            try (FileWriter writer = new FileWriter(fileAddress)) {
                gson.toJson(user, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ArrayList<Map> allMaps = Map.getAllMaps();
        for (Map map : allMaps) {
            Gson gson = new Gson();
            String fileAddress = "resources/Maps/" + map.getId() + ".json";

            try (FileWriter writer = new FileWriter(fileAddress)) {
                gson.toJson(map, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

