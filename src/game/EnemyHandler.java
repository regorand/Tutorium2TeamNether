package game;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Random;

public class EnemyHandler {

    private EntityType[] ENEMIE_TYPES = {EntityType.ZOMBIE, EntityType.SKELETON, EntityType.SPIDER};
    private int NUMBER_ENEMY_TYPES = ENEMIE_TYPES.length;
    private int MAX_ENEMIES = 10;

    public EnemyHandler(GameWorld gameWorld){
        this.gameWorld = gameWorld;
        enemies = new ArrayList<>();
    }

    private ArrayList<Entity> enemies;
    private GameWorld gameWorld;


    public boolean isEnemy(Entity entity){
        return enemies.contains(entity);
    }

    public void removeEnemy(Entity entity){
        enemies.remove(entity);
    }

    public void updateEnemies(){
        if(enemies.size() >= MAX_ENEMIES){
            return;
        }
        Location loc = gameWorld.getLocInside();
        Bukkit.broadcastMessage("shouldUpdate");
        spawnEnemy(loc);
    }

    private void spawnEnemy(Location loc){
        Random r = new Random();
        enemies.add(gameWorld.world.spawnEntity(loc, ENEMIE_TYPES[r.nextInt(NUMBER_ENEMY_TYPES)]));
    }

    public boolean isAllowedEnemy(EntityType type){
        return false;
    }
}
