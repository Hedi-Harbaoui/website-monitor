package de.frankfurt_uas.websitemonitor.domain.strategy;

import de.frankfurt_uas.websitemonitor.domain.ComparisonStrategy;

public class TextContentStrategy implements ComparisonStrategy {

    @Override
    public boolean hasChanged(String previousContent, String currentContent) {
        String previousText = stripHtml(previousContent);
        String currentText  = stripHtml(currentContent);

        System.out.println("  [TextContentStrategy]  Previous text: \"" + previousText + "\"");
        System.out.println("  [TextContentStrategy]  Current  text: \"" + currentText  + "\"");

        return !previousText.equals(currentText);
    }

    private String stripHtml(String html) {
        return html.replaceAll("<[^>]*>", "").trim();
    }
}
