package server.mediator;

import com.google.gson.Gson;
import server.model.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatServerClientHandler implements Runnable{
    private Model model;
    private Socket socket;
    private BufferedReader in; //tcp or udp? hmmm
    private PrintWriter out;
    private boolean running;
    private Gson gson;

    public ChatServerClientHandler(Socket socket, Model model) throws IOException {
        this.socket = socket;
        this.model = model;
        //listener?
        gson = new Gson();
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        running = true;
        while (running){
            try {
                String json = in.readLine();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
