package Hra.entita;

import javax.swing.*;
import java.awt.*;
import Hra.entita.input.KeyInput;
import Hra.entita.tools.CollisionTools;
import Hra.entita.tools.PositionTools;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player extends Entita {


    Image Panak = new ImageIcon(getClass().getResource("/guy.png")).getImage();

    int sloupec = 0;
    int radek = 0;
    int pauza = 0;
    int JumpLenght = 0;
    boolean jump = false;


    public Player(int x, int y, int width, int height, boolean isAlive) {
        super(x, y, width, height, isAlive);
    }

    public void move() {
        pauza++;
        if (pauza > 10) {
            pauza = 0;
            sloupec++;
            if (sloupec > 3) {
                sloupec = 0;
            }
        }
    }

    public void ovladani(KeyInput keys, MapaManager mm) {
        int oldX = getX();


        if (keys.isKeyPressed(KeyEvent.VK_D)) {
            setX(getX() + 4);
            if (checkCollision(mm.grass)) setX(oldX);
            radek = 1;
            move();
        }

        else if (keys.isKeyPressed(KeyEvent.VK_A)) {
            setX(getX() - 4);
            if (checkCollision(mm.grass)) setX(oldX);
            radek = 2;
            move();
        } else {
            sloupec = 0;
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
        for (int i = 0; i < mm.coins.size(); i++) {
            if (this.getBounds().intersects(mm.coins.get(i))) {
                mm.coins.remove(i);
                break;
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



        int zdrojX1 = sloupec * sirkaJedne;
        int zdrojY1 = radek * vyskaJedne;
        int zdrojX2 = zdrojX1 + sirkaJedne;
        int zdrojY2 = zdrojY1 + vyskaJedne;


        g.drawImage(Panak,
                getX(), getY(), getX() + getWidth(), getY() + getHeight(),
                zdrojX1, zdrojY1, zdrojX2, zdrojY2,
                null);
    }

}