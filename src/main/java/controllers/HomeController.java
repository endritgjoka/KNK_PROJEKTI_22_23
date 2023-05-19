package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import models.Rezervimi;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

public class HomeController extends BaseController {


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
    private void goToFluturimet(ActionEvent event)  {

        Parent parenti = null;
        try {
            parenti = FXMLLoader.load(getClass().getResource("fromto.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(parenti);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    public void goToRezervimet(ActionEvent event) throws Exception {
        Parent parenti = FXMLLoader.load(getClass().getResource("pasagjer.fxml"));
        Scene scene = new Scene(parenti);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    public void goToLogin(ActionEvent event) throws Exception {
        Rezervimi.setPerdoruesi(null);
        Parent parenti = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(parenti);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    void translateEnglish() {

    }

    @Override
    void translateAlbanian() {

    }

    @FXML
    public void goToProfile(ActionEvent event) throws Exception{

        Parent parenti = FXMLLoader.load(getClass().getResource("userProfile.fxml"));
        Scene scene = new Scene(parenti);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}