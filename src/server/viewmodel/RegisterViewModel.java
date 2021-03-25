package server.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import server.model.Model;

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

  public boolean isOriginal(){
    if (!model.userNameExist(username.get())){
      return true;
    }
    return false;
  }
  public void register() throws IOException
  {
    if (username != null && password != null)
    {
      model.addProfile(username.get(), password.get());
    }
    else {
      error.setValue("there is missing name or password");
      getError();
    }
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
    if(isOriginal()){
      error.setValue("");
    }
    else {
      error.setValue("username all ready exist");
    }
    return error;
  }
}
