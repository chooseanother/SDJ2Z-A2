package server.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import server.viewmodel.RegisterViewModel;

public class RegisterViewController extends ViewController
{
  @FXML private TextField usernameField;
  @FXML private TextField passwordField;
  @FXML private Label errorLabel;
  private RegisterViewModel viewModel;

  @Override protected void init()
  {
    viewModel = super.getViewModelFactory().getRegisterViewModel();
    usernameField.textProperty().bindBidirectional(viewModel.getUsername());
    passwordField.textProperty().bindBidirectional(viewModel.getPassword());
    errorLabel.textProperty().bind(viewModel.getError());
  }

  public void onBack(ActionEvent actionEvent)
  {
    getViewHandler().openView(View.LOGIN);
  }

  public void onRegister(ActionEvent actionEvent)
  {
    /*if (viewModel.isOriginal())
    {
      getViewHandler().openView(View.LOGIN);
    }
    else {
      viewModel.getError();
    }*/
  }
}
