package app;

import java.sql.*;

public class DatabaseLogger {
    public static void logQuery(String input, String output) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/speechdb", "root", "password");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO queries (input_text, output_text) VALUES (?, ?)");
            stmt.setString(1, input);
            stmt.setString(2, output);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
