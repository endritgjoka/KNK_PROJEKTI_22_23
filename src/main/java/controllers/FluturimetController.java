package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FluturimetController {

    public void btnFilter(ActionEvent actionEvent) {
    }
    
    @FXML
    private void shkoMbrapa(ActionEvent event) throws IOException {
        Parent parenti = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = new Scene(parenti);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
