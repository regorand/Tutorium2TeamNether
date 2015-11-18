import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Egg;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Door;

import javax.swing.text.html.parser.Entity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameListener implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        event.getPlayer().getInventory().addItem(new ItemStack(event.getBlock().getType(), 1));
        event.getPlayer().getInventory().addItem(new ItemStack(Material.TORCH, 1));
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Egg) {
            event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), (float) 10.0);
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        float rotation = Math.abs(event.getPlayer().getLocation().getYaw());
        Block block = event.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN);

        block = relativeToPlayer(2, true, rotation, block);

        if (block.getType().isSolid()) {
            //block.setType(Material.DIAMOND_BLOCK);

            block.setType(Material.NETHERRACK);
            block.getLocation().add(0, 1, 0).getBlock().setType(Material.FIRE);

        }
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(event.getPlayer().getInventory().getItemInHand().getType().equals(Material.STICK)){
                event.getPlayer().getWorld().strikeLightning(event.getPlayer().getTargetBlock((Set<Material>) null, 200).getLocation());
            }

        }
    }







    public Block relativeToPlayer(final int distance, final boolean behind, final float yaw, final Block block){
        float rotation = Math.abs(yaw);

        Block returnBlock = block;

        if(behind){
            if(rotation>=292.5 || rotation<67.5){
                returnBlock = returnBlock.getWorld().getBlockAt(returnBlock.getLocation().add(0, 0, -distance));
            }else if (112.5 <= rotation && rotation < 247.5) {
                returnBlock = returnBlock.getWorld().getBlockAt(returnBlock.getLocation().add(0, 0, distance));
            }
            if(22.5 <= rotation && rotation < 157.5){
                returnBlock = returnBlock.getWorld().getBlockAt(returnBlock.getLocation().add(-distance, 0, 0));
            }else if(202.5 <= rotation && rotation < 337.5){
                returnBlock = returnBlock.getWorld().getBlockAt(returnBlock.getLocation().add(distance, 0, 0));
            }
        }else{
            if(rotation>=292.5 || rotation<67.5){
                returnBlock = returnBlock.getWorld().getBlockAt(returnBlock.getLocation().add(0, 0, distance));
            }else if (112.5 <= rotation && rotation < 247.5) {
                returnBlock = returnBlock.getWorld().getBlockAt(returnBlock.getLocation().add(0, 0, -distance));
            }
            if(22.5 <= rotation && rotation < 157.5){
                returnBlock = returnBlock.getWorld().getBlockAt(returnBlock.getLocation().add(distance, 0, 0));
            }else if(202.5 <= rotation && rotation < 337.5){
                returnBlock = returnBlock.getWorld().getBlockAt(returnBlock.getLocation().add(-distance, 0, 0));
            }
        }
        return returnBlock;
    }
}
