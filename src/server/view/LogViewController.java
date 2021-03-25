package server.view;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import server.viewmodel.LogViewModel;

public class LogViewController extends ViewController {
    @FXML
    private ListView<String> logTextArea;

    public LogViewController() {
    }

    @Override
    protected void init()
    {
        logTextArea.setItems(getViewModelFactory().getLogViewModel().getLogTextArea());
    }

    @Override
    public void reset() {
        getViewModelFactory().getLogViewModel().clear();
    }

    @FXML
    private void onChat() {
        getViewHandler().openView(View.CHAT);
    }
}
