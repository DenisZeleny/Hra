package Hra.entita;

import Hra.entita.input.KeyInput;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GameFrame extends JPanel {

    private static final int TIMER_DELAY_MS = 16;

    private final KeyInput keyInput = new KeyInput();

    Player player = new Player(300,300,64,64,true);
    BackGround backGround = new BackGround(0,0,10000,900);
    TileSet tileSet = new TileSet();
    private Timer timer;
    private int Camera = 0;


    public GameFrame() {

        setFocusable(true);

        setFocusTraversalKeysEnabled(false);

        addKeyListener(keyInput);


        timer = new Timer(TIMER_DELAY_MS, e -> {
            updateGame();
            repaint();
        });
    }

    private void addKeyListener(KeyInput keyInput) {
        super.addKeyListener(keyInput);
    }


    public void startGame() {
        timer.start();
    }


    private void updateGame() {
        player.ovladani(keyInput);

        Camera = player.getX() + player.getWidth() / 2 - getWidth() / 2;

        if (Camera < 0) Camera = 0;

        tileSet.update();







    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.translate(-Camera, 0);

        backGround.draw(g2);
        tileSet.drawTile(g2);
        player.draw(g2);

        g2.translate(Camera, 0);
    }




    public KeyInput getKeyInput() {
        return keyInput;
    }



    public Player getPlayer() {
        return player;
    }
}
