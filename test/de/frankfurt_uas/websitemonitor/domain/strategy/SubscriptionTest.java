package de.frankfurt_uas.websitemonitor.domain;

import de.frankfurt_uas.websitemonitor.domain.strategy.ContentSizeStrategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SubscriptionTest {

    @Test
    void testValidSubscriptionCreation() {
        ComparisonStrategy strategy = new ContentSizeStrategy();


        Subscription subscription = new Subscription("https://docs.com", "Daily", strategy);

        assertNotNull(subscription.getSubscriptionId(), "Subscription ID should be generated.");
        assertTrue(subscription.getSubscriptionId().startsWith("SUB_"), "ID should start with SUB_");
    }

    @Test
    void testAddAndNotifyObserver() {
        ComparisonStrategy strategy = new ContentSizeStrategy();


        Subscription subscription = new Subscription("https://docs.com", "Daily", strategy);
        User user = new User("USER_1", "Email");

        subscription.addObserver(user);
        assertDoesNotThrow(subscription::checkForUpdates);
    }
}