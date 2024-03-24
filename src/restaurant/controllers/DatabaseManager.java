package restaurant.controllers;
import java.sql.*;

public class DatabaseManager {
    private static final String DATABASE_URL = "jdbc:postgresql://dpg-cnvk1umn7f5s7395obng-a.frankfurt-postgres.render.com:5432/restaurant_dbvp";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "JxZ9JPWROyqrXG99fnKVY39lnTXH2GLl";

    // Метод для установки соединения с базой данных
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver"); // Загрузка драйвера JDBC для PostgreSQL
            return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Помилка при запуску JDBC");
            e.printStackTrace();
            throw new SQLException("Драйвер JDBC не був найден", e);
        }
    }
}
