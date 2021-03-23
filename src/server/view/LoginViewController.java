package server.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LoginViewController extends ViewController {
    @Override
    protected void init() {


    }

    @Override public void reset(){
        getViewModelFactory().getLoginViewModel().clear();
    }

    @FXML
    private void onLogin(){
        getViewHandler().openView(View.CHAT);
    }

    public void onRegister(ActionEvent actionEvent)
    {
        getViewHandler().openView(View.REGISTER);
    }
}
