package server.model;

import utility.observer.subject.NamedPropertyChangeSubject;
import utility.observer.subject.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.io.DataOutputStream;
import java.util.ArrayList;

public interface Model extends UnnamedPropertyChangeSubject {


    void addMessage(Message messageObject);

    ArrayList<Message> getAllMessages();
}
