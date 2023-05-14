package repository;


import models.Airoplani;
import service.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AiroplaniRepository {
    public static void insert(Airoplani airoplani) throws SQLException {
        String sql = "INSERT INTO aeroplanet(kompania,kapaciteti, tipi) VALUES (?,?,?)";
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, airoplani.getKompania());
        statement.setInt(2, airoplani.getKapaciteti());
        statement.setString(3, airoplani.getTipi());
        statement.executeUpdate();
    }

    public static Airoplani getById(int id) throws SQLException {
        String sql = "SELECT * FROM aeroplanet WHERE id=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String kompania = resultSet.getString("kompania");
                int kapaciteti = resultSet.getInt("kapaciteti");
                String tipi = resultSet.getString("tipi");
                return new Airoplani(id, kompania, kapaciteti, tipi);
            } else {
                return null;
            }
        }
    }



    public static void update(Airoplani airoplani) throws SQLException {
        String sql = "UPDATE aeroplanet SET kompania=?, kapaciteti=?, tipi=?  WHERE id=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,airoplani.getKompania());
            statement.setInt(2, airoplani.getKapaciteti());
            statement.setString(3, airoplani.getTipi());
            statement.executeUpdate();
        }
    }

    public static void delete(int id) throws SQLException {
        String sql = "DELETE FROM aeroplanet WHERE id=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}