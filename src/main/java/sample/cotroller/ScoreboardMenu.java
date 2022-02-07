package sample.cotroller;

import sample.model.BubbleSort;
import sample.model.User;

import java.util.ArrayList;

public class ScoreboardMenu {

    public static ArrayList<String> getUsers(){
        ArrayList<User> users = User.getAllUsers();
        BubbleSort bubbleSort = new BubbleSort();
        users=bubbleSort.sort(users);
        ArrayList<String> usernames = new ArrayList<>();
        int counter = 1;
        for (int i = 0; i < 10; i++) {
            if (users.size() == i)
                break;
            if ( i==0 || users.get(i).getScore()!=users.get(i-1).getScore()){
                counter = i+1;
            }
            User user = users.get(i);
            usernames.add(counter+". "+user.getName()+" with score "+user.getScore());
        }
        return usernames;
    }
}
