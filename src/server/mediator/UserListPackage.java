package server.mediator;

import java.util.ArrayList;

public class UserListPackage {
    private ArrayList<String> users;

    //Maybe change ArrayList<String> to contain ArrayList<User> if we have a class for that, or if its needed

    public UserListPackage(ArrayList<String> users){
        this.users = users;
    }

    public ArrayList<String> getUsers(){
        return users;
    }
}
