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

    public String getPassword()
    {
        return password.get();
    }

    public String getUsername()
    {
        return username.get();
    }

    public boolean accept(){
        return true;
    }
}
