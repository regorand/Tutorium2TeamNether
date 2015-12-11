package Listener;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
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

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player player = event.getPlayer();
            World world = player.getWorld();
            if(player.getItemInHand().equals(new ItemStack(org.bukkit.Material.STICK, 1))){
                Set<Material> airSet = new HashSet<>();
                airSet.add(Material.AIR);
                Block blockInSight = player.getTargetBlock(airSet, 255);
                world.strikeLightning(blockInSight.getLocation());
            }
        }
    }

}
