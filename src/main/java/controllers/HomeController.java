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


public class HomeController {

    @FXML
    private Hyperlink login;
     void translateEnglish(){

     };
     void translateAlbanian(){

     };

    void goTo(String title, String window, ActionEvent event) throws IOException {
        Parent parenti = FXMLLoader.load(getClass().getResource(window));
        Scene scene = new Scene(parenti);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void help(ActionEvent event) throws Exception {
       goTo("Help", "help.fxml", event);
    }

    @FXML
    private void goToFluturimet(ActionEvent event) throws IOException {
        goTo("Fluturimet", "fromto.fxml", event);
    }



    @FXML
    public void goToLogin(ActionEvent event) throws Exception {
        Rezervimi.setPerdoruesi(null);
        goTo("Log In", "login.fxml", event);

    }


    @FXML
    public void goToProfile(ActionEvent event) throws Exception{
        goTo("User Profile", "userProfile.fxml", event);
    }
}