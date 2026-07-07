package de.frankfurt_uas.websitemonitor.domain.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContentSizeStrategyTest {

    private final ContentSizeStrategy strategy = new ContentSizeStrategy();

    @Test
    void testSameLengthSameContent() {
        String previous = "<html><body>Hello</body></html>";
        String current = "<html><body>Hello</body></html>";
        assertFalse(strategy.hasChanged(previous, current));
    }

    @Test

    void testSameLengthDifferentContent() {
        String previous = "abcdef";
        String current = "fedcba";
        assertFalse(strategy.hasChanged(previous, current));
    }

    @Test
    void testDifferentLengths() {
        String previous = "<html><body>Hello</body></html>";
        String current = "<html><body>Hello World!</body></html>";
        assertTrue(strategy.hasChanged(previous, current));
    }
}