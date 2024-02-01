package com.oopaz.testplugin.components;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;

public class MessagePrefix {
    public final String leftBracket;
    public final String rightBracket;
    public final String symbol;
    public final TextColor symbolColor;

    public MessagePrefix(String leftBracket, String rightBracket, String symbol, TextColor symbolColor) {
        this.leftBracket = leftBracket;
        this.rightBracket = rightBracket;
        this.symbol = symbol;
        this.symbolColor = symbolColor;
    }

    public MessagePrefix(String leftBracket, String rightBracket, String symbol) {
        this.leftBracket = leftBracket;
        this.rightBracket = rightBracket;
        this.symbol = symbol;
        this.symbolColor = NamedTextColor.GRAY;
    }

    public TextComponent getComponent() {
        return Component.text()
            .append(Component.text(leftBracket).color(NamedTextColor.DARK_GRAY))
            .append(Component.text(symbol).color(symbolColor))
            .append(Component.text(rightBracket + " ").color(NamedTextColor.DARK_GRAY))
            .build();
    }
}
