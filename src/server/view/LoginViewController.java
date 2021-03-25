package server.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import server.viewmodel.LoginViewModel;
import server.viewmodel.ViewModelFactory;

public class LoginViewController extends ViewController {
    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML private Label errorLabel;

    private LoginViewModel viewModel;


    @Override protected void init()
    {
        viewModel = super.getViewModelFactory().getLoginViewModel();
        usernameField.textProperty().bindBidirectional(viewModel.getUsername());
        passwordField.textProperty().bindBidirectional(viewModel.getPassword());
        errorLabel.textProperty().bind(viewModel.getError());
    }

    @Override public void reset(){
        getViewModelFactory().getLoginViewModel().clear();
    }

    @FXML
    private void onLogin(){
        if(viewModel.logIn())
        {
            getViewHandler().openView(View.CHAT);
        }
        else{
            viewModel.getError();
        }
    }

    public void onRegister(ActionEvent actionEvent)
    {
        getViewHandler().openView(View.REGISTER);
    }
}
