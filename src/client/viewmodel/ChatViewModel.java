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
                try {
                    Message m = new Message((String) evt.getNewValue(),(String) evt.getOldValue());
                    SendMessage(m);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //
            }
        });
    }
    public void accept()
    {
        try {
            model.addMessage(createMessageObject());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Message createMessageObject()  {
        Message m = new Message("david", getMsg().get());
        return m;

    }
}
