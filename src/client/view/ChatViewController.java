package client.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import client.view.View;
import client.view.ViewController;
import client.viewmodel.SimpleMessagesViewModel;

public class ChatViewController extends ViewController {

    public TableColumn<SimpleMessagesViewModel, String> Name;
    public TableColumn<SimpleMessagesViewModel, String> Message;
    public TableView<SimpleMessagesViewModel> chatTextArea;
    public TextField TextToBeSent;
    @FXML
    private Button Send, Log, Logout;
    @Override
    protected void init() {
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
        getViewHandler().openView(client.view.View.LOG);
    }

    @FXML
    private void onLogout(){
        getViewHandler().openView(View.LOGIN);
    }

    public void onSend(ActionEvent actionEvent) {
        getViewModelFactory().getChatViewModel().accept();
    }
}
