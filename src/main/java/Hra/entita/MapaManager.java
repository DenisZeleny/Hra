package Hra.entita;

import java.awt.Rectangle;
import java.util.ArrayList;

public class MapaManager {
    public ArrayList<Rectangle> grass = new ArrayList<>();
    public ArrayList<Rectangle> spikes = new ArrayList<>();
    public ArrayList<Rectangle> coins = new ArrayList<>();
    public ArrayList<Rectangle> beers = new ArrayList<>();


    private final int TILE_SIZE = 64;

    public void loadMapData(int[][] mapa) {

        grass.clear();
        spikes.clear();
        coins.clear();
        beers.clear();


        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                int tileId = mapa[i][j];


                Rectangle hitBox = new Rectangle(j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE);

                switch (tileId) {
                    case 1, 2 -> grass.add(hitBox);
                    case 3 -> spikes.add(hitBox);
                    case 4 -> coins.add(hitBox);
                    case 5 -> beers.add(hitBox);
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
        for (int i = 0; i < beers.size(); i++) {
            if (player.getBounds().intersects(beers.get(i))) {
                beers.remove(i);
                player.addBeer();
                player.boostSpeed(1);
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