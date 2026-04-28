package Hra.entita;

import Hra.entita.input.KeyInput;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JPanel {

    private static final int TIMER_DELAY_MS = 16;
    private final KeyInput keyInput = new KeyInput();

    Player player = new Player(200, 323, 64, 64, true);
    BackGround backGround = new BackGround(-500,0, 20000, 900);
    TileSet tileSet = new TileSet();
    MapaManager mapManager = new MapaManager();
    CoinScore coinScore = new CoinScore();
    FinishFlag finishFlag = new FinishFlag(9000, 323,256,256);
    private Runnable onWin;
    private Timer timer;
    private int camera = 0;
    private MenuPanel menuPanel;

    public GameFrame(Runnable onWin, MenuPanel menuPanel) {
        this.onWin = onWin;
        this.menuPanel = menuPanel;

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
        mapManager.checkCoinCollection(player);

        if (mapManager.isPlayerDead(player)) {
            endGame("YOU DIED!", -1);
            return;
        }

        if (player.getX() > 9140) {
            endGame("LEVEL COMPLETE!", player.getCoinsCollected());
            return;
        }
        if (player.getY() > 1200) {
            endGame("YOU DIED!", -1);
            return;
        }

        camera = player.getX() + player.getWidth() / 2 - getWidth() / 2;
        if (camera < 0) camera = 0;

        backGround.moveBackground(1.5, keyInput.isKeyPressed(65), keyInput.isKeyPressed(68));

        tileSet.update();
    }



private void endGame(String message, int coins) {

    if (menuPanel != null) {

        menuPanel.setEnd(message, coins);
    }
    timer.stop();
    if (onWin != null) onWin.run();
}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);



        g.translate(-camera, 0);

        backGround.draw(g);
        tileSet.drawTile(g, mapManager);
        player.draw(g);
        finishFlag.draw(g);



        g.translate(camera, 0);
        coinScore.draw(g, player);



    }


    public void startGame() {
        timer.start();
    }

}

