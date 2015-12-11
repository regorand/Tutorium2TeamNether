package main;

import Listener.BlockListener;
import Listener.PlayerListener;
import Listener.PlayerServerEvent;
import Listener.WorldListener;
import commands.PlayerCommandExecuter;
import commands.WorldCommandExecuter;
import org.bukkit.plugin.java.JavaPlugin;
import resources.Utilities;


public class MyPlugin extends JavaPlugin {

    public void onEnable() {
        Utilities.setPlugin(this);

        getServer().getPluginManager().registerEvents(new BlockListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerServerEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getServer().getPluginManager().registerEvents(new WorldListener(), this);

        WorldCommandExecuter worldCommandExecuter = new WorldCommandExecuter();
        PlayerCommandExecuter playerCommandExecuter = new PlayerCommandExecuter();
        
        getCommand("baublock").setExecutor(worldCommandExecuter);
        getCommand("flyingspeed").setExecutor(worldCommandExecuter);
        getCommand("walkingspeed").setExecutor(worldCommandExecuter);
        getCommand("spawnskeletonhorse").setExecutor(worldCommandExecuter);
        getCommand("toggleblockbreak").setExecutor(worldCommandExecuter);
        getCommand("labyrinth").setExecutor(worldCommandExecuter);
        getCommand("test").setExecutor(worldCommandExecuter);
        getCommand("startnewgame").setExecutor(playerCommandExecuter);
        getCommand("joingame").setExecutor(playerCommandExecuter);
        getCommand("endGame").setExecutor(playerCommandExecuter);
    }
}