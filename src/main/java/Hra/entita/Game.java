package Hra.entita;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    private static final String CARD_MENU = "menu";
    private static final String CARD_GAME = "game";

    private CardLayout layout;
    private JPanel container;

    public Game() {
        setTitle("Mario z Temu");
        setSize(1200, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        layout = new CardLayout();
        container = new JPanel(layout);

        // Vytvoření menu a předání akce pro start
        MenuPanel menuPanel = new MenuPanel(() -> {
            startGame();
        });

        container.add(menuPanel, CARD_MENU);
        add(container);

        layout.show(container, CARD_MENU);
    }

    private void startGame() {
        // Vytvoření nové instance GameFrame pokaždé, když startujeme
        // Předáváme Runnable (lambda výraz), který se spustí při výhře
        GameFrame gameFrame = new GameFrame(() -> {
            layout.show(container, CARD_MENU); // Přepne na menu
            // Po návratu do menu můžeme herní panel odstranit, aby nezabíral paměť
            container.remove(container.getComponent(1));
            revalidate();
            repaint();
        });

        container.add(gameFrame, CARD_GAME);
        layout.show(container, CARD_GAME);

        gameFrame.requestFocusInWindow();
        gameFrame.startGame();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Game().setVisible(true);
        });
    }
}