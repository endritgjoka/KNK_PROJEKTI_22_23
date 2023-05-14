package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import models.Bagazhet;
import models.Bileta;
import models.Rezervimi;
import repository.BagazhetRepository;
import repository.BiletaRepository;
import repository.RezervimiRepository;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ResourceBundle;

public class RezervimController implements Initializable {

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
    public static int pasagjeriId;

    Alert alert = new Alert(Alert.AlertType.ERROR,"");
    @FXML
    void vazhdo(ActionEvent event) throws SQLException {
        if(!kategoria.getValue().equals("") && !çmimi.getText().equals("") &&
                !numriUleses.getText().equals("") && !numriBagazhev.getText().equals("") && !pesha.getText().equals("")){

            Bagazhet bagazh = new Bagazhet(0, pasagjeriId, Integer.parseInt(numriBagazhev.getText()),
                    Integer.parseInt(pesha.getText()));
            BagazhetRepository.insert(bagazh);
            Bileta bileta = new Bileta(0,Integer.parseInt(çmimi.getText()));
            int biletaId = BiletaRepository.insert(bileta );
            Rezervimi rezervimi = new Rezervimi(0, pasagjeriId, FromToController.fId,
                    Integer.parseInt(numriUleses.getText()), kategoria.getValue().toString(), biletaId);
            RezervimiRepository.insert(rezervimi);
            FXMLLoader fxmlLoader= new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("pagesa.fxml"));
            try {
                Parent root = fxmlLoader.load();
                PagesaController pagesaController = fxmlLoader.getController();
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
                Stage stage1 =(Stage) kategoria.getScene().getWindow();
                stage1.close();

            } catch (IOException e1) {
                throw new RuntimeException(e1);
            }
        }else{
            alert.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        validateField(pesha);
        validateField(numriBagazhev);
        validateField(numriUleses);
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
}
