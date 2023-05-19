package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import models.Bagazhet;
import models.Bileta;
import models.Pasagjeri;
import models.Rezervimi;
import repository.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Locale;
import java.util.ResourceBundle;

public class RezervimController extends BaseController implements Initializable {

    @FXML
    private ChoiceBox kategoria;

    @FXML
    private TextField numriBagazhev;

    @FXML
    private TextField numriUleses;

    @FXML
    private TextField pesha;

    @FXML
    private TextField çmimi;
    @FXML
    private Label kategoriaBiletes;
    @FXML
    private  Label nrUleses;
    @FXML
    private Label bagazhi;
    @FXML
    private Label nrBagazhit;
    @FXML
    private Label cmimi;
    @FXML
    private Button vazhdo;
    public static int pasagjeriId;
    private int qmimi;

    Alert alert = new Alert(Alert.AlertType.ERROR,"");
    @FXML
    void vazhdo(ActionEvent event) throws SQLException {
        if(kategoria.getValue() != null && !numriUleses.getText().equals("") && !numriBagazhev.getText().equals("") && !pesha.getText().equals("")){

            Bagazhet bagazh = new Bagazhet(0, pasagjeriId, Integer.parseInt(numriBagazhev.getText()),
                    Integer.parseInt(pesha.getText()));
            PagesaController.setData(bagazh);
            //BagazhetRepository.insert(bagazh);
            int qmimi = 200;
            if (kategoria.equals("Ekonomike")){
                qmimi += 50;
            } else if (kategoria.equals("Biznesore")) {
                qmimi += 30;
            }
            if (Integer.parseInt(numriBagazhev.getText() )> 1){
                qmimi += 30;
            }

            çmimi.setText(qmimi+"");

            if(RezervimiRepository.isValidSeat(Integer.parseInt(numriUleses.getText()),FromToController.fId)
            && AiroplaniRepository.intoCapacity(Integer.parseInt(numriUleses.getText()),FromToController.fId)){
                Bileta bileta = new Bileta(0,Integer.parseInt(çmimi.getText()));
                PagesaController.setData(bileta);
                // int biletaId = BiletaRepository.insert(bileta);
                // PagesaController.bId = biletaId;
                Rezervimi rezervimi = new Rezervimi(0, pasagjeriId, FromToController.fId,
                        Integer.parseInt(numriUleses.getText()), kategoria.getValue().toString(), 0);
                // RezervimiRepository.insert(rezervimi);
                PagesaController.setData(rezervimi);
                FXMLLoader fxmlLoader= new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("pagesa.fxml"));
                try {
                    Parent root = fxmlLoader.load();
                    PagesaController pagesaController = fxmlLoader.getController();
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.setTitle("Pagesa");
                    stage.show();
                    Stage stage1 =(Stage) kategoria.getScene().getWindow();
                    stage1.close();

                } catch (IOException e1) {
                    throw new RuntimeException(e1);
                }
            }else{
                alert.setContentText("This seat is reserved/out of capacity!");
                alert.show();
            }

        }else{
            alert.setContentText("These fields should be filled!");
            alert.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        validateField(pesha);
        validateField(numriBagazhev);
        validateField(numriUleses);

        kategoria.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            double ticketPrice = kalkuloÇmimin();
            çmimi.setText(String.valueOf(ticketPrice));
        });

        pesha.textProperty().addListener((observable, oldValue, newValue) -> {
            double ticketPrice = kalkuloÇmimin();
            çmimi.setText(String.valueOf(ticketPrice));
        });

        numriBagazhev.textProperty().addListener((observable, oldValue, newValue) -> {
            double ticketPrice = kalkuloÇmimin();
            çmimi.setText(String.valueOf(ticketPrice));
        });
    }


    void validateField(TextField field){
        field.setOnKeyPressed(e->{
            if (!e.getCode().isDigitKey() && e.getCode() != KeyCode.BACK_SPACE){
                e.consume();
                alert.setContentText("Only digits here!");
                alert.show();
            }
        });
    }

    @Override
    void translateEnglish() {
        Locale currentLocale = new Locale("en");

        ResourceBundle translate = ResourceBundle.getBundle("translation.content", currentLocale);
        kategoriaBiletes.setText(translate.getString("label.kategoriaBiletes"));
        nrUleses.setText(translate.getString("label.nrUleses"));
        bagazhi.setText(translate.getString("label.bagazhi"));
        nrBagazhit.setText(translate.getString("label.nrBagazhit"));
        cmimi.setText(translate.getString("label.cmimi"));
        vazhdo.setText(translate.getString("button.vazhdo"));


    }

    @Override
    void translateAlbanian() {
        Locale currentLocale = new Locale("sq");

        ResourceBundle translate = ResourceBundle.getBundle("translation.content", currentLocale);
        kategoriaBiletes.setText(translate.getString("label.kategoriaBiletes"));
        nrUleses.setText(translate.getString("label.nrUleses"));
        bagazhi.setText(translate.getString("label.bagazhi"));
        nrBagazhit.setText(translate.getString("label.nrBagazhit"));
        cmimi.setText(translate.getString("label.cmimi"));
        vazhdo.setText(translate.getString("button.vazhdo"));

    }

    public double kalkuloÇmimin() {
        double qmimiBaze = 0,baggagePrice = 0, suitcasePrice = 0;

            String category = kategoria.getValue().toString();
            double baggageWeight = Double.parseDouble(bagazhi.getText());
            int suitcaseCount = Integer.parseInt(nrBagazhit.getText());

            if (category.equals("Ekonomike")) {
                qmimiBaze = 100.0;
            } else if (category.equals("Biznesore")) {
                qmimiBaze = 200.0;
            } else {
                qmimiBaze = 150.0;
            }

             baggagePrice = baggageWeight * 10.0;
             suitcasePrice = suitcaseCount * 20.0;


        return qmimiBaze + baggagePrice + suitcasePrice;
    }

}
