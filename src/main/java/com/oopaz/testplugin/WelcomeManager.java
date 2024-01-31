package com.oopaz.testplugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;

public class WelcomeManager {
    private final List<UUID> playerCache = new ArrayList<>();
    private final FileConfiguration fileConfiguration;

    public WelcomeManager(FileConfiguration fileConfiguration) {
        this.fileConfiguration = fileConfiguration;
    }

    public void addPlayer(UUID uuid) {
        this.playerCache.add(uuid);
        fileConfiguration.set("playerJoined." + uuid.toString(), true);
        TestPlugin.getInstance().saveConfig();
    }

    public boolean playerJoined(UUID uuid) {
        return playerCache.contains(uuid);
    }
}
