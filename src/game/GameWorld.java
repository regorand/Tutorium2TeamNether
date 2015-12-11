package game;


import org.bukkit.Location;
import org.bukkit.World;
import resources.WorldBuilding;

public class GameWorld {
    //stellt das Spielfeld dar.
    //Sollte vermmutlich Instanziiert werden, da die Welt jedes Spiel wechselnd ist
    private Location baseLoc;
    private int size;
    World world;
    private int range;

    public GameWorld(Location location, World world, int size){
        this.baseLoc = location;
        this.world = world;
        this.size = size;
        WorldBuilding.baueArena(location, world, size);
        range = 30 + 10 *  size;
    }

    public Location getBaseLoc(){
        return baseLoc;
    }

    public Location getLocInside(){
        return baseLoc; //temp
    }
}
