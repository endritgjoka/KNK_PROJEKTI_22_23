package repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import models.*;
import service.DBConnection;

import java.sql.*;

public class FluturimetRepository {


    public static void insert(Fluturimet fluturim) throws SQLException {
        String sql = "INSERT INTO fluturimet (bileta_id, aeroplani_id, aeroporti_nisjes_id, nisja, aeroporti_arritjes_id, arritja, status) VALUES (?,?,?,?,?,?,?);";
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, fluturim.getBileta_id());
        statement.setInt(2, fluturim.getAeroplani_id());
        statement.setInt(3, fluturim.getAeroporti_nisjes_id());
        statement.setTimestamp(4, fluturim.getNisja());
        statement.setInt(3, fluturim.getAeroporti_arritjes_id());
        statement.setTimestamp(6, fluturim.getArritja());
        statement.setString(7, fluturim.getStatus());
        statement.executeUpdate();
    }


    public static ObservableList<Fluturimet> getAll() throws SQLException {
        ObservableList<Fluturimet> fluturimet = FXCollections.observableArrayList();
        String sql = "SELECT * FROM fluturimet f \n" +
                "INNER JOIN bileta b ON b.id = f.bileta_id " +
                "INNER JOIN aeroplanet a ON f.aeroplani_id = a.id \n" +
                "INNER JOIN aeroporti nisjet ON nisjet.id = f.aeroporti_nisjes_id \n" +
                "INNER JOIN aeroporti arritjet ON arritjet.id = f.aeroporti_arritjes_id \n";
        //String sql = "SELECT * FROM fluturimet";
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {

            int id = resultSet.getInt("id");
            int bileta_id = resultSet.getInt("bileta_id");
            int aeroplani_id = resultSet.getInt("aeroplani_id");
            int aeroporti_nisjes_id = resultSet.getInt("aeroporti_nisjes_id");
            Timestamp nisja = resultSet.getTimestamp("nisja");
            int aeroporti_arritjes_id = resultSet.getInt("aeroporti_arritjes_id");
            Timestamp arritja = resultSet.getTimestamp("arritja");
            String status = resultSet.getString("status");
            Fluturimet fluturim = new Fluturimet(id, bileta_id, aeroplani_id, aeroporti_nisjes_id, nisja, aeroporti_arritjes_id, arritja, status);


            bileta_id = resultSet.getInt("bileta_id");
            int çmimi = resultSet.getInt("çmimi");
            boolean dy_drejtimeshe = resultSet.getBoolean("dy_drejtimeshe");
            fluturim.setBileta(new Bileta(bileta_id,çmimi,dy_drejtimeshe ));

            aeroplani_id = resultSet.getInt("id");
            String kompania = resultSet.getString("kompania");
            int kapaciteti = resultSet.getInt("kapaciteti");
            String tipi = resultSet.getString("tipi");
            fluturim.setAiroplani(new Airoplani(aeroplani_id, kompania, kapaciteti, tipi));
            fluturim.setLinja(fluturim.getAiroplani().getKompania());


            int aeroporti_id = resultSet.getInt("nisjet.id");
            String emri = resultSet.getString("nisjet.emri");
            String qyteti = resultSet.getString("nisjet.qyteti");
            fluturim.setAeroporti1(new Aeroporti(aeroporti_id, emri, qyteti));
            fluturim.setQyteti1(qyteti);


            int aeroporti_id1 = resultSet.getInt("arritjet.id");
            String emri1 = resultSet.getString("arritjet.emri");
            String qyteti1 = resultSet.getString("arritjet.qyteti");
            fluturim.setAeroporti2(new Aeroporti(aeroporti_id1, emri1, qyteti1));
            fluturim.setQyteti2(qyteti1);

            fluturimet.add(fluturim);

        }
        return fluturimet;

    }



    public static void delete(int id) throws SQLException {
        String sql = "DELETE FROM fluturimet WHERE id=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public static ObservableList<Fluturimet> getActives() throws SQLException {
        ObservableList<Fluturimet> fluturimet = FXCollections.observableArrayList();
        String sql = "SELECT * FROM fluturimet f \n" +
                "INNER JOIN bileta b ON b.id = f.bileta_id " +
                "INNER JOIN aeroplanet a ON f.aeroplani_id = a.id \n" +
                "INNER JOIN aeroporti nisjet ON nisjet.id = f.aeroporti_nisjes_id \n" +
                "INNER JOIN aeroporti arritjet ON arritjet.id = f.aeroporti_arritjes_id" +
                " WHERE f.status = 'aktive'";
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {

            int id = resultSet.getInt("id");
            int bileta_id = resultSet.getInt("bileta_id");
            int aeroplani_id = resultSet.getInt("aeroplani_id");
            int aeroporti_nisjes_id = resultSet.getInt("aeroporti_nisjes_id");
            Timestamp nisja = resultSet.getTimestamp("nisja");
            int aeroporti_arritjes_id = resultSet.getInt("aeroporti_arritjes_id");
            Timestamp arritja = resultSet.getTimestamp("arritja");
            String status = resultSet.getString("status");
            Fluturimet fluturim = new Fluturimet(id, bileta_id, aeroplani_id, aeroporti_nisjes_id, nisja, aeroporti_arritjes_id, arritja, status);


            bileta_id = resultSet.getInt("bileta_id");
            int çmimi = resultSet.getInt("çmimi");
            boolean dy_drejtimeshe = resultSet.getBoolean("dy_drejtimeshe");
            fluturim.setBileta(new Bileta(bileta_id,çmimi,dy_drejtimeshe ));

            aeroplani_id = resultSet.getInt("id");
            String kompania = resultSet.getString("kompania");
            int kapaciteti = resultSet.getInt("kapaciteti");
            String tipi = resultSet.getString("tipi");
            fluturim.setAiroplani(new Airoplani(aeroplani_id, kompania, kapaciteti, tipi));
            fluturim.setLinja(fluturim.getAiroplani().getKompania());


            int aeroporti_id = resultSet.getInt("nisjet.id");
            String emri = resultSet.getString("nisjet.emri");
            String qyteti = resultSet.getString("nisjet.qyteti");
            fluturim.setAeroporti1(new Aeroporti(aeroporti_id, emri, qyteti));
            fluturim.setQyteti1(fluturim.getAeroporti1().getQyteti());


            int aeroporti_id1 = resultSet.getInt("arritjet.id");
            String emri1 = resultSet.getString("arritjet.emri");
            String qyteti1 = resultSet.getString("arritjet.qyteti");
            fluturim.setAeroporti2(new Aeroporti(aeroporti_id1, emri1, qyteti1));
            fluturim.setQyteti2(fluturim.getAeroporti2().getQyteti());

            fluturimet.add(fluturim);

        }
        return fluturimet;
    }
}
