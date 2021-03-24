package server.mediator;

import com.google.gson.Gson;
import server.model.Message;
import server.model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatServerClientHandler implements Runnable, PropertyChangeListener {
    private Model model;
    private Socket socket;
    private BufferedReader in; //tcp or udp? hmmm
    private PrintWriter out;
    private boolean running;
    private Gson gson;

    public ChatServerClientHandler(Socket socket, Model model) throws IOException {
        this.socket = socket;
        this.model = model;
        this.model.addListener(this);
        gson = new Gson();
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        running = true;
        while (running){
            try {

                MessagePackage request = gson.fromJson(in.readLine(),MessagePackage.class);
                switch (request.getType()){
                    case "Message":
                        try {
                            model.addMessage(new Message(request.getMessage().getUsr(),request.getMessage().getMsg()));
                        }
                        catch (Exception e){
                            System.out.println("sending eror");
                            out.println(gson.toJson(new MessagePackage(request.getMessage(),"Error")));
                        }
                        break;
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void propertyChange(PropertyChangeEvent event) {
        switch (event.getPropertyName()){
            case "Message":
                System.out.println("Server sending > \"Message\"");
                out.println(gson.toJson(new MessagePackage((Message) event.getNewValue(),"Message")));
                break;
        }
    }
}
