package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Fluturimet;
import repository.FluturimetRepository;

public class FluturimetController extends BaseController{
    @FXML
    private TableColumn  nisja, kthimi, vendi_nisjes, vendi_arritjes, statusi,linja;
    @FXML
    private TableView tabela;
    @FXML
    private CheckBox checkBoxFilterIsActive;
    @FXML
    private TextField filterField;
    @FXML
    private Label fluturimett;
    @FXML
    private Button kerko;
    @FXML
    private Button teGjitha;
    @FXML
    private Button fshijFluturimin;
    @FXML
    private Button shtoFluturim;
    @FXML
    private Button menaxhoPerdoruesit;
    @FXML
    private Button shikoDiagramet;
    @FXML
    private Button goBack;
    @FXML
    private Pagination pagination;
    private Alert alert = new Alert(Alert.AlertType.ERROR,"");

    public void btnFilter(ActionEvent actionEvent) {
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Parent parenti = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = new Scene(parenti);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    @FXML
    public void shfaqTeGjithaFluturimet(ActionEvent actionEvent) throws Exception {
        if(checkBoxFilterIsActive.isSelected()){
            checkBoxFilterIsActive.setSelected(false);
        }
        ObservableList<Fluturimet> data = FluturimetRepository.getAll(0,"");

        linja.setCellValueFactory(new PropertyValueFactory<>("linja"));
        nisja.setCellValueFactory(new PropertyValueFactory<>("nisja"));
        kthimi.setCellValueFactory(new PropertyValueFactory<>("kthimi"));
        statusi.setCellValueFactory(new PropertyValueFactory<>("status"));
        vendi_nisjes.setCellValueFactory(new PropertyValueFactory<>("qyteti1"));
        vendi_arritjes.setCellValueFactory(new PropertyValueFactory<>("qyteti2"));

        tabela.setItems(data);
    }

    @FXML
    public void active(ActionEvent actionEvent) throws Exception {

        if(checkBoxFilterIsActive.isSelected()){
            ObservableList<Fluturimet> data = FluturimetRepository.getAll(2,"");

            linja.setCellValueFactory(new PropertyValueFactory<>("linja"));
            nisja.setCellValueFactory(new PropertyValueFactory<>("nisja"));
            kthimi.setCellValueFactory(new PropertyValueFactory<>("kthimi"));
            statusi.setCellValueFactory(new PropertyValueFactory<>("status"));
            vendi_nisjes.setCellValueFactory(new PropertyValueFactory<>("qyteti1"));
            vendi_arritjes.setCellValueFactory(new PropertyValueFactory<>("qyteti2"));

            tabela.getItems().clear();
            tabela.setItems(data);
        }else{
            tabela.getItems().clear();
        }

    }

    @FXML
    public void kerkoFluturimin(ActionEvent actionEvent) throws Exception{
        if (!filterField.getText().equals("")){
            String fromSearch = filterField.getText();
            ObservableList<Fluturimet> data = FluturimetRepository.getAll(4,fromSearch);

            linja.setCellValueFactory(new PropertyValueFactory<>("linja"));
            nisja.setCellValueFactory(new PropertyValueFactory<>("nisja"));
            kthimi.setCellValueFactory(new PropertyValueFactory<>("kthimi"));
            statusi.setCellValueFactory(new PropertyValueFactory<>("status"));
            vendi_nisjes.setCellValueFactory(new PropertyValueFactory<>("qyteti1"));
            vendi_arritjes.setCellValueFactory(new PropertyValueFactory<>("qyteti2"));

            tabela.setItems(data);
        }

    }

    @Override
    void translateEnglish() {
        Locale currentLocale = new Locale("en");

        ResourceBundle translate = ResourceBundle.getBundle("translation.content", currentLocale);
        fluturimett.setText(translate.getString("label.fluturimett"));
        kerko.setText(translate.getString("button.kerko"));
        teGjitha.setText(translate.getString("button.teGjitha"));
        fshijFluturimin.setText(translate.getString("button.fshijFluturimin"));
        shtoFluturim.setText(translate.getString("button.shtoFluturim"));
        menaxhoPerdoruesit.setText(translate.getString("button.menaxhoPerdoruesit"));
        shikoDiagramet.setText(translate.getString("button.shikoDiagramet"));
        goBack.setText(translate.getString("button.goBack"));


    }

    @Override
    void translateAlbanian() {
        Locale currentLocale = new Locale("sq");

        ResourceBundle translate = ResourceBundle.getBundle("translation.content", currentLocale);
        fluturimett.setText(translate.getString("label.fluturimett"));
        kerko.setText(translate.getString("button.kerko"));
        teGjitha.setText(translate.getString("button.teGjitha"));
        fshijFluturimin.setText(translate.getString("button.fshijFluturimin"));
        shtoFluturim.setText(translate.getString("button.shtoFluturim"));
        menaxhoPerdoruesit.setText(translate.getString("button.menaxhoPerdoruesit"));
        shikoDiagramet.setText(translate.getString("button.shikoDiagramet"));
        goBack.setText(translate.getString("button.goBack"));


    }

    @FXML
    public void menaxhoPerdoruesit(ActionEvent actionEvent) {
    }

    @FXML
    public void shikoDiagramet(ActionEvent actionEvent) {
    }

    @FXML
    public void shtoFluturim(ActionEvent actionEvent) throws Exception {
        Parent parent = FXMLLoader.load(App.class.getResource("shtoFluturim.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void fshijFluturiminEPerzgjedhur(ActionEvent actionEvent) throws SQLException {
        Fluturimet fluturimet = (Fluturimet) tabela.getSelectionModel().getSelectedItem();
        if (fluturimet != null){
            FluturimetRepository.delete(fluturimet.getId());
            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Flight has been deleted successfully!");
            alert.show();
        }
    }
}