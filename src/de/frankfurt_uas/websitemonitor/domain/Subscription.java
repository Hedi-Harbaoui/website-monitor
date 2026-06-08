package de.frankfurt_uas.websitemonitor.domain;

import de.frankfurt_uas.websitemonitor.infrastructure.WebsiteFetcher;
import java.util.ArrayList;
import java.util.List;

public class Subscription {

    private static int idCounter = 1;

    private String subscriptionId;
    private String url;
    private String frequency;
    private ComparisonStrategy strategy;
    private String previousContent;

    private List<WebsiteObserver> observers = new ArrayList<>();

    public Subscription(String url, String frequency, ComparisonStrategy strategy) {
        this.subscriptionId = "SUB_" + idCounter++;
        this.url      = url;
        this.frequency = frequency;
        this.strategy  = strategy;
    }

    public String getSubscriptionId() { return subscriptionId; }

    public void setFrequency(String frequency) { this.frequency = frequency; }

    public void addObserver(WebsiteObserver observer)    { observers.add(observer);    }
    public void removeObserver(WebsiteObserver observer) { observers.remove(observer); }

    private void notifyObservers(String message) {
        for (WebsiteObserver observer : observers) {
            observer.update(url, message);
        }
    }

    public void checkForUpdates() {
        System.out.println("\nChecking : " + url);
        System.out.println("Strategy : " + strategy.getClass().getSimpleName());

        String currentContent = WebsiteFetcher.fetch(url);

        if (previousContent == null) {
            previousContent = currentContent;
            System.out.println("Result   : Initial snapshot stored.");
            return;
        }

        if (strategy.hasChanged(previousContent, currentContent)) {
            previousContent = currentContent;
            notifyObservers("Change detected at " + url);
        } else {
            System.out.println("Result   : No change detected.");
        }
    }
}
