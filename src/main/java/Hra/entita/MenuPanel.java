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
    private int ziskaneMince = -1;
    private Font customFont2;

    public void nastavKonec(int coins) {
        this.ziskaneMince = coins;
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
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(90f);
            title.setFont(customFont);
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
            this.customFont2 = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(30f);

        } catch (Exception e) {}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(pozadi, 0, 0, width, height, null);
        g.drawImage(space, 800, 450, 530, 350, null);
        g.drawImage(A, 890, 450, 250, 250, null);
        g.drawImage(D, 970, 455, 250, 250, null);




        if (ziskaneMince >= 0) {
            g.setFont(customFont2);
            g.setColor(Color.YELLOW);

            g.drawString("COINS COLLECTED: " + ziskaneMince, 470, 340);
        }
        }
    }
