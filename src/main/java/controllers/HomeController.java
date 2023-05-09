package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

public class HomeController {


    @FXML
    private Hyperlink login;
    @FXML
    private void help(ActionEvent event) throws Exception {

        Parent parenti = FXMLLoader.load(getClass().getResource("help.fxml"));
        Scene scene = new Scene(parenti);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    private void goToFluturimet(ActionEvent event) throws Exception {

        Parent parenti = FXMLLoader.load(getClass().getResource("fluturimet.fxml"));
        Scene scene = new Scene(parenti);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    public void goToRezervimet(ActionEvent event) throws Exception {
        Parent parenti = FXMLLoader.load(getClass().getResource("rezervimet.fxml"));
        Scene scene = new Scene(parenti);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}