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
import java.util.HashMap;

public class ChatClient implements Model {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Gson gson;
    private PropertyChangeSupport property;
    private ArrayList<MessagePackage> masagePackage;
    private MessagePackage messageListPackage;
    private Model model;

    private boolean waiting;

    public ChatClient(Model model, String host, int port) throws IOException {
        socket = new Socket(host, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        gson = new Gson();
        this.model = model;
        masagePackage = new ArrayList<>();
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
                masagePackage.add(msg);
                property.firePropertyChange(msg.getType(), msg.getMessage().getMsg(), msg.getMessage().getUsr());

                notify();
            } else {

                property.firePropertyChange(msg.getType(), msg.getMessage().getMsg(), msg.getMessage().getUsr());
            }
        } else {
            if (waiting) {
                messageListPackage = (gson.fromJson(json, MessagePackage.class));
                notify();
            }
        }


    }

    private synchronized MessagePackage waitingForReply() {
        waiting = true;
        while (masagePackage.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        waiting = false;
        return masagePackage.remove(0);
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

    @Override public boolean userNameExist(String name) throws IOException
    {
        System.out.println("Client requests if name all ready exist");
        out.println(gson.toJson(new MessagePackage(new Message(name,null), "Name")));
        boolean result = gson.fromJson(in.readLine(), MessagePackage.class).isError();
        return result;
    }

    @Override public boolean userExist(String name, String password)
        throws IOException
    {
        System.out.println("Client requests if User exist");
        out.println(gson.toJson(new MessagePackage(new Message(name,null), "Exist", password)));
        boolean result = gson.fromJson(in.readLine(), MessagePackage.class).isError();
        return result;
    }

    @Override public void addProfile(String name, String password)
        throws IOException
    {
        System.out.println("Client is registering");
        out.println(gson.toJson(new MessagePackage(new Message(name, null), "Register", password)));
    }
}
