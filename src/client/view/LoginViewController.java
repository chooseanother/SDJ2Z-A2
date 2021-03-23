package client.view;

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
}
