package server.viewmodel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import server.model.LogMultiton;
import server.model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LogViewModel implements PropertyChangeListener {
    private Model model;
    private ObservableList<String> logText;

    public LogViewModel(Model model) {
        this.model = model;
        this.model.addListener(this);
        logText = FXCollections.observableArrayList();
    }

    public ObservableList<String> getLogTextArea() {
        return logText;
    }

    public void clear() {
        //
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            if (evt.getPropertyName().equals("log")) {
                LogMultiton multiton = (LogMultiton) evt.getOldValue();

                logText.add(multiton.toString());
            }
        });
    }
}
