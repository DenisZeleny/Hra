package Hra.entita;

import java.awt.*;
import java.io.InputStream;

public class Score {
    private Font customFont;

    public Score() {
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
            text = "BEERS COLLECTED : " + player.getBeersCollected() + "/10";
        } else {
            g.setColor(Color.YELLOW);
            text = "COINS COLLECTED : " + player.getCoinsCollected() + "/10";
        }

        g.drawString(text, 20, 40);
    }
}