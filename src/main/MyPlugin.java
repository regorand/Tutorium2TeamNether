package main;

import Listener.BlockListener;
import Listener.PlayerListener;
import Listener.PlayerServerEvent;
import commands.WorldCommandExecuter;
import org.bukkit.plugin.java.JavaPlugin;


public class MyPlugin extends JavaPlugin {

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BlockListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerServerEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        WorldCommandExecuter worldCommandExecuter = new WorldCommandExecuter();
        getCommand("baublock").setExecutor(worldCommandExecuter);
        getCommand("flyingspeed").setExecutor(worldCommandExecuter);
        getCommand("walkingspeed").setExecutor(worldCommandExecuter);
        getCommand("spawnskeletonhorse").setExecutor(worldCommandExecuter);
        getCommand("toggleblockbreak").setExecutor(worldCommandExecuter);
        getCommand("labyrinth").setExecutor(worldCommandExecuter);
    }
}