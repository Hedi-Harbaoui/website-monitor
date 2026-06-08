package de.frankfurt_uas.websitemonitor.infrastructure;

import java.util.HashMap;
import java.util.Map;

public class WebsiteFetcher {

    private static final Map<String, String[]> PAGES = new HashMap<>();

    static {
        PAGES.put("https://example.com", new String[]{
            "<html><body><p>Hello World</p></body></html>",
            "<html><body><p>Hello World!</p></body></html>"
        });

        PAGES.put("https://news.com", new String[]{
            "<html><body><p class=\"old\">Breaking News</p></body></html>",
            "<html><body><p class=\"new\">Breaking News</p></body></html>"
        });

        PAGES.put("https://docs.com", new String[]{
            "<html>\n  <body>\n    <p>Documentation</p>\n  </body>\n</html>",
            "<html><body><p>Documentation</p></body></html>"
        });
    }

    private static final Map<String, Integer> fetchCounts = new HashMap<>();

    public static String fetch(String url) {
        int count = fetchCounts.getOrDefault(url, 0);
        fetchCounts.put(url, count + 1);

        String[] versions = PAGES.getOrDefault(url, new String[]{
            "<html><body><p>Default page</p></body></html>",
            "<html><body><p>Default page updated</p></body></html>"
        });

        return (count == 0) ? versions[0] : versions[1];
    }
}
