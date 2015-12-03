package Listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import resources.Utilities;

public class BlockListener implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if(Utilities.isActivateBlockBreakCancel()&& !Utilities.isDestroyable(event.getBlock())){
            //
            event.setCancelled(true);
        }else{
            Utilities.removeBlockFromDestroyable(event.getBlock());
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        Utilities.addToDestroyableBlocks(event.getBlock());
    }
}
