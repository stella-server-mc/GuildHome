package com.github.huda0209.guildhome;

import com.github.huda0209.guildhome.command.CommandHandler;
import com.github.huda0209.guildhome.listener.breakBlock;

import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Guildhome extends JavaPlugin implements CommandExecutor{

    final String pluginName = this.getDescription().getName();

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        String[] EnableMessage = {"=============================","Plugin Name : "+pluginName ,"Author : "+ this.getDescription().getAuthors(),"============================="};
        for (String s : EnableMessage) {
            getLogger().info(s);
        }

        getCommand("guildhome").setExecutor(new CommandHandler(this));
        getServer().getPluginManager().registerEvents(new breakBlock(this),this);

    }

    @Override
    public void onDisable() {
        getLogger().info(pluginName+"is disable");
    }


    public void log(String msg){
        getLogger().info(msg);
    }
}
