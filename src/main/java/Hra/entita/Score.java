package Hra.entita;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class Score {
    private Font customFont;
    private Image image;




    public Score() {

        image = new ImageIcon(getClass().getResource("/beer.png")).getImage();

        try {
            InputStream is = getClass().getResourceAsStream("/The Bomb Sound.ttf");
            customFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(30f);
        } catch (Exception e) {
            customFont = new Font("Arial", Font.BOLD, 30);
        }
    }

    public void draw(Graphics g, Player player, int currentLevel) {
        if (customFont != null) g.setFont(customFont);

        String text;
        if (currentLevel == 2) {

            g.setColor(Color.ORANGE);
            text = "BEERS COLLECTED : " + player.getBeersCollected() + "/6";
            g.drawString(text, 20, 40);


            g.drawImage(image, 20, 60, 64, 64, null);


            g.setColor(Color.ORANGE);
            g.drawString("= +1 speed", 100, 100);

        } else {
            g.setColor(Color.YELLOW);
            text = "COINS COLLECTED : " + player.getCoinsCollected() + "/10";
            g.drawString(text, 20, 40);

        }





    }
}