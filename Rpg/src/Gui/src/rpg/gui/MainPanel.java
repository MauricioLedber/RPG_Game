import javax.swing.*;
import java.awt.*;

public class RPGGame extends JFrame {

    private JPanel mainPanel, statusPanel, gamePanel, actionPanel;

    public RPGGame() {
        setTitle("RPG Game");
        setSize(WindowConstants.WINDOW_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create main panel
        mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);

        // Create and customize status panel
        statusPanel = new JPanel();
        statusPanel.setBackground(Color.GRAY);
        statusPanel.setPreferredSize(new Dimension(WindowConstants.WINDOW_SIZE.width, 150));
        mainPanel.add(statusPanel, BorderLayout.NORTH);

        // Create and customize game panel
        gamePanel = new JPanel();
        gamePanel.setBackground(Color.GREEN);
        gamePanel.setPreferredSize(new Dimension(WindowConstants.WINDOW_SIZE.width, 370));
        mainPanel.add(gamePanel, BorderLayout.CENTER);

        // Create and customize action panel
        actionPanel = new JPanel();
        actionPanel.setBackground(Color.BLUE);
        actionPanel.setPreferredSize(new Dimension(WindowConstants.WINDOW_SIZE.width, 340));
        mainPanel.add(actionPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new RPGGame();
    }
}