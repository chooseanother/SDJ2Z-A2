package server.model;

import client.mediator.ChatClient;
import server.mediator.ChatServer;
import server.model.MessageList;
import server.model.Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.ArrayList;

public class ModelManager implements Model {
    server.model.MessageList messageList;
    public static final String HOST = "localhost";
    public static final int PORT = 2910;
    private PropertyChangeSupport property;
    private LogMultiton multiton;



    public ModelManager()  {
        this.property = new PropertyChangeSupport(this);

        this.messageList = new MessageList();

    }

    @Override
    public void addMessage(Message messageObject) {
        messageList.add(messageObject);
        addLog(messageObject.toString());
        property.firePropertyChange("Message",messageObject.getMsg(),messageObject);
    }

    @Override
    public void addLog(String log) {
        multiton = LogMultiton.getInstance(new DateTime().getSortableDate());
        multiton.addLog(log);
        property.firePropertyChange("Log" ,null, log);
    }

    @Override
    public ArrayList<Message> getAllMessages() {
        return messageList.getMessages();
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);

    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);

    }
}
