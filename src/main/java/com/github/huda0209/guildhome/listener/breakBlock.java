package com.github.huda0209.guildhome.listener;

import com.github.huda0209.guildhome.Guildhome;
import com.github.huda0209.guildhome.modeManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.List;

public class breakBlock implements Listener {

    private final Guildhome plugin;
    public breakBlock(Guildhome pl) {
        this.plugin = pl;
    }

    @EventHandler
    public void BlockBreak (BlockBreakEvent event){
        Player player = event.getPlayer();
        String block = event.getBlock().getBlockData().getMaterial().toString();
        List<String> BreakBlock = plugin.getConfig().getStringList("BreakBlock");

        if(!player.hasPermission("GuildHome.AdminMode") && modeManager.getAdminMode(player)){
            modeManager.setAdminMode(player,false);
            player.sendMessage("§9[" + plugin.getDescription().getName() + "]§c You didn't have permission. So admin mode was disable.");
        }

        if(modeManager.getAdminMode(player)) return;

        if(BreakBlock.contains(block)){
            event.setCancelled(true);
            player.sendMessage("§cHey! This block can't break!");
        }

    }
}