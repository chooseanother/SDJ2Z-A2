package client.mediator;

import client.model.Message;

public class MessagePackage {
    private String type;
    private Message message;

    public MessagePackage(Message message,String type){
        this.type = type;
        this.message = new Message(message.getUsr(),message.getMsg());
    }

    public String getType() {
        return type;
    }

    public Message getMessage() {
        return message;
    }
}
