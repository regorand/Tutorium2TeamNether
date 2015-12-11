package Listener;

import javafx.scene.paint.Material;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import resources.Utilities;


public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player player = event.getPlayer();
            World world = player.getWorld();
            if(player.getItemInHand().equals(new ItemStack(org.bukkit.Material.STICK, 1))){
                Location playerLoc = player.getEyeLocation().add(1, 0, 1);
                Fireball fBall = (Fireball) world.spawnEntity(playerLoc, EntityType.FIREBALL);
                fBall.setVelocity(playerLoc.getDirection().multiply(5));
            }
        }
    }

}
