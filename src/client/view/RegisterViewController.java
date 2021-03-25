package client.view;

import client.viewmodel.RegisterViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegisterViewController extends ViewController
{
  @FXML private TextField usernameField;
  @FXML private TextField passwordField;
  @FXML private Label errorLabel;

  @Override protected void init() throws Exception
  {
    usernameField.textProperty().bindBidirectional(
        getViewModelFactory().getRegisterViewModel().getUsername());
    passwordField.textProperty().bindBidirectional(
        getViewModelFactory().getRegisterViewModel().getPassword());
    errorLabel.textProperty()
        .bind(getViewModelFactory().getRegisterViewModel().getError());
  }

  public void onBack(ActionEvent actionEvent)
  {
    getViewHandler().openView(View.LOGIN);
  }

  public void onRegister(ActionEvent actionEvent) throws Exception
  {
    if (getViewModelFactory().getRegisterViewModel().register())
    {
      getViewHandler().openView(View.LOGIN);
    }
  }
}
