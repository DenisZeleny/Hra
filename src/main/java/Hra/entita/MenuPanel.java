package Hra.entita;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class MenuPanel extends JPanel {

    private Image pozadi = new ImageIcon("src/main/resources/pozadi.png").getImage();
    private Image space = new ImageIcon("src/main/resources/space.png").getImage();
    private Image A = new ImageIcon("src/main/resources/a.png").getImage();
    private Image D = new ImageIcon("src/main/resources/D.png").getImage();


    private int width = 1200;
    private int height = 900;
    private String endText = "";
    private int coinsGot = -1;
    private Font customFont2;
    private Font customFont1;
    private Font customFont3;

    public void setEnd(String text, int coins) {
        this.endText = text;
        this.coinsGot = coins;
        repaint();
    }

    public MenuPanel(Runnable onStart) {
        setLayout(new GridBagLayout());
        setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;

        JLabel title = new JLabel("MARIO Z TEMU");


        try {

            InputStream is = getClass().getResourceAsStream("/The Bomb Sound.ttf");
            this.customFont1 = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(90f);
            title.setFont(customFont1);
        } catch (Exception e) {}


        title.setForeground(Color.white);

        gbc.gridy = 0;
        gbc.insets = new Insets(180, 0, 0, 0);
        add(title, gbc);

        ImageIcon icon = new ImageIcon("src/main/resources/start_button.png");
        JButton startButton = new JButton(icon);

        startButton.setBorder(BorderFactory.createEmptyBorder());
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.setOpaque(false);
        startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        startButton.addActionListener(e -> {
            if (onStart != null) onStart.run();
        });

        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(startButton, gbc);


        try {
            InputStream is = getClass().getResourceAsStream("/The Bomb Sound.ttf");
            this.customFont2 = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(45f);
        } catch (Exception e) {}


        try {
            InputStream is = getClass().getResourceAsStream("/The Bomb Sound.ttf");
            this.customFont3 = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(65f);
        } catch (Exception e) {}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(pozadi, 0, 0, width, height, null);
        g.drawImage(space, 800, 450, 530, 350, null);
        g.drawImage(A, 890, 450, 250, 250, null);
        g.drawImage(D, 970, 455, 250, 250, null);


        g.setFont(customFont2);
        g.setColor(Color.white);
        g.drawString("MOVEMENT:",920,500);


        if (!endText.isEmpty()) {
            if (endText.contains("DIED")) {
                g.setFont(customFont3);
                g.setColor(Color.RED);
                g.drawString(endText, 450, 650);
            } else {
                g.setFont(customFont3);
                g.setColor(Color.GREEN);
                g.drawString(endText, 335, 650);

            }

        if (coinsGot >= 0) {
            g.setFont(customFont2);
            g.setColor(Color.YELLOW);

            g.drawString("COINS COLLECTED: " + coinsGot + "/10", 377, 353);

        }
        }
    }
}