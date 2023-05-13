package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import models.Rezervimi;

public class FromToController extends BaseController {
    @FXML
    private ChoiceBox prej;
    @FXML
    private ChoiceBox te;
    @FXML
    private DatePicker data_nisjes;
    @FXML
    private DatePicker data_kthimit;

    @FXML
    public void goToLogin(ActionEvent event) throws Exception{
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

    public void handleFilterAction(ActionEvent actionEvent) {
    }
}
