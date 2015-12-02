package resources;


import org.bukkit.block.Block;

public class Utilities {

    private static boolean activateBlockBreakCancel = false;

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
}