package de.frankfurt_uas.websitemonitor.domain.strategy;

import de.frankfurt_uas.websitemonitor.domain.ComparisonStrategy;

public class HtmlContentStrategy implements ComparisonStrategy {

    @Override
    public boolean hasChanged(String previousContent, String currentContent) {
        boolean changed = !previousContent.equals(currentContent);

        System.out.println("  [HtmlContentStrategy]  HTML identical: " + !changed);

        return changed;
    }
}
