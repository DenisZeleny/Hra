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

    public void draw(Graphics g, Player player) {
        g.setFont(customFont);

        String text = "COINS COLLECTED : " + player.getCoinsCollected() + "/10";



        g.setColor(Color.YELLOW);
        g.drawString(text, 20, 40);

    }
}