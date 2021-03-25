package server.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import server.viewmodel.SimpleMessagesViewModel;


public class ChatViewController extends ViewController {
    @FXML private TableColumn<SimpleMessagesViewModel, String> Name;
    @FXML private TableColumn<SimpleMessagesViewModel, String> Message;
    @FXML private TableView<SimpleMessagesViewModel> chatTextArea;
    @FXML private TextField TextToBeSent;
    @FXML private Button Send, Log, Logout;

    @Override protected void init() {
        Name.setCellValueFactory(cellData -> cellData.getValue().getUsr());
        Message.setCellValueFactory(cellData -> cellData.getValue().getMsg());
        chatTextArea.setItems(getViewModelFactory().getChatViewModel().getList());
        TextToBeSent.textProperty().bindBidirectional(getViewModelFactory().getChatViewModel().getMsg());
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

    public void onSend(ActionEvent actionEvent) {
        getViewModelFactory().getChatViewModel().addMessage();
    }
}
