package sample.cotroller;

import sample.model.User;

public class RegisterMenu {

    public boolean isUserExist(String name) {
        return User.getUserByName(name) != null;
    }

    public void registerNewUser(String name,String password){
        User user = new User(name,password);
    }

}
