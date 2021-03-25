package client.model;

import utility.observer.subject.UnnamedPropertyChangeSubject;

import java.io.IOException;
import java.util.ArrayList;

public interface Model extends UnnamedPropertyChangeSubject {


    void addMessage(Message messageObject) throws Exception;

    ArrayList<Message> getAllMessages();

    boolean userNameExist(String name) throws IOException;

    boolean userExist(String name, String password) throws IOException;

    void addProfile(String name, String password) throws IOException;
}
