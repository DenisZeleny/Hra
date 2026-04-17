package Hra.entita;

import javax.swing.*;
import java.awt.*;

public class FinishFlag extends Entita {



    Image Flag = new ImageIcon(getClass().getResource("/finish_flag.png")).getImage();

    public FinishFlag(int x, int y, int width, int height) {
        super(x, y, width, height, true);

    }

    public void draw(Graphics g) {
        g.drawImage(Flag, getX(), getY(), getWidth(), getHeight(), null);
    }
}
