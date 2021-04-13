package client.viewmodel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import client.model.Message;
import client.model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ChatViewModel implements PropertyChangeListener {
    private Model model;
    private ObservableList<SimpleMessagesViewModel> list;
    private StringProperty usr, msg;
    private UserInformation userInformation;


    public ChatViewModel(Model model, UserInformation userInformation) {
        this.model = model;
        model.addListener(this);
        this.usr = new SimpleStringProperty();
        this.msg = new SimpleStringProperty();
        list = FXCollections.observableArrayList();
        this.userInformation = userInformation;
    }

    public void clear() {
        msg.setValue(null);
    }

    public StringProperty getMsg() {
        return msg;
    }

    public StringProperty getUsr() {
        return usr;
    }

    public ObservableList<SimpleMessagesViewModel> getList() {
        return list;
    }

    public void SendMessage(Message message) {
        list.add(new SimpleMessagesViewModel(message));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() ->
        {
            if (evt.getPropertyName().equals("Message")) {
                try {
                    Message m = (Message) evt.getNewValue();
                    SendMessage(m);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //
            }
        });
    }
    public void addMessage() throws Exception {
        try{
            model.addMessage(createMessageObject());
            msg.setValue(null);
        }
        catch (Exception e){
            //
        }
    }

    public Message createMessageObject() {
        try {
            Message m = new Message(userInformation.getUser(), getMsg().get());
            return m;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;

    }
}
