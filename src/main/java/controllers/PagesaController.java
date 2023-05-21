package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.Pagesa;
import models.Rezervimi;
import repository.PagesaRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class PagesaController extends HomeController {

    @FXML
    private TextField cardNameField;

    @FXML
    private TextField cardNumberField;

    @FXML
    private RadioButton creditCardRadio;

    @FXML
    private TextField cvvField;

    @FXML
    private RadioButton debitCardRadio;

    @FXML
    private DatePicker expirationDate;

    @FXML
    private ToggleGroup pagesa;

    @FXML
    private BorderPane root;
    @FXML
    private Label emriKartes;
    @FXML
    private Label nrKartes;
    @FXML
    private Label dataSkadimit;
    @FXML
    private Label kodiCVV;
    @FXML
    private Button Rezervoo;
    @FXML
    private Button anuloo;

    Alert alert = new Alert(Alert.AlertType.ERROR,"");
    public static int bId;


    @FXML
    void rezervo(ActionEvent event) throws SQLException {
        if (pagesa.getSelectedToggle() != null && expirationDate.getValue() != null && !cvvField.getText().equals("")
        && !cardNameField.getText().equals("") && !cardNumberField.getText().equals("")){
            String mp = menyraPageses();
            Pagesa pagesa1 = new Pagesa(0,mp, cardNameField.getText(), cardNumberField.getText(),
                    Date.valueOf(expirationDate.getValue()), cvvField.getText(),bId);
            PagesaRepository.insert(pagesa1);
        }else{
            alert.setContentText("These fields should be filled!");
            alert.show();
        }
    }


    String menyraPageses(){
        if (pagesa.getSelectedToggle().equals("MasterCard")){
            return "MasterCard";
        }
        return  "Visa";
    }
    
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
    void translateEnglish(){
        Locale currentLocale = new Locale("en");

        ResourceBundle translate = ResourceBundle.getBundle("translation.content", currentLocale);
        emriKartes.setText(translate.getString("label.emriKartes"));
        nrKartes.setText(translate.getString("label.nrKartes"));
        dataSkadimit.setText(translate.getString("label.dataSkadimit"));
        kodiCVV.setText(translate.getString("label.kodiCVV"));
        Rezervoo.setText(translate.getString("button.Rezervoo"));
        anuloo.setText(translate.getString("button.anuloo"));
    }
    @Override
    void translateAlbanian(){
        Locale currentLocale = new Locale("sq");

        ResourceBundle translate = ResourceBundle.getBundle("translation.content", currentLocale);
        emriKartes.setText(translate.getString("label.emriKartes"));
        nrKartes.setText(translate.getString("label.nrKartes"));
        dataSkadimit.setText(translate.getString("label.dataSkadimit"));
        kodiCVV.setText(translate.getString("label.kodiCVV"));
        Rezervoo.setText(translate.getString("button.Rezervoo"));
        anuloo.setText(translate.getString("button.anuloo"));
    }
}

