import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.*;

public class TopScorersFrame extends JFrame {

    public TopScorersFrame() {

        setTitle("Top 5 Scorers");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        Color background = new Color(245, 247, 250);
        Color primary = new Color(52, 152, 219);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(background);

        JLabel title = new JLabel(
                "🏆 TOP 5 SCORERS",
                SwingConstants.CENTER);

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28));

        title.setForeground(primary);

        title.setBorder(
                new EmptyBorder(
                        20,
                        0,
                        20,
                        0));

        panel.add(title, BorderLayout.NORTH);

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
                data[row][1] = rs.getString("username");
                data[row][2] = rs.getInt("score");

                row++;
            }

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        JTable table =
                new JTable(data, columns);

        table.setRowHeight(35);

        table.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16));

        table.setSelectionBackground(
                new Color(220, 235, 250));

        JTableHeader header =
                table.getTableHeader();

        header.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16));

        header.setBackground(primary);
        header.setForeground(Color.WHITE);

        DefaultTableCellRenderer center =
                new DefaultTableCellRenderer();

        center.setHorizontalAlignment(
                SwingConstants.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {

            table.getColumnModel()
                    .getColumn(i)
                    .setCellRenderer(center);
        }

        JScrollPane scrollPane =
                new JScrollPane(table);

        scrollPane.setBorder(
                new EmptyBorder(
                        10,
                        20,
                        20,
                        20));

        panel.add(scrollPane,
                BorderLayout.CENTER);

        JButton closeButton =
                new JButton("Close");

        closeButton.setBackground(primary);
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusPainted(false);

        closeButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16));

        closeButton.addActionListener(e -> dispose());

        JPanel bottom =
                new JPanel();

        bottom.setBackground(background);
        bottom.add(closeButton);

        panel.add(bottom,
                BorderLayout.SOUTH);

        add(panel);

        setVisible(true);
    }
}