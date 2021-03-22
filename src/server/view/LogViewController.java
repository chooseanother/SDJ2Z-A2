package server.view;

import javafx.fxml.FXML;

public class LogViewController extends ViewController{
    @Override
    protected void init() {

    }
    @Override public void reset(){
        getViewModelFactory().getLogViewModel().clear();
    }
    @FXML
    private void onChat(){
        getViewHandler().openView(View.CHAT);
    }
}
