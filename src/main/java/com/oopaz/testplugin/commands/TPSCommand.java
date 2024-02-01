package com.oopaz.testplugin.commands;

import com.oopaz.testplugin.components.Components;
import com.oopaz.testplugin.utils.Rounder;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class TPSCommand extends Command {
    public TPSCommand(@NotNull String name) {
        super(name);
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String label, @NotNull String[] args) {
        final double ticksPerSecond = Rounder.round(sender.getServer().getTPS()[0], 5);
        final TextComponent response = Components.pluginResponse("Server TPS is " + ticksPerSecond);

        sender.sendMessage(response);
        return true;
    }
}
