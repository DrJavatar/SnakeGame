package com.game.utilties;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public final class TextUtilities {
    private TextUtilities() {}
    public static double calculateLabelSize(String text, Font font) {
        Label tempLabel = new Label(text);
        tempLabel.setFont(font);
        double labelWidth = tempLabel.prefWidth(-1);
        double labelHeight = tempLabel.prefHeight(labelWidth);
        return Math.max(labelWidth, labelHeight);
    }
}
