package de.frankfurt_uas.websitemonitor;

import de.frankfurt_uas.websitemonitor.controller.MonitorController;
import de.frankfurt_uas.websitemonitor.domain.strategy.ContentSizeStrategy;
import de.frankfurt_uas.websitemonitor.domain.strategy.HtmlContentStrategy;
import de.frankfurt_uas.websitemonitor.domain.strategy.TextContentStrategy;

public class Main {

    public static void main(String[] args) {

        MonitorController controller = new MonitorController();

        controller.registerNewUser("https://example.com", "Hourly", "Email", new ContentSizeStrategy());
        controller.registerNewUser("https://news.com",    "Daily",  "SMS",   new HtmlContentStrategy());
        controller.registerNewUser("https://docs.com",    "Weekly", "Email", new TextContentStrategy());

        System.out.println("\n>>> Round 1: taking initial snapshots ...");
        controller.checkAll();

        System.out.println(">>> Round 2: comparing with snapshots ...");
        controller.checkAll();
    }
}
