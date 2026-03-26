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

    public void ovladani(KeyInput keys) {

        int podlahaY = 6 * 64 - getHeight();

        if (keys.isKeyPressed(KeyEvent.VK_D)) {
            setX(getX() + 5);
            radek = 1;
            move();
        } else if (keys.isKeyPressed(KeyEvent.VK_A)) {
            setX(getX() - 5);
            radek = 2;
            move();
        } else {
            sloupec = 0;
        }


        if (keys.isKeyPressed(KeyEvent.VK_SPACE) && !jump && getY() >= podlahaY) {
            jump = true;
            JumpLenght = 20;
        }

        if (jump) {
            setY(getY() - 10);
            JumpLenght--;
            if (JumpLenght <= 0) jump = false;
        } else {

            if (getY() < podlahaY) {
                setY(getY() + 8);
                if (getY() > podlahaY) setY(podlahaY);
            }
        }
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