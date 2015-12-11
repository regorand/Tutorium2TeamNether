package commands;

import main.MyPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.util.Vector;
import resources.Utilities;
import resources.WorldBuilding;

/**
 * Created by jan-luca on 25.11.15.
 */
public class WorldCommandExecuter implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        World world = player.getWorld();

        switch (label) {
            case "baublock":
                String[] dimensions = {"1"};

                if (!(dimensions.length == 0)) {
                    dimensions = args;
                }

                int sizeX, sizeY, sizeZ, amountDimensions = dimensions.length;

                sizeX = Integer.valueOf(dimensions[0]);
                sizeY = amountDimensions > 1 ? Integer.valueOf(dimensions[1]) : sizeX;
                sizeZ = amountDimensions > 2 ? Integer.valueOf(dimensions[2]) : sizeX;

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
                return true;
            case "flyingspeed":

                if (args.length > 0) {
                    player.setFlySpeed(Float.valueOf(args[0]) * (float) 0.2);
                } else {
                    player.setFlySpeed(1 * (float) 0.2);
                }
                sender.sendMessage("success");

                return true;
            case "walkingspeed":

                if (args.length > 0) {
                    player.setWalkSpeed(Float.valueOf(args[0]) * (float) 0.2);
                } else {
                    player.setWalkSpeed(1 * (float) 0.2);
                }
                sender.sendMessage("success");

                return true;
            case "spawnskeletonhorse":

                Horse skelly = (Horse) world.spawnEntity(player.getLocation().add(1, 0, 1), EntityType.HORSE);
                Entity skellyRider = world.spawnEntity(player.getLocation().add(1, 0, 1), EntityType.SKELETON);
                skelly.setVariant(Horse.Variant.SKELETON_HORSE);
                skelly.setPassenger(skellyRider);
                skelly.setTamed(true);


                return true;

            case "toggleblockbreak":
                Utilities.toggleBlockBreak();
                Bukkit.broadcastMessage("Block Breaking jetzt auf " + !Utilities.isActivateBlockBreakCancel());
                return true;

            case "labyrinth":
                Bukkit.broadcastMessage("funktioniert nicht mehr");
                /*
                if (args.length > 0) {
                    if(!(WorldBuilding.baueArena(player, world, args))){
                        Bukkit.broadcastMessage("Fehler");
                    }
                } else {
                    Bukkit.broadcastMessage("Fehler");

                }
                */
                return true;
            case "test":
                //test command für alles mögliche

            default:
                return false;
        }
    }
}
