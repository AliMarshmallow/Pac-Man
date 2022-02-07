package sample.model;
import java.io.File;
import java.util.ArrayList;

public class User {

    public String name;
    public String password;
    public int score;
    public int numberOfScore;
    public ArrayList<Map> maps = new ArrayList<>();
    public boolean isHadGameFromPast;
    public Map pastGame;

    public static ArrayList<User> allUsers = new ArrayList<>();

    public User(String name, String password) {
        setName(name);
        setPassword(password);
        setScore(0);
        setNumberOfScore(allUsers.size() + 1);
        allUsers.add(this);
    }


    public void setScore(int score) {
        this.score = score;
    }

    public void setNumberOfScore(int numberOfScore) {
        this.numberOfScore = numberOfScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }


    public int getNumberOfScore() {
        return numberOfScore;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void changeScore(int score) {
        this.score += score;
        this.numberOfScore = 99999;
        int max = 0;
        for (User user : allUsers) {
            if (user.getScore() == this.score && user.getNumberOfScore() > max)
                max = user.getNumberOfScore();
        }
        this.numberOfScore = max + 1;
    }

    public ArrayList<Map> getMaps() {
        return maps;
    }

    public void setMaps(ArrayList<Map> maps) {
        this.maps = maps;
    }

    public boolean isHadGameFromPast() {
        return isHadGameFromPast;
    }

    public void setHadGameFromPast(boolean hadGameFromPast) {
        isHadGameFromPast = hadGameFromPast;
    }

    public Map getPastGame() {
        return pastGame;
    }

    public void setPastGame(Map pastGame) {
        this.pastGame = pastGame;
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public static void deleteUser(String name) {
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getName().equals(name)) {
                allUsers.remove(i);
                File fileForDelete = new File("resources/Users/" + name + ".json");
                fileForDelete.delete();
                return;
            }
        }
    }

    public static User getUserByName(String name) {
        for (User user : allUsers) {
            if (user.getName().equals(name))
                return user;
        }
        return null;
    }

    public static void addToAllUsers(User user) {
        allUsers.add(user);
    }

}
