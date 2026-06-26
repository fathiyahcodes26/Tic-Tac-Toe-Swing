import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuFrame extends JFrame {

    private Player currentPlayer;

    public MenuFrame(Player player) {

        currentPlayer = player;

        setTitle("Tic Tac Toe");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Color background = new Color(245, 247, 250);
        Color primary = new Color(52, 152, 219);

        JPanel panel = new JPanel();
        panel.setBackground(background);
        panel.setBorder(new EmptyBorder(25, 40, 25, 40));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("TIC TAC TOE");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Segoe UI", Font.BOLD, 30));
        title.setForeground(primary);

        JLabel welcome = new JLabel("Welcome, " + currentPlayer.getUsername());
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcome.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        welcome.setForeground(Color.DARK_GRAY);

        JButton playButton = new JButton("▶ Play Game");
        JButton statsButton = new JButton("📊 Statistics");
        JButton topButton = new JButton("🏆 Top 5 Scorers");

        JButton[] buttons = {
                playButton,
                statsButton,
                topButton
        };

        for (JButton button : buttons) {

            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setMaximumSize(new Dimension(280, 50));
            button.setPreferredSize(new Dimension(280, 50));

            button.setFont(new Font("Segoe UI", Font.BOLD, 16));
            button.setBackground(primary);
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
        }

        playButton.addActionListener(e -> {

            new GameFrame(currentPlayer);
            dispose();

        });

        statsButton.addActionListener(e -> {

            new StatisticsFrame(currentPlayer);

        });

        topButton.addActionListener(e -> {

            new TopScorersFrame();

        });

        panel.add(title);
        panel.add(Box.createVerticalStrut(10));
        panel.add(welcome);
        panel.add(Box.createVerticalStrut(40));

        panel.add(playButton);
        panel.add(Box.createVerticalStrut(20));

        panel.add(statsButton);
        panel.add(Box.createVerticalStrut(20));

        panel.add(topButton);

        add(panel);

        setVisible(true);
    }
}