package client;

import client.model.Model;
import client.model.ModelManager;
import client.view.ViewHandler;
import client.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;


public class ClientApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Model model = new ModelManager();
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler view = new ViewHandler(viewModelFactory);
        view.start(primaryStage);
    }
}
