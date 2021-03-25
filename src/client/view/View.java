package client.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;
import client.view.ViewController;
import client.view.ViewHandler;
import client.viewmodel.ViewModelFactory;

import java.net.URL;

public enum View {
    LOGIN("LoginView.fxml"),CHAT("ChatView.fxml"),LOG("LogView.fxml"),REGISTER("RegisterView.fxml");

    private String fxmlFile;
    private client.view.ViewController viewController;

    private View(String fxmlFile){
        this.fxmlFile = fxmlFile;
    }

    public String getFxmlFile(){
        return fxmlFile;
    }

    public ViewController getViewController(ViewHandler viewHandler, ViewModelFactory viewModelFactory){
        if (viewController == null){
            try {
                FXMLLoader loader = new FXMLLoader();
                URL url = viewHandler.getClass().getResource(fxmlFile);
                loader.setLocation(url);
                Region root = loader.load();
                viewController = loader.getController();
                viewController.init(viewHandler, viewModelFactory, root);
                viewController.init();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            viewController.reset();
        }
        return  viewController;
    }
}
