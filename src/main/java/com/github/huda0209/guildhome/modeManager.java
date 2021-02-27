package com.github.huda0209.guildhome;

import org.bukkit.entity.Player;

import java.util.HashMap;


public class modeManager {

    private static HashMap<Player, Boolean> playerAdminMode = new HashMap<>();

    public static boolean getAdminMode(Player player){
        if(!playerAdminMode.containsKey(player)){
            return false;
        }
        return playerAdminMode.get(player);
    }

    public static void setAdminMode(Player player,Boolean bool){
        if(bool){
            playerAdminMode.put(player,true);
        }else{
            playerAdminMode.remove(player);
        }
    }
}
