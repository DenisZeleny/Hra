package Hra.entita;

import java.awt.*;
import java.io.InputStream;

public class CoinScore {
    private Font customFont;

    public CoinScore() {
        try {
            InputStream is = getClass().getResourceAsStream("/The Bomb Sound.ttf");
            customFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(30f);
        } catch (Exception e) {}
    }

    public void draw(Graphics2D g2, Player player) {
        g2.setFont(customFont);

        String text = "COINS COLLECTED : " + player.getCoinsCollected();



        g2.setColor(Color.YELLOW);
        g2.drawString(text, 20, 40);

    }
}