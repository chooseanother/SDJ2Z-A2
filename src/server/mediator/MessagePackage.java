package server.mediator;


import server.model.Message;

public class MessagePackage {
    private String type;
    private Message message;
    private String error;
    private String password;

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
