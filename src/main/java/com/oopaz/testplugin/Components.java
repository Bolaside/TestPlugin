package com.oopaz.testplugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;

public class Components {
    private static TextComponent getMessagePrefix(String symbol, TextColor textColor) {
        return Component.text("<")
                .color(NamedTextColor.DARK_GRAY)
                .append(Component.text(symbol).color(textColor))
                .append(Component.text(">").color(NamedTextColor.DARK_GRAY));
    }

    private static TextComponent getPluginPrefix() {
        return Component.text("[")
                .color(NamedTextColor.DARK_GRAY)
                .append(Component.text("TP").color(TextColor.color(208, 124, 68)))
                .append(Component.text("] ").color(NamedTextColor.DARK_GRAY));
    }

    public static TextComponent getJoinMessage(Player player) {
        return getMessagePrefix("+", NamedTextColor.GREEN)
                .append(Component.text(" " + player.getName()).color(NamedTextColor.GRAY));
    }

    public static TextComponent getWelcomeMessage(Player player) {
        return getMessagePrefix("!", NamedTextColor.LIGHT_PURPLE)
                .append(Component.text(" Welcome " + player.getName() + " to the server!").color(NamedTextColor.GRAY));
    }

    public static TextComponent getLeaveMessage(Player player) {
        return getMessagePrefix("-", NamedTextColor.RED)
                .append(Component.text(" " + player.getName()).color(NamedTextColor.GRAY));
    }

    public static TextComponent pluginResponse(String text, NamedTextColor textColor) {
        return getPluginPrefix()
                .append(Component.text(text).color(textColor));
    }

    public static TextComponent pluginResponse(String text) {
        return getPluginPrefix()
                .append(Component.text(text).color(NamedTextColor.GRAY));
    }
}
