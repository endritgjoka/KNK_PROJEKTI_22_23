package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import service.DBConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class DiagrametController extends HomeController implements Initializable {

    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private CategoryAxis barChartXAxis;
    @FXML
    private NumberAxis barChartYAxis;

    @FXML
    private PieChart pieChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Fetch data from the database and populate the charts
        loadData();
    }

    private void loadData() {
        try {
            // Establish a connection to the database
            Connection connection = DBConnection.getConnection();

            // Query to retrieve gender-based data for the bar chart
            String genderQuery = "SELECT gjinia, COUNT(*) AS count FROM perdoruesit GROUP BY gjinia";

            // Execute the gender query
            Statement genderStatement = connection.createStatement();
            ResultSet genderResultSet = genderStatement.executeQuery(genderQuery);

            // Populate the bar chart with gender data
            while (genderResultSet.next()) {
                String gender = genderResultSet.getString("gjinia");
                int count = genderResultSet.getInt("count");
                XYChart.Series<String, Number> series = new XYChart.Series<>();
                series.getData().add(new XYChart.Data<>(gender, count));
                barChart.getData().add(series);
            }

            // Query to retrieve gender-based data for the pie chart
            String ageQuery = "SELECT gjinia, COUNT(*) AS count FROM perdoruesit GROUP BY gjinia";

            // Execute the age query
            Statement ageStatement = connection.createStatement();
            ResultSet ageResultSet = ageStatement.executeQuery(ageQuery);

            // Populate the pie chart with age data
            while (ageResultSet.next()) {
                String age = ageResultSet.getString("gjinia");
                int count = ageResultSet.getInt("count");
                PieChart.Data data = new PieChart.Data(age, count);
                pieChart.getData().add(data);
            }

            // Close the database connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goToUsers(ActionEvent actionEvent) throws IOException {
        goTo("Perdoruesit", "perdoruesit.fxml", actionEvent);

    }

    @FXML
    public void goToStats(ActionEvent actionEvent) throws IOException {
        goTo("Statistikat", "diagramet.fxml", actionEvent);

    }

    @FXML
    public void goToFluturimet(ActionEvent actionEvent) throws IOException {
        goTo("Fluturimet", "fluturimet.fxml", actionEvent);

    }

    @Override
    void translateEnglish(){


    }
    @Override
    void translateAlbanian(){

    }
}
