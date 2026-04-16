package Hra.entita;

import javax.swing.*;
import java.awt.*;

public class FinishFlag {
    int x, y, width, height;


    Image Flag = new ImageIcon(getClass().getResource("/finish_flag.png")).getImage();

    public FinishFlag(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.drawImage(Flag, x, y, width, height, null);
    }
}
