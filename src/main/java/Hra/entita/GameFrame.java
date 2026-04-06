package Hra.entita;

import Hra.entita.input.KeyInput;
import Hra.entita.MapaManager;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JPanel {

    private static final int TIMER_DELAY_MS = 16;
    private final KeyInput keyInput = new KeyInput();

    Player player = new Player(300, 300, 64, 64, true);
    BackGround backGround = new BackGround(0, 0, 10000, 900);
    TileSet tileSet = new TileSet();
    MapaManager mapManager = new MapaManager();

    private Timer timer;
    private int camera = 0;

    public GameFrame() {
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(keyInput);

        mapManager.loadMapData(tileSet.mapa);
        timer = new Timer(TIMER_DELAY_MS, e -> {
            updateGame();
            repaint();
        });
    }

    private void updateGame() {
        player.ovladani(keyInput, mapManager);

        camera = player.getX() + player.getWidth() / 2 - getWidth() / 2;
        if (camera < 0) camera = 0;

        tileSet.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.translate(-camera, 0);
        backGround.draw(g2);
        tileSet.drawTile(g2, mapManager);
        player.draw(g2);
        g2.translate(camera, 0);
    }

    public void startGame() {
        timer.start();
    }
}