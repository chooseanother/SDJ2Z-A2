package client.viewmodel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class LoginViewModel {
    private Model model;
    private StringProperty username, password, error;
    private UserInformation user;

    public LoginViewModel(Model model){
        this.model = model;
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        error = new SimpleStringProperty();
        user = new UserInformation();
    }

    public void clear(){
        username.setValue(null);
        password.setValue(null);
        error.setValue(null);
    }

    /*public boolean logIn(){
        if(model.userExist(username.get(), password.get())){
            user.setUser(username.get());
            return true;
        }
        return false;
    }*/

    public StringProperty getUsername()
    {
        return username;
    }

    public StringProperty getPassword()
    {
        return password;
    }

    public StringProperty getError()
    {
        /*if (!logIn()){
            return error;
        }
        else if (!model.userNameExist(username.get())){
            error.setValue("wrong password");
            return error;
        }
        else {
            error.setValue("user doesn't exist");
            return error;
        }*/
        return error;
    }
    public void logOUt(){
        user.setUser(username.get());
    }
}
