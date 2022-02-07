package sample.model;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {

    public ArrayList<User> sort(ArrayList<User> allUsers) {
        User[] users = allUsers.toArray(new User[0]);
        ArrayList<User> usersAfterSort = new ArrayList<>();
        for (int i = 0; i < users.length; i++) {
            for (int j = 0; j < users.length - 1; j++) {
                if (users[j].getScore() < users[j + 1].getScore() ||
                        (users[j].getScore() == users[j + 1].getScore() && users[j].getNumberOfScore()>users[j+1].getNumberOfScore() )) {
                    User user = users[j];
                    users[j] = users[j + 1];
                    users[j + 1] = user;
                }
            }
        }
        usersAfterSort.addAll(Arrays.asList(users));
        return usersAfterSort;
    }

}
