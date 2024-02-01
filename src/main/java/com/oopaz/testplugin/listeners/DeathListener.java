package com.oopaz.testplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.oopaz.testplugin.components.Components;

public class DeathListener implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        final Player player = event.getPlayer();
        Bukkit.getConsoleSender().sendMessage(player.getLastDamageCause().getCause().name());

        event.deathMessage(Components.getDeathMessage(event.getPlayer()));
    }
}
