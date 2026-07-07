package de.frankfurt_uas.websitemonitor.domain.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HtmlContentStrategyTest {
    private final HtmlContentStrategy strategy = new HtmlContentStrategy();

    @Test
    void testIdenticalHtml() {
        String previous = "<html><body><p>Test</p></body></html>";
        String current = "<html><body><p>Test</p></body></html>";
        assertFalse(strategy.hasChanged(previous, current));
    }

    @Test
    void testDifferentAttributes() {
        String previous = "<html><body><p class=\"old\">Breaking News</p></body></html>";
        String current = "<html><body><p class=\"new\">Breaking News</p></body></html>";
        assertTrue(strategy.hasChanged(previous, current));
    }

    @Test
    void testDifferentInnerText() {
        String previous = "<html><body><p>Hello</p></body></html>";
        String current = "<html><body><p>World</p></body></html>";
        assertTrue(strategy.hasChanged(previous, current));
    }
}