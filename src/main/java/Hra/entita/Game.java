package Hra.entita;

import javax.swing.*;
import java.awt.*;



public class Game extends JFrame {

    private static final String CARD_MENU = "menu";
    private static final String CARD_GAME = "game";

    
    private CardLayout layout;
    
    private JPanel container;

    
    public Game() {
        setTitle("Game Window");
        setSize(1200, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        layout = new CardLayout();
        container = new JPanel(layout);

        

        MenuPanel menuPanel = new MenuPanel(() -> {
            startGame();
        });

        container.add(menuPanel, CARD_MENU);
        add(container);
        // Show the menu as the default screen.
        layout.show(container, CARD_MENU);
    }

    
    private void startGame() {
        
        GameFrame gameFrame = new GameFrame();

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
