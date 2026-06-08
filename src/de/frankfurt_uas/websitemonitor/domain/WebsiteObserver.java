package de.frankfurt_uas.websitemonitor.domain;

public interface WebsiteObserver {
    void update(String url, String message);
}
