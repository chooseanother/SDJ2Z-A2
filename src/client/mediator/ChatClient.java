package client.mediator;

import client.model.Model;
import com.google.gson.Gson;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient implements Model {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Gson gson;
    private PropertyChangeSupport property;

    public ChatClient(String host, int port) throws IOException {
        socket = new Socket(host,port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());
        gson = new Gson();
        property = new PropertyChangeSupport(this);

        ChatClientReceiver ccr = new ChatClientReceiver(this, in);
        Thread t = new Thread(ccr);
        t.setDaemon(true);
        t.start();
    }

    public void receive(String json){

    }

    @Override
    public void addListener(PropertyChangeListener listener) {

    }

    @Override
    public void removeListener(PropertyChangeListener listener) {

    }
}
