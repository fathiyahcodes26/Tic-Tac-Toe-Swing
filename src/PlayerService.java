import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PlayerService {

    public Player login(String username, String password) {

        try {

            Connection conn =
                    DatabaseManager.getConnection();

            String sql =
                    "SELECT * FROM players WHERE username = ? AND password = ?";

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs =
                    stmt.executeQuery();

            if (rs.next()) {

                return new Player(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("wins"),
                        rs.getInt("losses"),
                        rs.getInt("draws"),
                        rs.getInt("score")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    public void updateStatistics(
            Player player,
            String result) {

        int additionalScore = 0;
        String sql = "";

        if (result.equalsIgnoreCase("WIN")) {

            additionalScore = 10;

            sql =
                    "UPDATE players " +
                    "SET wins = wins + 1, " +
                    "score = score + ? " +
                    "WHERE id = ?";

        } else if (result.equalsIgnoreCase("LOSE")) {

            sql =
                    "UPDATE players " +
                    "SET losses = losses + 1 " +
                    "WHERE id = ?";

        } else if (result.equalsIgnoreCase("DRAW")) {

            additionalScore = 3;

            sql =
                    "UPDATE players " +
                    "SET draws = draws + 1, " +
                    "score = score + ? " +
                    "WHERE id = ?";
        }

        try {

            Connection conn =
                    DatabaseManager.getConnection();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            if (result.equalsIgnoreCase("LOSE")) {

                stmt.setInt(
                        1,
                        player.getId());

            } else {

                stmt.setInt(
                        1,
                        additionalScore);

                stmt.setInt(
                        2,
                        player.getId());
            }

            stmt.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public Player getPlayerStats(int playerId) {

        try {

            Connection conn =
                    DatabaseManager.getConnection();

            String sql =
                    "SELECT * FROM players WHERE id = ?";

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setInt(1, playerId);

            ResultSet rs =
                    stmt.executeQuery();

            if (rs.next()) {

                return new Player(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("wins"),
                        rs.getInt("losses"),
                        rs.getInt("draws"),
                        rs.getInt("score")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}