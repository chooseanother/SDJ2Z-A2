package server.model;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LogLine {
    private String text;
    private DateTime dateTime;

    public LogLine(String text) {
        this.text = text;
        dateTime = new DateTime();
    }

    public String getText() {
        return text;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        try {
            return text + " " + dateTime + " " + InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

}
