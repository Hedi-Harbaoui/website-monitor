package de.frankfurt_uas.websitemonitor.controller;

import de.frankfurt_uas.websitemonitor.domain.User;
import de.frankfurt_uas.websitemonitor.domain.Subscription;
import java.util.ArrayList;
import java.util.List;

public class MonitorController {
    private List<User> users; 

    public MonitorController() {
        this.users = new ArrayList<>();
    }

    public void registerNewUser(String url, String frequency, String channel) {
        String newUserId = "USER_" + (users.size() + 1); 
        User newUser = new User(newUserId, channel);
        
        Subscription sub = new Subscription(url, frequency);
        newUser.addSubscription(sub);
        
        users.add(newUser);
        System.out.println("-> Registered " + newUserId + " with Subscription ID: " + sub.getSubscriptionId());
    }

    public void modifySubscription(String subscriptionId, String newFrequency) {
        for (User user : users) {
            for (Subscription sub : user.getSubscriptions()) {
                if (sub.getSubscriptionId().equals(subscriptionId)) {
                    sub.setFrequency(newFrequency);
                    System.out.println("-> Updated " + subscriptionId + " to: " + newFrequency);
                    return;
                }
            }
        }
    }

    public void cancelSubscription(String subscriptionId) {
        for (User user : users) {
            Subscription target = null;
            for (Subscription sub : user.getSubscriptions()) {
                if (sub.getSubscriptionId().equals(subscriptionId)) {
                    target = sub;
                    break;
                }
            }
            if (target != null) {
                user.getSubscriptions().remove(target);
                System.out.println("-> Canceled " + subscriptionId);
                return;
            }
        }
    }

    public void checkAll() {
        System.out.println("\n--- [checkAll() Initiated] ---");
        for (User user : users) {
            for (Subscription sub : user.getSubscriptions()) {
                sub.checkForUpdates(user);
            }
        }
        System.out.println("-----------------------------\n");
    }
}