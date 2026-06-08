package de.frankfurt_uas.websitemonitor.domain;

import de.frankfurt_uas.websitemonitor.infrastructure.Notification;
import java.util.ArrayList;
import java.util.List;

public class User implements WebsiteObserver {
    private String userId;
    private String communicationChannel;
    private List<Subscription> subscriptions;

    public User(String userId, String communicationChannel) {
        this.userId = userId;
        this.communicationChannel = communicationChannel;
        this.subscriptions = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getCommunicationChannel() {
        return communicationChannel;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void addSubscription(Subscription subscription) {
        this.subscriptions.add(subscription);
        subscription.addObserver(this);
    }

    @Override
    public void update(String url, String message) {
        Notification notification = new Notification();
        notification.send(communicationChannel, message);
    }
}