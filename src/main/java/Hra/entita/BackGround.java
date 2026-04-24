package Hra.entita;

import javax.swing.*;
import java.awt.*;

public class BackGround extends Entita{

    Image backGround = new ImageIcon(getClass().getResource("/background.png")).getImage();




    public BackGround(int x, int y, int width, int height) {
        super(x, y, width, height, true);

    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(backGround,getX(),getY(),getWidth(),getHeight(),null);
    }
}
