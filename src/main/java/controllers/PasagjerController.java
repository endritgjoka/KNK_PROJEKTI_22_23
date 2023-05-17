package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.Pasagjeri;
import models.Perdoruesi;
import models.Rezervimi;
import service.PasagjeriService;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class PasagjerController extends BaseController implements Initializable{


    @FXML
    TextField emri, mbiemri, adresa, nacionaliteti, numriTelefonit, pasaporta;

    @FXML
    private DatePicker ditelindja;
    @FXML
    private Label TedhenatPasagjerit;
    @FXML
    private Label Emri;
    @FXML
    private Label Mbiemri;
    @FXML
    private Label Ditelindja;
    @FXML
    private Label Adresa;

    @FXML
    private Label Nacionaliteti;
     @FXML
    private Label numri_telefonit;
     @FXML
     private Label nrPasaportes;
     @FXML
     private Button next;

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
    private void goToFluturimet(ActionEvent event) throws Exception {

        Parent parenti = FXMLLoader.load(getClass().getResource("fromto.fxml"));
        Scene scene = new Scene(parenti);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    public void goToBaggage(ActionEvent event) throws Exception {
        Parent parenti = FXMLLoader.load(getClass().getResource("rezervim.fxml"));
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


    
    @FXML
    public void goToPassagers(ActionEvent event) throws Exception {
        Rezervimi.setPerdoruesi(null);
        Parent parenti = FXMLLoader.load(getClass().getResource("pasagjer.fxml"));
        Scene scene = new Scene(parenti);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    @Override
    void translateEnglish() {
        Locale currentLocale = new Locale("en");

        ResourceBundle translate = ResourceBundle.getBundle("translation.content", currentLocale);
        TedhenatPasagjerit.setText(translate.getString("label.TedhenatPasagjerit"));
        Emri.setText(translate.getString("label.Emri"));
        Mbiemri.setText(translate.getString("label.Mbiemri"));
        Ditelindja.setText(translate.getString("label.Ditelindja"));
        Adresa.setText(translate.getString("label.Adresa"));
        Nacionaliteti.setText(translate.getString("label.Nacionaliteti"));
        numri_telefonit.setText(translate.getString("label.numri_telefonit"));
        nrPasaportes.setText(translate.getString("label.nrPasaportes"));
        next.setText(translate.getString("button.next"));

    }

    @Override
    void translateAlbanian() {
        Locale currentLocale = new Locale("sq");

        ResourceBundle translate = ResourceBundle.getBundle("translation.content", currentLocale);
        Emri.setText(translate.getString("label.Emri"));
        Mbiemri.setText(translate.getString("label.Mbiemri"));
         Ditelindja.setText(translate.getString("label.Ditelindja"));
        Adresa.setText(translate.getString("label.Adresa"));
        Nacionaliteti.setText(translate.getString("label.Nacionaliteti"));
        numri_telefonit.setText(translate.getString("label.numri_telefonit"));
        nrPasaportes.setText(translate.getString("label.nrPasaportes"));
        next.setText(translate.getString("button.next"));

    }


    @FXML
    public void vazhdo(ActionEvent actionEvent) {

    }
}