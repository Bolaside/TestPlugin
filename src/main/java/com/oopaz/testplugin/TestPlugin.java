package com.oopaz.testplugin;

import com.oopaz.testplugin.commands.TPSCommand;
import com.oopaz.testplugin.listeners.JoinLeaveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getCommandMap().getKnownCommands().remove("tps");
        Bukkit.getCommandMap().getKnownCommands().remove("spigot:tps");
        Bukkit.getCommandMap().getKnownCommands().put("tps", new TPSCommand("tps"));

        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
    }
}
