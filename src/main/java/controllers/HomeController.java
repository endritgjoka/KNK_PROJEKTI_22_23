package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.file.Paths;

public class HomeController {


    @FXML
    private void help(ActionEvent event) throws Exception {

        Parent parenti = FXMLLoader.load(getClass().getResource("help.fxml"));
        Scene scene = new Scene(parenti);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
