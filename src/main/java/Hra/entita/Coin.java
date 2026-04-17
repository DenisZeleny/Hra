package Hra.entita;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Coin extends Entita{


    private static final Image[] COIN_FRAMES = loadFrames("/coin64.png", 64, 64, 25);

    private int coinFrame = 0;
    private double timer = 0;
    private final double frameSpeed = 0.05;


    public Coin() {
        super(0, 0, 64, 64, true);
    }

    public void update() {
        timer += 0.016;

        if (timer >= frameSpeed) {
            timer = 0;
            coinFrame++;

            if (coinFrame >= COIN_FRAMES.length) {
                coinFrame = 0;
            }
        }
    }


    public void drawCoin(Graphics g, int x, int y) {
        if (COIN_FRAMES != null && COIN_FRAMES[coinFrame] != null) {
            g.drawImage(COIN_FRAMES[coinFrame], x, y, 64, 64, null);
        }
    }


    private static Image[] loadFrames(String path, int width, int height, int count) {
        Image[] frames = new Image[count];
        try {

            Image fullImage = new ImageIcon(Coin.class.getResource(path)).getImage();
            BufferedImage spriteSheet = new BufferedImage(
                    fullImage.getWidth(null), fullImage.getHeight(null), BufferedImage.TYPE_INT_ARGB
            );

            Graphics g = spriteSheet.getGraphics();
            g.drawImage(fullImage, 0, 0, null);
            g.dispose();

            for (int i = 0; i < count; i++) {

                frames[i] = spriteSheet.getSubimage(i * width, 0, width, height);
            }
        } catch (Exception e) {

        }
        return frames;
    }
}