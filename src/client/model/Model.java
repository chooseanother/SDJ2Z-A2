package client.model;

import utility.observer.subject.UnnamedPropertyChangeSubject;

import java.util.ArrayList;

public interface Model extends UnnamedPropertyChangeSubject {


    void addMessage(Message messageObject) throws Exception;

    ArrayList<Message> getAllMessages();
}
