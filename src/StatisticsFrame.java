import javax.swing.*;
import java.awt.*;

public class StatisticsFrame extends JFrame {

    public StatisticsFrame(Player player) {

        PlayerService service =
                new PlayerService();

        Player latestPlayer =
                service.getPlayerStats(
                        player.getId());

        setTitle("Statistics");
        setSize(300, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        panel.setLayout(
                new GridLayout(5, 1));

        JLabel username =
                new JLabel(
                        "Username : " +
                        latestPlayer.getUsername());

        JLabel wins =
                new JLabel(
                        "Wins : " +
                        latestPlayer.getWins());

        JLabel losses =
                new JLabel(
                        "Losses : " +
                        latestPlayer.getLosses());

        JLabel draws =
                new JLabel(
                        "Draws : " +
                        latestPlayer.getDraws());

        JLabel score =
                new JLabel(
                        "Score : " +
                        latestPlayer.getScore());

        panel.add(username);
        panel.add(wins);
        panel.add(losses);
        panel.add(draws);
        panel.add(score);

        add(panel);

        setVisible(true);
    }
}