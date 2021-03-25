package client.mediator;

import client.model.Message;

import java.util.ArrayList;

public class MessageListPackage {
    private String type;
    private ArrayList<Message> messages;

    public MessageListPackage(String type){
        this.type = type;
        messages = null;
    }

    public MessageListPackage(String type,ArrayList<Message>exercises){
        this.messages = exercises;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Message> getExercises() {
        return messages;
    }

    @Override public String toString(){
        if (messages == null){
            return type;
        }
        StringBuilder sb = new StringBuilder(type+"\n");
        for (Message e : messages){
            sb.append(e).append(" ");
        }
        return sb.toString();
    }
}