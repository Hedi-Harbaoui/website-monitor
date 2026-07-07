package de.frankfurt_uas.websitemonitor.domain.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextContentStrategyTest {
    private final TextContentStrategy strategy = new TextContentStrategy();

    @Test
    void testIdenticalTextAndTags() {
        String previous = "<html><body><p>Documentation</p></body></html>";
        String current = "<html><body><p>Documentation</p></body></html>";
        assertFalse(strategy.hasChanged(previous, current));
    }

    @Test
    void testIdenticalTextDifferentTags() {
        String previous = "<html>\n  <body>\n    <p>Documentation</p>\n  </body>\n</html>";
        String current = "<html><body><p>Documentation</p></body></html>";
        assertFalse(strategy.hasChanged(previous, current));
    }

    @Test
    void testDifferentText() {
        String previous = "<html><body><p>Version 1.0</p></body></html>";
        String current = "<html><body><p>Version 2.0</p></body></html>";
        assertTrue(strategy.hasChanged(previous, current));
    }
}