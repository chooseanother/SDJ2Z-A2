package server.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.ArrayList;

public class ModelManager implements Model {
    MessageList messageList;
    private PropertyChangeSupport property;
    private UserList userList;


    public ModelManager() throws IOException
    {
        this.property = new PropertyChangeSupport(this);

        this.messageList = new MessageList();

        this.userList = new UserList();

    }

    @Override
    public void addMessage(Message messageObject) {
        messageList.add(messageObject);
        property.firePropertyChange("Message",messageObject.getMsg(),messageObject);
    }

    @Override
    public ArrayList<Message> getAllMessages() {
        return messageList.getMessages();
    }

    @Override public boolean userNameExist(String name)
    {
        return userList.nameExist(name);
    }

    @Override public boolean userExist(String name, String password)
    {
        return userList.userExist(name, password);
    }

    @Override public void addProfile(String name, String password)
        throws IOException
    {
        userList.addProfile(name, password);
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
