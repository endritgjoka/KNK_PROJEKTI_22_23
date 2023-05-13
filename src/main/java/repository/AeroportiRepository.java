package repository;

import models.Aeroporti;
import service.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AeroportiRepository {

    public static void insert(Aeroporti aeroporti) throws SQLException {
        String sql = "INSERT INTO aeroporti(emri,qyteti) VALUES (?,?)";
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, aeroporti.getEmri());
        statement.setString(2, aeroporti.getQyteti());
        statement.executeUpdate();
    }

    public static Aeroporti getById(int id) throws SQLException {
        String sql = "SELECT * FROM aeroporti WHERE id=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String emri = resultSet.getString("emri");
                String qyteti = resultSet.getString("qyteti");
                return new Aeroporti(id, emri, qyteti);
            } else {
                return null;
            }
        }
    }

    public static void update(Aeroporti aeroporti) throws SQLException {
        String sql = "UPDATE aeroporti SET emri=?, qyteti=?  WHERE id=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, aeroporti.getEmri());
            statement.setString(2, aeroporti.getQyteti());
            statement.setInt(3, aeroporti.getId());
            statement.executeUpdate();
        }
    }

    public static void delete(int id) throws SQLException {
        String sql = "DELETE FROM aeroporti WHERE id=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}