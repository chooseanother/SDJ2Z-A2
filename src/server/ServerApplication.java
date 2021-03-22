package server;

import javafx.application.Application;
import javafx.stage.Stage;
import server.mediator.ChatServer;
import server.model.Model;
import server.model.ModelManager;
import server.view.ViewHandler;
import server.viewmodel.ViewModelFactory;

import java.io.IOException;

public class ServerApplication extends Application {
    private ChatServer chatServer;
    @Override public void start(Stage primaryStage){
        Model model = new ModelManager();
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler view = new ViewHandler(viewModelFactory);
        chatServer = new ChatServer(model);
        Thread t = new Thread(chatServer);
        t.start();
        view.start(primaryStage);
    }

    @Override public void stop() throws IOException {
        chatServer.close();
    }
}
