import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import javax.swing.text.html.parser.Entity;


public class MyPlugin extends JavaPlugin{
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new GameListener(), this);
    }

    @Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {

        if(label.equalsIgnoreCase("testYaw")){

            Player player = (Player) sender;
            Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
            block.setType(Material.DIAMOND_BLOCK);
            sender.sendMessage(String.valueOf(block.getLocation().getX()));
            block = block.getWorld().getBlockAt(block.getLocation().add(1, 0, 0));

            sender.sendMessage(String.valueOf(block.getLocation().getX()));
            block.setType(Material.GOLD_BLOCK);

        }


        if (label.equalsIgnoreCase("bauBlock")) {

            if (sender instanceof Player) {
                if (args.length > 0) {
                    bauBlock((Player) sender, Integer.valueOf(args[0]));
                } else {
                    bauBlock((Player) sender, 1);
                }

            } else {
                sender.sendMessage("dieser Befehl ist nicht aus der Konsole verfügbar");
            }


            return true;

        } else if (label.equalsIgnoreCase("flyingSpeed")) {

            if (sender instanceof Player) {
                if (args.length > 0) {
                    setPlayerSpeed((Player) sender, Float.valueOf(args[0]), "flying");
                } else {
                    setPlayerSpeed((Player) sender, 1, "flying");
                }
                sender.sendMessage("success");

            } else {
                sender.sendMessage("dieser Befehl ist nicht aus der Konsole verfügbar");
            }


            return true;

        }else if (label.equalsIgnoreCase("spawnSkeletonHorse")){

            Player player = (Player) sender;
            World world = player.getWorld();
            //world.spawnEntity(player.getLocation(), new EntityType();

            return true;
        }else {
            if (label.equalsIgnoreCase("walkingSpeed")) {

                if (sender instanceof Player) {

                    if (args.length > 0) {
                        setPlayerSpeed((Player) sender, Float.valueOf(args[0]), "walking");
                    } else {
                        setPlayerSpeed((Player) sender, 1, "walking");
                    }
                    sender.sendMessage("success");
                } else {
                    sender.sendMessage("dieser Befehl ist nicht aus der Konsole verfügbar");
                }

                return true;
            } else {
                return false;
            }
        }
    }

    void bauBlock(final Player player, int cubeSize) {
        World world = player.getWorld();

        int xPos = player.getLocation().getBlockX();
        int yPos = player.getLocation().getBlockY();
        int zPos = player.getLocation().getBlockZ();

        player.chat("10/10");

        Block blockToChange;

        for (int i = 0; i < cubeSize; i++) {
            for (int j = 0; j < cubeSize; j++) {
                for (int k = 0; k < cubeSize; k++) {
                    blockToChange = world.getBlockAt(xPos + 3 + i, yPos + 3 + j, zPos + 3 + k);
                    blockToChange.setType(Material.STONE);
                }
            }
        }
    }

    void setPlayerSpeed(Player player, float speed, String mode) {
        if (mode.equalsIgnoreCase("flying")) {
            player.setFlySpeed(speed * (float) 0.2);
        } else if (mode.equalsIgnoreCase("walking")) {
            player.setWalkSpeed(speed * (float) 0.2);
        }

    }


}