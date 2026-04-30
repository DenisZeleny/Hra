package Hra.entita;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.util.function.Consumer;

public class MenuPanel extends JPanel {


    private Image pozadi = new ImageIcon(getClass().getResource("/pozadi.png")).getImage();
    private Image space = new ImageIcon(getClass().getResource("/space.png")).getImage();
    private Image A = new ImageIcon(getClass().getResource("/a.png")).getImage();
    private Image D = new ImageIcon(getClass().getResource("/D.png")).getImage();

    private int width = 1200;
    private int height = 900;
    private String endText = "";
    private int coinsGot = -1;
    private int currentLevel = 1;

    private Font customFont1, customFont2, customFont3, customFont4;

    public void setEnd(String text, int coins, int level) {
        this.endText = text;
        this.coinsGot = coins;
        this.currentLevel = level;
        repaint();

    }

    public MenuPanel(Consumer<Integer> onStart) {

        try {
            InputStream is = getClass().getResourceAsStream("/The Bomb Sound.ttf");
            byte[] fontData = is.readAllBytes();

            this.customFont1 = Font.createFont(Font.TRUETYPE_FONT, new java.io.ByteArrayInputStream(fontData)).deriveFont(90f);
            this.customFont2 = Font.createFont(Font.TRUETYPE_FONT, new java.io.ByteArrayInputStream(fontData)).deriveFont(45f);
            this.customFont3 = Font.createFont(Font.TRUETYPE_FONT, new java.io.ByteArrayInputStream(fontData)).deriveFont(65f);
            this.customFont4 = Font.createFont(Font.TRUETYPE_FONT, new java.io.ByteArrayInputStream(fontData)).deriveFont(55f);

        } catch (Exception e) {

            this.customFont1 = new Font("Arial", Font.BOLD, 90);
            this.customFont2 = new Font("Arial", Font.BOLD, 45);
            this.customFont3 = new Font("Arial", Font.BOLD, 65);
            this.customFont4 = new Font("Arial", Font.BOLD, 55);
        }

        setLayout(new GridBagLayout());
        setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);

        JLabel title = new JLabel("MARIO Z TEMU");
        title.setFont(customFont1);
        title.setForeground(Color.white);
        gbc.gridy = 0;
        add(title, gbc);

        JButton btnLvl1 = createStyledButton("CLASSIC LEVEL");
        btnLvl1.addActionListener(e -> onStart.accept(1));
        gbc.gridy = 1;
        add(btnLvl1, gbc);

        JButton btnLvl2 = createStyledButton("SVARTA JUMP");
        btnLvl2.addActionListener(e -> onStart.accept(2));
        gbc.gridy = 2;
        add(btnLvl2, gbc);
    }

    private JButton createStyledButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(customFont2);
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(0, 0, 0, 150));
        btn.setFocusPainted(false);
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(pozadi, 0, 0, width, height, null);
        g.drawImage(space, 800, 450, 530, 350, null);
        g.drawImage(A, 890, 450, 250, 250, null);
        g.drawImage(D, 970, 455, 250, 250, null);

        if (customFont2 != null) g.setFont(customFont2);
        g.setColor(Color.white);
        g.drawString("MOVEMENT:", 920, 500);

        if (!endText.isEmpty()) {
            if (customFont3 != null) g.setFont(customFont3);

            if (endText.contains("DIED")) {
                g.setColor(Color.RED);
                g.drawString(endText, 460, 650);
            } else if (currentLevel == 2) {
                g.setFont(customFont4);
                g.setColor(Color.GREEN);
                String levelInfo1 = "SVARTA JUMP COMPLETE!";
                g.drawString(levelInfo1, 285, 650);
            } else {
                g.setFont(customFont4);
                g.setColor(Color.green);
                String levelInfo2 = "CLASSIC LEVEL COMPLETE!";
                g.drawString(levelInfo2, 285, 650);

            }

            if (coinsGot >= 0) {
                if (customFont2 != null) g.setFont(customFont2);

                String text;
                if (this.currentLevel == 2) {
                    g.setColor(Color.ORANGE);
                    text = "BEERS COLLECTED: ";
                } else {
                    g.setColor(Color.YELLOW);
                    text = "COINS COLLECTED: ";
                }

                g.drawString(text + coinsGot + "/10", 377, 283);
            }
        }
    }
}

