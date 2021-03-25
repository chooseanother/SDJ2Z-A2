package client.model;

import client.mediator.ChatClient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.ArrayList;

public class ModelManager implements Model,PropertyChangeListener {
    MessageList messageList;
    public static final String HOST = "localhost";
    public static final int PORT = 2910;
    private PropertyChangeSupport property;
    private ChatClient client;


    public ModelManager() throws IOException {
        this.property = new PropertyChangeSupport(this);
        this.client = new ChatClient(this, HOST, PORT);
        client.addListener(this);

        this.messageList = new MessageList();

    }

    @Override
    public void addMessage(Message messageObject) throws Exception {
        client.addMessage(messageObject);
    }

    @Override
    public ArrayList<Message> getAllMessages() {
        return messageList.getMessages();
    }

    @Override public boolean userNameExist(String name) throws IOException
    {
        return client.userNameExist(name);
    }

    @Override public boolean userExist(String name, String password)
        throws IOException
    {
        return client.userExist(name, password);
    }

    @Override public void addProfile(String name, String password)
        throws IOException
    {
        client.addProfile(name, password);
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);

    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        property.firePropertyChange(evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());

    }
}
