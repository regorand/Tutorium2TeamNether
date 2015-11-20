import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;



public class MyPlugin extends JavaPlugin{
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new GameListener(), this);
    }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

        boolean commandByPlayer = false;
        Player player = null;
        World world = null;
        if(sender instanceof Player){
            player = (Player) sender;
            world = player.getWorld();
            commandByPlayer = true;
        }

        switch (label.toLowerCase()){
            case "testyaw":
                if(!commandByPlayer){
                    Bukkit.broadcastMessage("Dieser Befehl ist leider nicht von der Konsole verfügar");
                    return true;
                }

                    Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
                block.setType(Material.DIAMOND_BLOCK);
                sender.sendMessage(String.valueOf(block.getLocation().getX()));
                block = block.getWorld().getBlockAt(block.getLocation().add(1, 0, 0));

                sender.sendMessage(String.valueOf(block.getLocation().getX()));
                block.setType(Material.GOLD_BLOCK);
                return true;

            case "baublock":
                if(!commandByPlayer){
                    Bukkit.broadcastMessage("Dieser Befehl ist leider nicht von der Konsole verfügar");
                    return true;
                }

                if (args.length > 0) {
                    Commands.bauBlock(player, world, args);
                } else {
                    String[] sizeOne = {"1"};
                    Commands.bauBlock(player, world, sizeOne);
                }
                return true;

            case "test":
                Bukkit.broadcastMessage("success");
                return true;

            case "flyingspeed":
                if(!commandByPlayer){
                    Bukkit.broadcastMessage("Dieser Befehl ist leider nicht von der Konsole verfügar");
                    return true;
                }

                if (args.length > 0) {
                    Commands.setPlayerSpeed((Player) sender, Float.valueOf(args[0]), "flying");
                } else {
                    Commands.setPlayerSpeed((Player) sender, 1, "flying");
                }
                sender.sendMessage("success");

                return true;


            case "walkingspeed":
                if(!commandByPlayer){
                    Bukkit.broadcastMessage("Dieser Befehl ist leider nicht von der Konsole verfügar");
                    return true;
                }

                if (args.length > 0) {
                    Commands.setPlayerSpeed(player, Float.valueOf(args[0]), "walking");
                } else {
                    Commands.setPlayerSpeed(player, 1, "walking");
                }
                sender.sendMessage("success");
                return true;

            case "spawnskeletonsorse":
                Horse skelly = (Horse) world.spawnEntity(player.getLocation().add(1, 0, 1), EntityType.HORSE);
                Entity skellyRider = world.spawnEntity(player.getLocation().add(1, 0, 1), EntityType.SKELETON);
                skelly.setVariant(Horse.Variant.SKELETON_HORSE);
                skelly.setPassenger(skellyRider);
                skelly.setTamed(true);
                return true;

            default:
                return false;
        }
    }





    public static class Commands{

        public static void bauBlock(Player player, World world, String[] args){
            int sizeX, sizeY, sizeZ, amountArgs = args.length;

            sizeX = Integer.valueOf(args[0]);
            sizeY = amountArgs > 1 ? Integer.valueOf(args[1]) : sizeX;
            sizeZ = amountArgs > 2 ? Integer.valueOf(args[2]) : sizeX;

            int xPos = player.getLocation().getBlockX();
            int yPos = player.getLocation().getBlockY();
            int zPos = player.getLocation().getBlockZ();

            Block blockToChange;

            for (int i = 0; i < sizeX; i++) {
                for (int j = 0; j < sizeY; j++) {
                    for (int k = 0; k < sizeZ; k++) {
                        blockToChange = world.getBlockAt(xPos + 3 + i, yPos + 3 + j, zPos + 3 + k);
                        blockToChange.setType(Material.STONE);
                    }
                }
            }

        }

        public static void setPlayerSpeed(Player player, float speed, String mode) {
            if (mode.equalsIgnoreCase("flying")) {
                player.setFlySpeed(speed * (float) 0.2);
            } else if (mode.equalsIgnoreCase("walking")) {
                player.setWalkSpeed(speed * (float) 0.2);
            }

        }


    }
}