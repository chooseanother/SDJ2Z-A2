package server.viewmodel;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import server.model.Message;
import server.model.Model;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ChatViewModel implements PropertyChangeListener {
    private Model model;
    private ObservableList<SimpleMessagesViewModel> list;
    private StringProperty usr, msg;



    public ChatViewModel(Model model) {
        this.model = model;
        model.addListener(this);
        this.usr = new SimpleStringProperty();
        this.msg = new SimpleStringProperty();
        list = FXCollections.observableArrayList();
        loadFromModel();
    }



    public void clear() {
        // errorProperty.setValue("");
    }

    private void loadFromModel() {
        if (model.getAllMessages().size() > 0) {
            for (Message e : model.getAllMessages()) {
                list.add(new SimpleMessagesViewModel(e));
            }
        }
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
                SendMessage((Message) evt.getNewValue());
            }
        });
    }

    public void addMessage() {
        model.addMessage(createMessageObject());
    }



    public Message createMessageObject() {
        try {
            Message m = new Message("david", getMsg().get());
            return m;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
