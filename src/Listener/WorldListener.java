package Listener;

import game.EnemyHandler;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import resources.Utilities;

import javax.rmi.CORBA.Util;

public class WorldListener implements Listener {

    @EventHandler
    public void onSpawn(EntitySpawnEvent event){
        /*
        if(!(event.getEntity() instanceof Zombie)){
            Location loc = event.getLocation();
            EnemyHandler.spawnEnemy(loc.getWorld(), loc);
            event.setCancelled(true);
        }
        */
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event){
        EnemyHandler enemyHandler = Utilities.currentGame.getEnemyHandler();
        Entity enemy = event.getEntity();
        if(enemyHandler.isEnemy(enemy)){
            enemyHandler.removeEnemy(enemy);
        }

    }
}
