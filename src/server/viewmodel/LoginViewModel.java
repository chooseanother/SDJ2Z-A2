package server.viewmodel;

import com.sun.javafx.iio.common.PushbroomScaler;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import server.model.Model;

import javax.swing.*;

public class LoginViewModel {
    private Model model;
    private StringProperty username, password, error;

    public LoginViewModel(Model model){
        this.model = model;
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        error = new SimpleStringProperty();
    }

    public void clear(){
        username.setValue(null);
        password.setValue(null);
        error.setValue(null);
    }

    public boolean logIn(){
        if(model.userExist(username.get(), password.get())){
            return true;
        }
        return false;
    }

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
        error.setValue("");
        if (model.userNameExist(username.get())){
            error.setValue("wrong password");
        }
        else {
            error.setValue("user doesn't exist");
        }
        return error;
    }
}
