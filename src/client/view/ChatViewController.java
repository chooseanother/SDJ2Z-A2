package client.view;

import javafx.fxml.FXML;


public class ChatViewController extends ViewController {
    @Override
    protected void init() {

    }

    @Override public void reset(){
        getViewModelFactory().getChatViewModel().clear();
    }

    @FXML
    private void onLog(){
        getViewHandler().openView(View.LOG);
    }

    @FXML
    private void onLogout(){
        getViewHandler().openView(View.LOGIN);
    }

}
