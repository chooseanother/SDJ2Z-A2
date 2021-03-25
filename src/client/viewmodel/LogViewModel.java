package client.viewmodel;

import client.model.Model;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LogViewModel implements PropertyChangeListener {
    private Model model;
    private ObservableList<String> logText;

    public LogViewModel(Model model){
        this.model = model;
        this.model.addListener(this);
        logText = FXCollections.observableArrayList();
    }

    public ObservableList<String> getLogTextArea() {
        return logText;
    }

    public void clear(){

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            if (evt.getPropertyName().equals("Log")) {
                logText.add((String)evt.getNewValue());
            }
        });
    }
}
