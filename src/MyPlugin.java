import Listener.PlayerServerEvent;
import commands.WorldCommandExecuter;
import org.bukkit.plugin.java.JavaPlugin;



public class MyPlugin extends JavaPlugin{

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerServerEvent(), this);
        WorldCommandExecuter worldCommandExecuter = new WorldCommandExecuter();
        getCommand("baublock").setExecutor(worldCommandExecuter);
        getCommand("flyingspeed").setExecutor(worldCommandExecuter);
        getCommand("walkingspeed").setExecutor(worldCommandExecuter);
        getCommand("spawnskeletonhorse").setExecutor(worldCommandExecuter);
    }
}