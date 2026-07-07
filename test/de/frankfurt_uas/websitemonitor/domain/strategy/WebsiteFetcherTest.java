package de.frankfurt_uas.websitemonitor.infrastructure;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WebsiteFetcherTest {

    @Test
    void testFetchKnownUrlFirstTime() {
        String url = "https://example.com";
        String content = WebsiteFetcher.fetch(url);

        assertNotNull(content);
        assertEquals("<html><body><p>Hello World</p></body></html>", content);
    }

    @Test
    void testFetchKnownUrlSecondTime() {
        String url = "https://example.com";
        WebsiteFetcher.fetch(url); // 1st time
        String content2 = WebsiteFetcher.fetch(url); // 2nd time

        assertNotNull(content2);
        assertEquals("<html><body><p>Hello World!</p></body></html>", content2);
    }

    @Test
    void testFetchUnknownUrl() {
        String url = "https://unknown.com";
        String content = WebsiteFetcher.fetch(url);

        assertNotNull(content);
        assertEquals("<html><body><p>Default page</p></body></html>", content);
    }
}