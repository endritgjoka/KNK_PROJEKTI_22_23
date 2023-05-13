package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

public class PagesaController extends BaseController{

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
    private TextField expirationDateField;

    @FXML
    private ToggleGroup pagesa;

    @FXML
    private RadioButton paypalRadio;

    @FXML
    private BorderPane root;

    @Override
    void translateEnglish() {

    }

    @Override
    void translateAlbanian() {

    }
}
