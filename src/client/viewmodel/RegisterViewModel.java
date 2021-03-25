package client.viewmodel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.IOException;

public class RegisterViewModel
{
  private Model model;
  private StringProperty username, password, error;

  public RegisterViewModel(Model model){
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


  public boolean register() throws Exception
  {
    boolean result = false;
    try{
      result = model.registerUser(username.get(), password.get());
    }
    catch (Exception e){
      error.setValue(e.getMessage());
    }
    return result;
  }

  public StringProperty getUsername()
  {
    return username;
  }

  public StringProperty getPassword()
  {
    return password;
  }

  public StringProperty getError() throws Exception
  {
      error.setValue("user all ready exist");
      return error;
  }
}
