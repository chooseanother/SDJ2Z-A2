package client.viewmodel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class LoginViewModel {
    private Model model;
    private StringProperty username, password;

    public LoginViewModel(Model model){
        this.model = model;
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
    }

    public void clear(){
        username.setValue(null);
        password.setValue(null);
    }

    public StringProperty getPassword()
    {
        return password;
    }

    public StringProperty getUsername()
    {
        return username;
    }

    public boolean accept(){
        return true;
    }
}
