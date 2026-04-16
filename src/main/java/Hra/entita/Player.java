package Hra.entita;

import javax.swing.*;
import java.awt.*;
import Hra.entita.input.KeyInput;

import java.awt.event.KeyEvent;

public class Player extends Entita {
    private int coinsCollected = 0;

    Image Panak = new ImageIcon(getClass().getResource("/guy.png")).getImage();

    int frameX = 0;
    int frameY = 0;
    int frameDelay = 0;
    int JumpLenght = 0;
    boolean jump = false;


    public Player(int x, int y, int width, int height, boolean isAlive) {
        super(x, y, width, height, isAlive);
    }

    public void addCoin() {coinsCollected++;}
    public int getCoinsCollected() { return coinsCollected; }

    public void move() {
        frameDelay++;
        if (frameDelay > 10) {
            frameDelay = 0;
            frameX++;
            if (frameX > 3) {
                frameX = 0;
            }
        }
    }

    public void ovladani(KeyInput keys, MapaManager mm) {
        int oldX = getX();



        if (keys.isKeyPressed(KeyEvent.VK_D)) {
            setX(getX() + 4);
            if (checkCollision(mm.grass)) setX(oldX);
            frameY = 1;
            move();
        }

        else if (keys.isKeyPressed(KeyEvent.VK_A)) {
            setX(getX() - 4);
            if (checkCollision(mm.grass)) setX(oldX);
            frameY = 2;
            move();
        } else {
            frameX = 0;
        }

        if (keys.isKeyPressed(KeyEvent.VK_SPACE) && !jump && isOnGround(mm.grass)) {
            jump = true;
            JumpLenght = 20;
        }
        if (jump) {
            setY(getY() - 10);
            if (checkCollision(mm.grass)) jump = false;
            JumpLenght--;
            if (JumpLenght <= 0) jump = false;
        } else {
            setY(getY() + 8);
            if (checkCollision(mm.grass)) {
                setY((getY() / 64) * 64);
            }
        }


    }


    private boolean checkCollision(java.util.ArrayList<Rectangle> blocks) {
        for (Rectangle r : blocks) {
            if (this.getBounds().intersects(r)) return true;
        }
        return false;
    }

    private boolean isOnGround(java.util.ArrayList<Rectangle> blocks) {
        Rectangle footSensor = new Rectangle(getX() + 5, getY() + getHeight(), getWidth() - 10, 2);
        for (Rectangle r : blocks) {
            if (footSensor.intersects(r)) return true;
        }
        return false;
    }


    @Override
    public void draw(Graphics g) {

        int sirkaJedne = Panak.getWidth(null) / 4;
        int vyskaJedne = Panak.getHeight(null) / 4;



        int zdrojX1 = frameX * sirkaJedne;
        int zdrojY1 = frameY * vyskaJedne;
        int zdrojX2 = zdrojX1 + sirkaJedne;
        int zdrojY2 = zdrojY1 + vyskaJedne;


        g.drawImage(Panak,
                getX(), getY(), getX() + getWidth(), getY() + getHeight(),
                zdrojX1, zdrojY1, zdrojX2, zdrojY2,
                null);
    }

}

