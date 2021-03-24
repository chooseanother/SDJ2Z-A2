package server.view;

import com.sun.source.tree.Tree;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Callback;
import server.model.Message;
import server.viewmodel.ChatViewModel;
import server.viewmodel.SimpleMessagesViewModel;

import javax.swing.*;
import javax.swing.text.AbstractDocument;

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
