package Hra.entita;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.awt.Rectangle;
import Hra.entita.MapaManager;

public class TileSet {


    private static final int TILE_SIZE = 64;

    private Image TILE_1;
    private Image TILE_2;
    private Image TILE_3;
    private Image TILE_5;
    private int[][] currentMap;
    public Coin animatedCoin = new Coin();





    public TileSet() {


    }

    public void loadTheme(int level) {
        if (level == 1) {
            TILE_1 = new ImageIcon(getClass().getResource("/grass.png")).getImage();
            TILE_2 = new ImageIcon(getClass().getResource("/hlina.png")).getImage();
            TILE_3 = new ImageIcon(getClass().getResource("/spike.png")).getImage();
        } else if (level == 2) {
            TILE_1 = new ImageIcon(getClass().getResource("/garaz.png")).getImage();
            TILE_3 = new ImageIcon(getClass().getResource("/spike.png")).getImage();
            TILE_5 = new ImageIcon(getClass().getResource("/beer.png")).getImage();
        }
    }

    public void update() {
        animatedCoin.update();
    }

    public void setMap(int[][] map) {
        this.currentMap = map;
    }


    public void drawTile(Graphics g, MapaManager mm) {

        if (currentMap == null) return;

        for (int i = 0; i < currentMap.length; i++) {
            for (int j = 0; j < currentMap[i].length; j++) {
                int tileId = currentMap[i][j];

                if (tileId >= 1 && tileId <= 3) {
                    Image tile = getTileImage(tileId);
                    if (tile != null) {
                        g.drawImage(tile, j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
                    }
                }
            }
        }
        for (Rectangle coinRect : mm.coins) {
            animatedCoin.drawCoin(g, coinRect.x, coinRect.y);
        }
        for (Rectangle beerRect : mm.beers) {
            g.drawImage(TILE_5, beerRect.x, beerRect.y, 64, 64, null);
        }
    }
    public Image getTileImage(int tileId) {
        return switch (tileId) {
            case 1 -> TILE_1;
            case 2 -> TILE_2;
            case 3 -> TILE_3;
            case 5 -> TILE_5;
            default -> null;
        };
    }


}
