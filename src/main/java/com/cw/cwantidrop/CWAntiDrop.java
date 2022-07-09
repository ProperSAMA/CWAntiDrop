package com.cw.cwantidrop;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class CWAntiDrop extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this,this);

        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists()) {
            getLogger().info("未找到config.yml, 创建一个新的!");
            saveDefaultConfig();
        } else {
            getLogger().info("发现config.yml, 读取!");
        }

        getLogger().info("CWAntiDrop 已载入!");
    }

    @Override
    public void onDisable() {}

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event){
        String message = getConfig().getString("message");
        event.getPlayer().sendMessage(message);
        event.setCancelled(true);
    }
}

