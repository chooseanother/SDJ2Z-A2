package client.mediator;

import client.model.Message;
import client.model.Model;
import com.google.gson.Gson;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ChatClient implements Model {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Gson gson;
    private PropertyChangeSupport property;
    private ArrayList<MessagePackage> messagePackages;
    private UserListPackage userListPackage;
    private Model model;

    private boolean waiting;

    public ChatClient(Model model, String host, int port) throws IOException {
        socket = new Socket(host, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        gson = new Gson();
        this.model = model;
        messagePackages = new ArrayList<>();
        property = new PropertyChangeSupport(this);
        waiting = true;

        ChatClientReceiver ccr = new ChatClientReceiver(this, in);
        Thread t = new Thread(ccr);
        t.setDaemon(true);
        t.start();
    }

    public void disconnect() throws IOException {
        waiting = false;
        socket.close();
        in.close();
        out.close();
    }

    public synchronized void receive(String json) throws Exception {
        System.out.println("Received " + json);


        if (!gson.fromJson(json, MessagePackage.class).getType().equals("All")) {

            MessagePackage msg = gson.fromJson(json, MessagePackage.class);
            if (waiting) {
                messagePackages.add(msg);
                property.firePropertyChange(msg.getType(), msg.getMessage().getMsg(), msg.getMessage().getUsr());

                notify();
            } else {

                property.firePropertyChange(msg.getType(), msg.getMessage().getMsg(), msg.getMessage().getUsr());
            }
        } else {
            if (waiting) {
                userListPackage = (gson.fromJson(json, UserListPackage.class));
                notify();
            }
        }


    }

    private synchronized MessagePackage waitingForReply() {
        waiting = true;
        while (messagePackages.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        waiting = false;
        return messagePackages.remove(0);
    }


    @Override
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }

    @Override
    public void addMessage(Message messageObject) throws Exception {
        System.out.println("Client just sent message : " + messageObject.toString());
        out.println(gson.toJson(new MessagePackage(messageObject, "Message")));
        MessagePackage ep = waitingForReply();
        if ((ep.getType().equals("Error"))) {
            throw new Exception(ep.getMessage().getUsr());
        }

    }

    @Override
    public ArrayList<Message> getAllMessages() {
        return null;
    }
}
