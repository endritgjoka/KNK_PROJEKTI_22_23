package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import models.Pagesa;
import repository.PagesaRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class PagesaController extends BaseController {

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

    @Override
    void translateEnglish() {
        Locale currentLocale = new Locale("en");

        ResourceBundle translate = ResourceBundle.getBundle("translation.content", currentLocale);
        emriKartes.setText(translate.getString("label.emriKartes"));
        nrKartes.setText(translate.getString("label.nrKartes"));
        dataSkadimit.setText(translate.getString("label.dataSkadimit"));
        kodiCVV.setText(translate.getString("label.kodiCVV"));
        Rezervoo.setText(translate.getString("button.Rezervoo"));
    }

    @Override
    void translateAlbanian() {
        Locale currentLocale = new Locale("sq");

        ResourceBundle translate = ResourceBundle.getBundle("translation.content", currentLocale);
        emriKartes.setText(translate.getString("label.emriKartes"));
        nrKartes.setText(translate.getString("label.nrKartes"));
        dataSkadimit.setText(translate.getString("label.dataSkadimit"));
        kodiCVV.setText(translate.getString("label.kodiCVV"));
        Rezervoo.setText(translate.getString("button.Rezervoo"));

    }
}
