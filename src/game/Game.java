package game;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;
import resources.Utilities;

import java.util.ArrayList;

public class Game {
    //Klasse um ein neues Game zu erstellen. Ob static oder nicht muss noch gesehen werden.
    //Wahrscheinlich Instanziiert
    private ArrayList<Player> players;
    private Player creator;
    private GameWorld gameWorld;
    private EnemyHandler enemyHandler;
    private int scheduler;

    public Game (Player creator, World world, int ArenaSize){
        this.creator = creator;
        players = new ArrayList<>();
        gameWorld = new GameWorld(creator.getLocation(), world, ArenaSize);
        enemyHandler = new EnemyHandler(gameWorld);
        addPlayerToGame(creator);
        scheduler =  Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Utilities.getPlugin(), new Runnable() {
            public void run() {
                enemyHandler.updateEnemies();
            }
        }, 100, 10);

    }


    public void addPlayerToGame(Player player){

        if(players.contains(player)){
            Bukkit.broadcastMessage("Spieler ist bereits in diesem Spiel");
            return;
        }
        players.add(player);
        tpPlayerToStart(player);
    }

    public void tpPlayerToStart(Player player){
        player.teleport(gameWorld.getBaseLoc());
    }

    public void GameOver(){
        Bukkit.getScheduler().cancelTask(scheduler);
        Utilities.currentGame = null;
    }


    //getter & setter
    public Player getCreator(){
        return creator;
    }

    public EnemyHandler getEnemyHandler(){
        return enemyHandler;
    }
}
