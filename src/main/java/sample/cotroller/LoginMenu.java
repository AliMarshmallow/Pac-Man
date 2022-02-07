package sample.cotroller;

import sample.model.User;

public class LoginMenu {
    public boolean isPasswordWrong(String name, String password) {
        User user = User.getUserByName(name);
        return !user.getPassword().equals(password);
    }

    public boolean isUserExist(String name) {
        return User.getUserByName(name) != null;
    }

}
