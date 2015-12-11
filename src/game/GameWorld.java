package game;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import resources.WorldBuilding;

import java.util.Random;

public class GameWorld {

    private Location baseLoc;
    private Location lowestLoc;
    private int size;
    World world;
    private int range;


    public GameWorld(Location location, World world, int size){
        this.baseLoc = location;
        this.world = world;
        this.size = size;
        WorldBuilding.baueArena(location, world, size);
        range = 30 + 10 *  size;
        this.lowestLoc = this.baseLoc.add(-range/2, -1, -range/2);
    }

    public Location getBaseLoc(){
        return baseLoc;
    }

    public Location getLocInside(){
        double posX = 0, posY = baseLoc.getY(), posZ = 0;
        do{
            Random r = new Random();
            posX =  this.lowestLoc.getX() + r.nextInt(range);
            posZ =  this.lowestLoc.getZ() + r.nextInt(range);
        }while(world.getBlockAt((int)posX, (int) posY, (int) posZ).getType().equals(Material.AIR));
        return new Location(world, posX, posY, posZ);
    }
}
