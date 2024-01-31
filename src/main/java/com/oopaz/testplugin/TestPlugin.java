package com.oopaz.testplugin;

import com.oopaz.testplugin.commands.TPSCommand;
import com.oopaz.testplugin.listeners.JoinLeaveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {
    private static TestPlugin instance;
    private WelcomeManager welcomeManager;

    @Override
    public void onEnable() {
        instance = this;

        this.prepareConfig();
        this.welcomeManager = new WelcomeManager(getConfig());

        Bukkit.getCommandMap().getKnownCommands().remove("tps");
        Bukkit.getCommandMap().getKnownCommands().remove("spigot:tps");
        Bukkit.getCommandMap().getKnownCommands().put("tps", new TPSCommand("tps"));

        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
    }

    public static TestPlugin getInstance() {
        return instance;
    }

    public WelcomeManager getWelcomeManager() {
        return welcomeManager;
    }

    private void prepareConfig() {
        saveDefaultConfig();
    }
}
