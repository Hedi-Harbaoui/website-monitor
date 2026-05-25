package de.frankfurt_uas.websitemonitor;

import de.frankfurt_uas.websitemonitor.controller.MonitorController;

public class Main {
    public static void main(String[] args) {
        MonitorController controller = new MonitorController();

        //urls
        controller.registerNewUser("https://example.com", "Hourly", "Email");
        controller.registerNewUser("https://mail.google.com/mail/u/0/#inbox", "Daily", "SMS");
        
        //check
        controller.checkAll();
    }
}