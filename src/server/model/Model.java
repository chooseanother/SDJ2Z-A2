package server.model;

import utility.observer.subject.UnnamedPropertyChangeSubject;

public interface Model extends UnnamedPropertyChangeSubject {
    void addMessage(Message messageObject);
    void addLog(String log);
    boolean login(String usr,String pwd) throws Exception;
    boolean registerUser(String usr,String pwd) throws Exception;
}
