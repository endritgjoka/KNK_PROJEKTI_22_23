package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Pasagjeri;
import models.Perdoruesi;
import models.Rezervimi;
import service.PasagjeriService;

import java.net.URL;
import java.util.ResourceBundle;

public class PasagjerController extends BaseController implements Initializable{


    @FXML
    TextField emri, mbiemri, adresa, nacionaliteti, numriTelefonit, pasaporta;

    @FXML
    private DatePicker ditelindja;



    @FXML
    public void goToPagesa(ActionEvent event) throws Exception {
        String padresa = this.adresa.getText();
        String pnacionaliteti = this.nacionaliteti.getText();
        String pNumriTelefonit = this.numriTelefonit.getText();
        String pNumriPasaportes = this.pasaporta.getText();
        if (!padresa.equals("") && !pnacionaliteti.equals("") && !pNumriTelefonit.equals("")){
            Pasagjeri pasagjeri = PasagjeriService.regjistroPasagjerin(Rezervimi.getPerdoruesi().getId(), padresa, pnacionaliteti, pNumriTelefonit, pNumriPasaportes);
            RezervimController.pasagjeriId = pasagjeri.getId();
            Parent parenti = FXMLLoader.load(getClass().getResource("rezervim.fxml"));
            Scene scene = new Scene(parenti);
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(scene);
            primaryStage.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING, "These fields should be filled!");
            alert.show();
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Perdoruesi perdoruesi = Rezervimi.getPerdoruesi();
        this.emri.setText(perdoruesi.getEmri());
        this.mbiemri.setText(perdoruesi.getMbiemri());
        this.ditelindja.setValue(perdoruesi.getDitelindja().toLocalDate());

    }

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


    @FXML
    public void vazhdo(ActionEvent actionEvent) {

    }
}