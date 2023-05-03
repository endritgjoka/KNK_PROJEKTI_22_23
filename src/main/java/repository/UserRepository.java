package repository;

import service.DBConnection;
import models.Perdoruesi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    public static void insert(Perdoruesi user) throws SQLException {
        String sql = "INSERT INTO perdoruesit (emri,mbiemri,username,fjalekalimi_salted,salt,mosha,gjinia,admin) VALUES (?, ?,?,?,?,?,?,?)";
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getEmri());
        statement.setString(2, user.getMbiemri());
        statement.setString(3, user.getUsername());
        statement.setString(4, user.getFjalekalimi_salted());
        statement.setString(5, user.getSalt());
        statement.setInt(6, user.getMosha());
        statement.setString(7, String.valueOf(user.getGjinia()));
        statement.setBoolean(8, user.isAdmin());
        statement.executeUpdate();
    }

    public static Perdoruesi getByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM perdoruesit WHERE username=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String emri = resultSet.getString("emri");
                String mbiemri = resultSet.getString("mbiemri");
                String fjalekalimiSalted = resultSet.getString("fjalekalimi_salted");
                String salt = resultSet.getString("salt");
                int mosha = resultSet.getInt("mosha");
                char gjinia = resultSet.getString("gjinia").charAt(0);
                boolean isAdmin = resultSet.getBoolean("admin");
                return new Perdoruesi(0, emri, mbiemri, username, fjalekalimiSalted, salt, mosha, gjinia, isAdmin);
            }

            return null;
        }
    }

    public static void update(Perdoruesi user) throws SQLException {
        String sql = "UPDATE perdoruesit SET username=?, fjalekalimi_salted=? WHERE id=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getFjalekalimi_salted());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        }
    }

    public static void delete(int id) throws SQLException {
        String sql = "DELETE FROM perdoruesit WHERE id=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
