package client.view;


import client.viewmodel.LoginViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class LoginViewController extends ViewController {
    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML private Label errorLabel;



    @Override protected void init() throws Exception
    {
        usernameField.textProperty().bindBidirectional(getViewModelFactory().getLoginViewModel().getUsername());
        passwordField.textProperty().bindBidirectional(getViewModelFactory().getLoginViewModel().getPassword());
        errorLabel.textProperty().bind(getViewModelFactory().getLoginViewModel().getError());
    }

    @Override public void reset(){
        getViewModelFactory().getLoginViewModel().clear();
    }

    @FXML
    private void onLogin() throws Exception
    {
        if(getViewModelFactory().getLoginViewModel().logIn())
        {
            getViewHandler().openView(View.CHAT);
        }
        else{
            getViewModelFactory().getLoginViewModel().getError();
        }
    }

    public void onRegister(ActionEvent actionEvent)
    {
        getViewHandler().openView(View.REGISTER);
    }
}
