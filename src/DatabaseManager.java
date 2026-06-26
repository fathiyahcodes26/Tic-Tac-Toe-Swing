import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseManager {

    private static final String URL =
            "jdbc:postgresql://localhost:5433/game_project";

    private static final String USER = "postgres";

    private static final String PASSWORD = "f@th1y@hRIy@nt0";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Koneksi gagal!");
            e.printStackTrace();
            return null;
        }
    }
}