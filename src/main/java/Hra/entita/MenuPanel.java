package Hra.entita;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private Image pozadi = new ImageIcon(("src/main/resources/pozadi.png")).getImage();
    private Image space = new ImageIcon(("src/main/resources/space.png")).getImage();
    private Image A = new ImageIcon(("src/main/resources/a.png")).getImage();
    private Image D = new ImageIcon(("src/main/resources/D.png")).getImage();




    private int width = 1200;
    private int height = 900;

    public MenuPanel(Runnable onStart) {
        setLayout(new GridBagLayout());
        setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;


        JLabel title = new JLabel("O B L A K");
        title.setFont(new Font("Monospaced", Font.BOLD, 70));
        title.setForeground(Color.white);

        gbc.gridy = 0;
        gbc.insets = new Insets(100, 0, 0, 0);
        add(title, gbc);


        ImageIcon icon = new ImageIcon(("src/main/resources/start_button.png"));
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






    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(pozadi, 0, 0, width, height, null);

        g.drawImage(space,800,450,530,350,null);
        g.drawImage(A,890,450,250,250,null);
        g.drawImage(D,970,455,250,250,null);





    }
}

