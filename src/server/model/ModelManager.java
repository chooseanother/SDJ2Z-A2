package server.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ModelManager implements Model {
    MessageList messageList;
    private PropertyChangeSupport property;


    public ModelManager() {
        this.property = new PropertyChangeSupport(this);

        this.messageList = new MessageList();

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

    @Override
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);

    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);

    }
}
