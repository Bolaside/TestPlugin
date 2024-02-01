package com.oopaz.testplugin.components;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;

public class Components {
    private static final MessagePrefix pluginPrefix = new MessagePrefix("[", "]", "TP", TextColor.color(248, 170, 87));

    private static final MessagePrefix joinPrefix = new MessagePrefix("<", ">", "+", NamedTextColor.GREEN);
    private static final MessagePrefix leavePrefix = new MessagePrefix("<", ">", "-", NamedTextColor.RED);
    private static final MessagePrefix welcomePrefix = new MessagePrefix("<", ">", "++", NamedTextColor.LIGHT_PURPLE);
    private static final MessagePrefix deathPrefix = new MessagePrefix("<", ">", "☠️");

    private static TextComponent prefixedMessage(String text, TextColor textColor, MessagePrefix prefix) {
        return prefix.getComponent()
            .append(Component.text(text).color(textColor));
    }

    private static TextComponent prefixedMessage(String text, MessagePrefix prefix) {
        return prefix.getComponent()
            .append(Component.text(text).color(NamedTextColor.GRAY));
    }

    private static TextComponent prefixedMessage(TextComponent component, MessagePrefix prefix) {
        return prefix.getComponent().append(component);
    }

    // I am 1,000,000% sure there exists a better way to do all this.
    public static TextComponent getJoinMessage(Player player) {
        return prefixedMessage(player.getName(), joinPrefix);
    }

    public static TextComponent getWelcomeMessage(Player player) {
        return prefixedMessage(player.getName(), welcomePrefix);
    }

    public static TextComponent getLeaveMessage(Player player) {
        return prefixedMessage(player.getName(), leavePrefix);
    }

    public static TextComponent getDeathMessage(Player player) {
        return prefixedMessage(player.getName() + " has died of death", deathPrefix);
    }

    public static TextComponent pluginResponse(String text, NamedTextColor textColor) {
        return prefixedMessage(Component.text(text).color(textColor), pluginPrefix);
    }
    
    public static TextComponent pluginResponse(String text) {
        return prefixedMessage(text, pluginPrefix);
    }
}
