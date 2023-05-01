package repository;

import service.DBConnection;
import models.Bileta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BiletaRepository {

    public static void insert(Bileta bileta) throws SQLException {
        String sql = "INSERT INTO bileta (cmimi) VALUES (?)";
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, bileta.getÇmimi());
        statement.executeUpdate();
    }

    public static Bileta getById(int id) throws SQLException {
        String sql = "SELECT * FROM bileta WHERE id=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int cmimi = resultSet.getInt("cmimi");
                return new Bileta(cmimi);
            } else {
                return null;
            }
        }
    }

    public static void update(Bileta bileta) throws SQLException {
        String sql = "UPDATE bileta SET cmimi=? WHERE id=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, bileta.getÇmimi());
//            statement.setInt(2, bileta.getId());
            statement.executeUpdate();
        }
    }

    public static void delete(int id) throws SQLException {
        String sql = "DELETE FROM bileta WHERE id=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
