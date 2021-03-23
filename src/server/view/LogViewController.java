package server.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import server.viewmodel.LogViewModel;

public class LogViewController extends ViewController {
    @FXML
    private TextArea logTextArea;
    private LogViewModel viewModel;

    public LogViewController() {
    }

    @Override
    protected void init()
    {
        init(getViewHandler() , getViewModelFactory() ,getRoot());
        logTextArea.textProperty().bind(viewModel.getLogTextArea());
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
