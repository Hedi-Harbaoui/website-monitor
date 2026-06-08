package de.frankfurt_uas.websitemonitor.domain;

public interface ComparisonStrategy {
    boolean hasChanged(String previousContent, String currentContent);
}
