package server.model;

import utility.observer.subject.NamedPropertyChangeSubject;
import utility.observer.subject.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public interface Model extends UnnamedPropertyChangeSubject {


    void addMessage(Message messageObject);

    ArrayList<Message> getAllMessages();

    boolean userNameExist(String name);

    boolean userExist(String name, String password);

    void addProfile(String name, String password) throws IOException;
}
