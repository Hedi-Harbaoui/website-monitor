package de.frankfurt_uas.websitemonitor.domain;

import de.frankfurt_uas.websitemonitor.infrastructure.Notification;

public class Subscription {
    private static int idCounter = 1; 
    private String subscriptionId;
    private String url;
    private String frequency;

    public Subscription(String url, String frequency) {
        this.subscriptionId = "SUB_" + idCounter++; 
        this.url = url;
        this.frequency = frequency;
    }

    public String getSubscriptionId() { 
        return subscriptionId; 
    }
    
    public void setFrequency(String frequency) { 
        this.frequency = frequency; 
    }

    public void checkForUpdates(User owner) {
        System.out.println("Checking URL: " + url + " (" + frequency + ")");
        
        boolean modificationDetected = true; 
        
        if (modificationDetected) {
            String channel = owner.getCommunicationChannel(); 
            
            Notification notification = new Notification();
            notification.send(channel, "Modification detected at " + url); 
        }
    }
}