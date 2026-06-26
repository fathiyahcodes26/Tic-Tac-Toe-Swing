import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class TopScorersFrame extends JFrame {

    public TopScorersFrame() {

        setTitle("Top 5 Scorers");
        setSize(500, 300);
        setLocationRelativeTo(null);

        String[] columns = {
                "Rank",
                "Username",
                "Score"
        };

        Object[][] data =
                new Object[5][3];

        try {

            Connection conn =
                    DatabaseManager.getConnection();

            String sql =
                    "SELECT username, score " +
                    "FROM players " +
                    "ORDER BY score DESC " +
                    "LIMIT 5";

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    stmt.executeQuery();

            int row = 0;

            while (rs.next()) {

                data[row][0] = row + 1;
                data[row][1] =
                        rs.getString("username");
                data[row][2] =
                        rs.getInt("score");

                row++;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        JTable table =
                new JTable(data, columns);

        JScrollPane scrollPane =
                new JScrollPane(table);

        add(scrollPane,
                BorderLayout.CENTER);

        setVisible(true);
    }
}