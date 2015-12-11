package resources;


import game.Game;
import org.bukkit.block.Block;
import org.bukkit.entity.EnderDragon;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public abstract class Utilities {

    private static JavaPlugin plugin;

    public static Game currentGame;

    private static boolean activateBlockBreakCancel = false;

    private static List<Block> destroyableBlocks = new ArrayList<Block>();

    public static void addToDestroyableBlocks(Block block){
        destroyableBlocks.add(block);
    }

    public static boolean isDestroyable (Block block){
        return destroyableBlocks.contains(block);
    }

    public static void removeBlockFromDestroyable (Block block){
        if(destroyableBlocks.contains(block)){
            destroyableBlocks.remove(destroyableBlocks.indexOf(block));
        }
    }

    public static void toggleBlockBreak() {
        activateBlockBreakCancel = !activateBlockBreakCancel;
    }

    public static boolean isActivateBlockBreakCancel() {
        return activateBlockBreakCancel;
    }




    public static Block relativeToPlayer(final int distance, final boolean behind, final float yaw, final Block block){
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


    //getter und setter

    static public JavaPlugin getPlugin(){
        return plugin;
    }

    static public void setPlugin(JavaPlugin pluginInstance){
        plugin = pluginInstance;
    }
}
