package com.github.huda0209.guildhome.command;

import com.github.huda0209.guildhome.Guildhome;
import com.github.huda0209.guildhome.modeManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class CommandHandler implements CommandExecutor {

    private final Guildhome plugin;
    public CommandHandler(Guildhome pl) {
        this.plugin = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;

        switch (args[0].toLowerCase(Locale.ROOT)){
            case "mode" :
                if(!sender.hasPermission("GuildHome.AdminMode")){
                    player.sendMessage("§9[" + plugin.getDescription().getName() + "]§c You don't have permission!");
                    return true;
                }
                modeChanger(player);
                break;

            case "reload":
                if(!sender.hasPermission("GuildHome.Reload")){
                    player.sendMessage("§a[" + plugin.getDescription().getName() + "]§c You don't have permission!");
                    return true;
                }
                try {
                    plugin.reloadConfig();
                    player.sendMessage("§9[" + plugin.getDescription().getName() + "]§a Reload the config file.");
                }catch(Exception e){
                    player.sendMessage("§9[" + plugin.getDescription().getName() + "]§c While reload the config file, occurred error. Please check console.");
                    plugin.log(e.toString());
                }
                break;

            default:
                player.sendMessage("§9[" + plugin.getDescription().getName() + "]§c Unknown command.");
                break;
        }
        return true;
    }


    private void modeChanger(Player player){
        if(!modeManager.getAdminMode(player)){
            modeManager.setAdminMode(player,true);
            player.sendMessage("§9[" + plugin.getDescription().getName() + "]§a admin mode was enable.");
        }else{
            modeManager.setAdminMode(player,false);
            player.sendMessage("§9[" + plugin.getDescription().getName() + "]§c admin mode was disable.");
        }
    }
}
