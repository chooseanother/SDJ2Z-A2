package client.mediator;

public class MessagePackage {
    private String usr;
    private String msg;

    public MessagePackage(String usr, String msg){
        this.usr = usr;
        this.msg = msg;
    }

    public String getUsr() {
        return usr;
    }

    public String getMsg() {
        return msg;
    }

    @Override public String toString(){
        return usr + ": "+msg;
    }
}
