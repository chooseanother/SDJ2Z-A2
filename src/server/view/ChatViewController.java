package server.view;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import server.model.Message;
import server.viewmodel.ChatViewModel;
import server.viewmodel.SimpleMessagesViewModel;

public class ChatViewController extends ViewController{

    public TableColumn<SimpleMessagesViewModel,String> Name;
    public TableColumn<SimpleMessagesViewModel,String> Message;
    public TableView<SimpleMessagesViewModel> chatTextArea;
    public TextField TextToBeSent;
    @FXML private Button Send,Log,Logout;

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
        getViewHandler().openView(View.LOG);
    }

    @FXML
    private void onLogout(){
        getViewHandler().openView(View.LOGIN);
    }

    public void onSend(ActionEvent actionEvent) {
        getViewModelFactory().getChatViewModel().createMessageObject();
    }
}
