package sample.cotroller;

import sample.model.User;

public class MainMenu {

    public static String usernameLogin;

    public static void deleteUser(){
        User.deleteUser(usernameLogin);
    }

    public static String getUsernameLogin() {
        return usernameLogin;
    }

    public static void changePassword(String password){
        User.getUserByName(usernameLogin).setPassword(password);
    }

    public static void setUsernameLogin(String usernameLogin) {
        MainMenu.usernameLogin = usernameLogin;
    }
}
