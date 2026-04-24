package Hra.entita;

import javax.swing.*;
import java.awt.*;

public class BackGround extends Entita{

    Image backGround = new ImageIcon(getClass().getResource("/background.png")).getImage();


    public BackGround(int x, int y, int width, int height) {
        super(x, y, width, height, true);

    }

    public void moveBackground(double speed, boolean moveDirectionLeft, boolean moveDirectionRight) {

        double moveSpeed = speed * 0.5;

        if (moveDirectionLeft) {
            this.x += moveSpeed;        }

        if (moveDirectionRight) {
            this.x -= moveSpeed;        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(backGround,getX(),getY(),getWidth(),getHeight(),null);
    }
}
