package de.frankfurt_uas.websitemonitor.domain.strategy;

import de.frankfurt_uas.websitemonitor.domain.ComparisonStrategy;

public class ContentSizeStrategy implements ComparisonStrategy {

    @Override
    public boolean hasChanged(String previousContent, String currentContent) {
        int previousSize = previousContent.length();
        int currentSize  = currentContent.length();

        System.out.println("  [ContentSizeStrategy] Previous size: " + previousSize
                + "  |  Current size: " + currentSize);

        return previousSize != currentSize;
    }
}
