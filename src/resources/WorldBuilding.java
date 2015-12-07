package resources;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class WorldBuilding extends JavaPlugin {
    static final int SIZEOFCUBESMALL = 10;
    static final int SIZEOFCUBESTART = 30;
    static final int HEIGHTOFCUBE = 5;



    public static boolean baueArena(Player player, World world, String[] args){
        int anzahl;
        try{
            anzahl = Integer.valueOf(args[0]);
        }catch (NumberFormatException e){
            return false;
        }

        baueOffenenKastenUmPlayer(player, world);
        baueOffenenKastenRechtsVomKastenUmPlayer(player, world, anzahl);
        baueOffenenKastenLinksVomKastenUmPlayer(player, world, anzahl);
        baueOffenenKastenUEberKastenUmPlayer(player, world, anzahl);
        baueOffenenKastenUnterKastenUmPlayer(player, world, anzahl);
        return true;
    }

    static void baueOffenenKastenUmPlayer(Player player, World world) {

        int xPositionArena = player.getLocation().getBlockX()-(SIZEOFCUBESTART/2);
        int yPositionArena = player.getLocation().getBlockY()-2;
        int zPositionArena = player.getLocation().getBlockZ()-(SIZEOFCUBESTART/2);

        Block blockPlayerArena;

        for (int i = 1; i <= SIZEOFCUBESTART; i++) {
            for (int j = 1; j <= SIZEOFCUBESTART; j++) {
                for (int k = 1; k <= HEIGHTOFCUBE; k++) {
                    if (baueKastenMitTuer(i, j, k, SIZEOFCUBESTART)) {
                        blockPlayerArena = world.getBlockAt((xPositionArena + i), (yPositionArena + k), (zPositionArena + j));
                        blockPlayerArena.setType(Material.WOOD);
                    }
                }
            }
        }
    }

    static void baueOffenenKastenRechtsVomKastenUmPlayer(Player player, World world, int anzahl) {


        for (int wieOftRechts = 0; wieOftRechts < anzahl; wieOftRechts++) {
            for (int wieOftNachOben = 0; wieOftNachOben < anzahl; wieOftNachOben++) {
                int xPositionArena = player.getLocation().getBlockX() - (SIZEOFCUBESTART / 2) + (SIZEOFCUBESMALL * wieOftNachOben);
                int yPositionArena = player.getLocation().getBlockY() - 2;
                int zPositionArena = player.getLocation().getBlockZ() + (SIZEOFCUBESTART / 2) + (SIZEOFCUBESMALL * wieOftRechts);

                Block blockPlayerArena;

                for (int i = 1; i <= SIZEOFCUBESMALL; i++) {
                    for (int j = 1; j <= SIZEOFCUBESMALL; j++) {
                        for (int k = 1; k <= HEIGHTOFCUBE; k++) {
                            if (baueKastenMitTuer(i, j, k, SIZEOFCUBESMALL)) {
                                blockPlayerArena = world.getBlockAt((xPositionArena + i), (yPositionArena + k), (zPositionArena + j));
                                blockPlayerArena.setType(Material.SANDSTONE);
                            }
                        }
                    }
                }
            }
        }
    }

    static void baueOffenenKastenUEberKastenUmPlayer(Player player, World world, int anzahl) {


        for (int wieOftRechts = 0; wieOftRechts < anzahl; wieOftRechts++) {
            for (int wieOftOben = 0; wieOftOben < anzahl; wieOftOben++) {
                int xPositionArena = player.getLocation().getBlockX() + (SIZEOFCUBESTART / 2) + (SIZEOFCUBESMALL * wieOftOben);
                int yPositionArena = player.getLocation().getBlockY() - 2;
                int zPositionArena = player.getLocation().getBlockZ() + (SIZEOFCUBESTART / 2 - SIZEOFCUBESMALL) - (SIZEOFCUBESMALL * wieOftRechts);

                Block blockPlayerArena;

                for (int i = 1; i <= SIZEOFCUBESMALL; i++) {
                    for (int j = 1; j <= SIZEOFCUBESMALL; j++) {
                        for (int k = 1; k <= HEIGHTOFCUBE; k++) {
                            if (baueKastenMitTuer(i, j, k, SIZEOFCUBESMALL)) {
                                blockPlayerArena = world.getBlockAt((xPositionArena + i), (yPositionArena + k), (zPositionArena + j));
                                blockPlayerArena.setType(Material.STONE);
                            }
                        }
                    }
                }
            }
        }
    }

    static void baueOffenenKastenLinksVomKastenUmPlayer(Player player, World world, int anzahl) {



        for (int wieOftRechts = 0; wieOftRechts < anzahl; wieOftRechts++) {
            for (int wieOftOben = 0; wieOftOben < anzahl; wieOftOben++) {
                int xPositionArena = player.getLocation().getBlockX() + (SIZEOFCUBESTART / 2 - SIZEOFCUBESMALL) - (SIZEOFCUBESMALL * wieOftOben);
                int yPositionArena = player.getLocation().getBlockY() - 2;
                int zPositionArena = player.getLocation().getBlockZ() - (SIZEOFCUBESTART / 2 + SIZEOFCUBESMALL) - (SIZEOFCUBESMALL * wieOftRechts);

                Block blockPlayerArena;

                for (int i = 1; i <= SIZEOFCUBESMALL; i++) {
                    for (int j = 1; j <= SIZEOFCUBESMALL; j++) {
                        for (int k = 1; k <= HEIGHTOFCUBE; k++) {
                            if (baueKastenMitTuer(i, j, k, SIZEOFCUBESMALL)) {
                                blockPlayerArena = world.getBlockAt((xPositionArena + i), (yPositionArena + k), (zPositionArena + j));
                                blockPlayerArena.setType(Material.BRICK);
                            }
                        }
                    }
                }
            }
        }
    }

    static void baueOffenenKastenUnterKastenUmPlayer(Player player, World world, int anzahl) {


        for (int wieOftRechts = 0; wieOftRechts < anzahl; wieOftRechts++) {
            for (int wieOftOben = 0; wieOftOben < anzahl; wieOftOben++) {
                int xPositionArena = player.getLocation().getBlockX() - (SIZEOFCUBESTART / 2 + SIZEOFCUBESMALL) - (SIZEOFCUBESMALL * wieOftOben);
                int yPositionArena = player.getLocation().getBlockY() - 2;
                int zPositionArena = player.getLocation().getBlockZ() - (SIZEOFCUBESTART / 2) + (SIZEOFCUBESMALL * wieOftRechts);

                Block blockPlayerArena;

                for (int i = 1; i <= SIZEOFCUBESMALL; i++) {
                    for (int j = 1; j <= SIZEOFCUBESMALL; j++) {
                        for (int k = 1; k <= HEIGHTOFCUBE; k++) {
                            if (baueKastenMitTuer(i, j, k, SIZEOFCUBESMALL)) {
                                blockPlayerArena = world.getBlockAt((xPositionArena + i), (yPositionArena + k), (zPositionArena + j));
                                blockPlayerArena.setType(Material.REDSTONE_BLOCK);
                            }
                        }
                    }
                }
            }
        }
    }

    static boolean baueKastenOhneTuer(int i, int j, int k, int SizeArena) {
        return (k == 1) || (j == 1 || j == SizeArena) || (i == 1 || i == SizeArena);
    }

    static boolean baueKastenMitTuer(int i, int j, int k, int SizeArena) {
        int tuer1 = SizeArena/2;
        int tuer2 = SizeArena/2+1;
        return ((k == 1)
                || (j == 1 && ((i != tuer1) && i != tuer2))
                || (j == SizeArena && ((i != tuer1) && i != tuer2))
                || (i == 1 && (j != tuer1 && j != tuer2))
                || (i == SizeArena) && (j != tuer1 && j != tuer2)
                || (j == 1 && (i == tuer1 && k > 4))
                || (i == 1 && (j == tuer1 && k > 4))
                || (j == 1 && (i == tuer2 && k > 4))
                || (i == 1 && (j == tuer2 && k > 4))
                || (j == SizeArena && (i == tuer1 && k > 4))
                || (i == SizeArena && (j == tuer1 && k > 4))
                || (j == SizeArena && (i == tuer2 && k > 4))
                || (i == SizeArena && (j == tuer2 && k > 4)));
    }
}