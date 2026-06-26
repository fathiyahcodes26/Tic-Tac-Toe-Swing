import javax.swing.*;
import java.awt.*;

public class MenuFrame extends JFrame {

    private Player currentPlayer;

    public MenuFrame(Player currentPlayer) {

        this.currentPlayer = currentPlayer;

        setTitle("Tic Tac Toe");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel title = new JLabel(
                "TIC TAC TOE",
                SwingConstants.CENTER);

        JButton playButton =
                new JButton("Play Game");

        JButton statsButton =
                new JButton("Statistics");

        JButton leaderboardButton =
                new JButton("Top 5 Scorers");

        playButton.addActionListener(e -> {

            new GameFrame(currentPlayer);
            dispose();

        });

        statsButton.addActionListener(e -> {

            new StatisticsFrame(currentPlayer);

        });

        leaderboardButton.addActionListener(e -> {

            new TopScorersFrame();

        });

        panel.add(title);
        panel.add(playButton);
        panel.add(statsButton);
        panel.add(leaderboardButton);

        add(panel);

        title.setFont(new Font(
                "Arial",
                Font.BOLD,
                24));

        playButton.setFont(new Font(
                "Arial",
                Font.PLAIN,
                16));

        statsButton.setFont(new Font(
                "Arial",
                Font.PLAIN,
                16));

        leaderboardButton.setFont(new Font(
                "Arial",
                Font.PLAIN,
                16));

        setVisible(true);
    }
}