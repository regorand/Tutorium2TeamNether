package game;


import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;

public class EnemyHandler {

    private EntityType[] ENEMIES = {EntityType.ZOMBIE};
    private int NUMBER_ENEMY_TYPES = ENEMIES.length;
    private int MAX_ENEMIES = 1;

    public EnemyHandler(GameWorld gameWorld){


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
        spawnEnemy(gameWorld.getLocInside());
    }

    public void spawnEnemy(Location loc){
        //Random r = new Random();
        //world.spawnEntity(loc, ENEMIES[r.nextInt(NUMBER_ENEMY_TYPES)]);
        gameWorld.world.spawnEntity(loc, EntityType.ZOMBIE);
    }

    public boolean isAllowedEnemy(EntityType type){
        return false;
    }
}
