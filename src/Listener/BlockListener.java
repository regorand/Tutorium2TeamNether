package Listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import resources.Utilities;

/**
 * Created by jan-luca on 02.12.15.
 */
public class BlockListener implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        event.setCancelled(Utilities.isActivateBlockBreakCancel());
    }

}
