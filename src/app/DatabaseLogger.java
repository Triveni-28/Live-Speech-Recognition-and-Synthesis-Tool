package app;

import java.sql.*;

public class DatabaseLogger {
    public static void log(String query, String result) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/speech_tool", "root", "your_password");
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO logs (query, result) VALUES (?, ?)")) {
            stmt.setString(1, query);
            stmt.setString(2, result);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("DB log failed.");
        }
    }
}
