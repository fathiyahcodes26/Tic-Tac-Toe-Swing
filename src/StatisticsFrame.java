import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StatisticsFrame extends JFrame {

    public StatisticsFrame(Player player) {

        PlayerService service = new PlayerService();
        Player latestPlayer = service.getPlayerStats(player.getId());

        setTitle("Statistics");
        setSize(450, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        Color background = new Color(245,247,250);
        Color primary = new Color(52,152,219);

        JPanel panel = new JPanel();
        panel.setBackground(background);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(25,30,25,30));

        JLabel title = new JLabel("PLAYER STATISTICS");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(primary);

        panel.add(title);
        panel.add(Box.createVerticalStrut(25));

        String[] texts = {
                "Username : " + latestPlayer.getUsername(),
                "Wins : " + latestPlayer.getWins(),
                "Losses : " + latestPlayer.getLosses(),
                "Draws : " + latestPlayer.getDraws(),
                "Score : " + latestPlayer.getScore()
        };

        for (String text : texts) {

            JLabel label = new JLabel(text);

            label.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            label.setOpaque(true);
            label.setBackground(Color.WHITE);
            label.setBorder(new EmptyBorder(15,15,15,15));
            label.setMaximumSize(new Dimension(350,55));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);

            panel.add(label);
            panel.add(Box.createVerticalStrut(12));
        }

        JButton closeButton = new JButton("Close");
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButton.setBackground(primary);
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusPainted(false);
        closeButton.setFont(new Font("Segoe UI", Font.BOLD, 16));

        closeButton.addActionListener(e -> dispose());

        panel.add(Box.createVerticalStrut(15));
        panel.add(closeButton);

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane);

        setVisible(true);
    }
}