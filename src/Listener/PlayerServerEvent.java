package Listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by jan-luca on 25.11.15.
 */
public class PlayerServerEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        ItemStack diaStack = new ItemStack(Material.DIAMOND, 64);
        player.getInventory().addItem(diaStack);
        Bukkit.broadcastMessage("test");
    }

}
