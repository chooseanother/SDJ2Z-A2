package client.model;

import utility.observer.subject.UnnamedPropertyChangeSubject;

import java.io.IOException;
import java.util.ArrayList;

public interface Model extends UnnamedPropertyChangeSubject {


    void addMessage(Message messageObject) throws Exception;

    ArrayList<Message> getAllMessages();


    boolean login(String name, String password) throws Exception;

    boolean registerUser(String name, String password) throws Exception;
}
