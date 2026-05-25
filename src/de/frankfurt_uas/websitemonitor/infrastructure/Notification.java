package de.frankfurt_uas.websitemonitor.infrastructure;

public class Notification {
    public void send(String channel, String message) {
        System.out.println("ALERT via " + channel.toUpperCase() + ": " + message);
    }
}