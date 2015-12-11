package commands;

import game.Game;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import resources.Utilities;
import resources.WorldBuilding;

/**
 * Created by jan-luca on 25.11.15.
 */
public class PlayerCommandExecuter implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        switch (label) {
            case "startnewgame":
                int sizeArena;
                if(args.length == 0){
                    sizeArena = 1;
                    Bukkit.broadcastMessage("kein guter Parameter, größe auf " + sizeArena + " gesetzt");
                }else{
                    try{
                        sizeArena = Integer.valueOf(args[0]);
                    }catch (NumberFormatException e){
                        sizeArena = 1;
                        Bukkit.broadcastMessage("kein guter Parameter, größe auf " + sizeArena + " gesetzt");
                    }
                }

                Player player = (Player) sender;
                World world = player.getWorld();
                Utilities.currentGame = new Game(player, world, sizeArena);
            return true;

            case "joingame":
                if(Utilities.currentGame != null){
                    Utilities.currentGame.addPlayerToGame((Player) sender);
                }else{
                    Bukkit.broadcastMessage("Kein Spiel vorhanden\nErstelle ein Spiel mit /startnewgame");
                }
                return true;

            case "endgame":
                if(!sender.getName().equalsIgnoreCase("thecodX") &&  !sender.getName().equalsIgnoreCase(Utilities.currentGame.getCreator().getName())){
                    Bukkit.broadcastMessage("keine rechte");
                    return false;
                }
                Utilities.currentGame.GameOver();
                Bukkit.broadcastMessage("game ended");
        }



        return false;
    }
}
