package game;


import org.bukkit.entity.Player;

public class GamePlayer {
    //Klasse für die Spieler des games. Nicht zu verwechseln mit der Player Klasse aus Bukkit
    //Diese wird nur für Spieler die tatsächlich im Spiel sind benutzt
    //Instanzen lassen sich erstellen, damit mehrere Spieler möglich sind

    final private Player player;
    public GamePlayer (Player player){
        this.player = player;
    }

    //Inventory Handling

}
