package server.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import server.model.Model;

public class LogViewModel
{
    private Model model;
    private StringProperty logTextArea;

    public LogViewModel(Model model) {
        this.model = model;
        this.logTextArea = new SimpleStringProperty("");
    }

    public StringProperty getLogTextArea()
    {
        return logTextArea;
    }

    public void clear()
    {
        logTextArea.set("");
    }
}
