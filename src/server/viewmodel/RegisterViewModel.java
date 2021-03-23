package server.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import server.model.Model;

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

  /*public boolean isOriginal(){
    if (!model.userExist(username.get())){
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
    /*if(isOriginal()){
      return error;
    }
    error.setValue("user all ready exist");*/
    return error;
  }
}
