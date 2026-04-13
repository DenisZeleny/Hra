package Hra.entita;

import java.awt.Rectangle;
import java.util.ArrayList;

public class MapaManager {
    public ArrayList<Rectangle> grass = new ArrayList<>();
    public ArrayList<Rectangle> spikes = new ArrayList<>();
    public ArrayList<Rectangle> coins = new ArrayList<>();

    private final int TILE_SIZE = 64;

    public void loadMapData(int[][] mapa) {

        grass.clear();
        spikes.clear();
        coins.clear();

        for (int row = 0; row < mapa.length; row++) {
            for (int col = 0; col < mapa[row].length; col++) {
                int tileId = mapa[row][col];


                Rectangle hitBox = new Rectangle(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);

                switch (tileId) {
                    case 1, 2 -> grass.add(hitBox);
                    case 3 -> spikes.add(hitBox);
                    case 4 -> coins.add(hitBox);
                }
            }
        }
    }
    public void checkCoinCollection(Player player) {
        for (int i = 0; i < coins.size(); i++) {
            if (player.getBounds().intersects(coins.get(i))) {
                coins.remove(i);
                player.addCoin();
                break;
            }
        }
    }


    public boolean isPlayerDead(Player player) {
        for (Rectangle s : spikes) {
            if (player.getBounds().intersects(s)) return true;
        }
        return player.getY() > 900;
    }
}