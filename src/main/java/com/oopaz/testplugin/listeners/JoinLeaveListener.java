package com.oopaz.testplugin.listeners;

import com.oopaz.testplugin.Components;
import com.oopaz.testplugin.TestPlugin;
import com.oopaz.testplugin.WelcomeManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {
    private static final WelcomeManager welcomeManager = TestPlugin.getInstance().getWelcomeManager();

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();

        if (!welcomeManager.playerJoined(player.getUniqueId())) {
            welcomeManager.addPlayer(player.getUniqueId());
            event.joinMessage(Components.getWelcomeMessage(player));
            return;
        }

        event.joinMessage(Components.getJoinMessage(player));
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        event.quitMessage(Components.getLeaveMessage(event.getPlayer()));
    }
}
