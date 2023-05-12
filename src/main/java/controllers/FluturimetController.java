package controllers;

import java.io.IOException;
import java.sql.SQLException;

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

public class FluturimetController {
    @FXML
    private TableColumn  nisja, arritja, vendi_nisjes, vendi_arritjes, statusi,linja;
    @FXML
    private TableView tabela;
    @FXML
    private CheckBox checkBoxFilterIsActive;
    @FXML
    private TextField filterField;

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



    @FXML
    public void shfaqTeGjithaFluturimet(ActionEvent actionEvent) throws SQLException {
        if(checkBoxFilterIsActive.isSelected()){
            checkBoxFilterIsActive.setSelected(false);
        }
        ObservableList<Fluturimet> data = FluturimetRepository.getAll();

        linja.setCellValueFactory(new PropertyValueFactory<>("linja"));
        nisja.setCellValueFactory(new PropertyValueFactory<>("nisja"));
        arritja.setCellValueFactory(new PropertyValueFactory<>("arritja"));
        statusi.setCellValueFactory(new PropertyValueFactory<>("status"));
        vendi_nisjes.setCellValueFactory(new PropertyValueFactory<>("qyteti1"));
        vendi_arritjes.setCellValueFactory(new PropertyValueFactory<>("qyteti2"));

        tabela.setItems(data);
    }

    @FXML
    public void active(ActionEvent actionEvent) throws SQLException {

        if(checkBoxFilterIsActive.isSelected()){
            ObservableList<Fluturimet> data = FluturimetRepository.getActives();

            linja.setCellValueFactory(new PropertyValueFactory<>("linja"));
            nisja.setCellValueFactory(new PropertyValueFactory<>("nisja"));
            arritja.setCellValueFactory(new PropertyValueFactory<>("arritja"));
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
        String fromSearch = filterField.getText();
        ObservableList<Fluturimet> data = FluturimetRepository.getSearched(fromSearch);

        linja.setCellValueFactory(new PropertyValueFactory<>("linja"));
        nisja.setCellValueFactory(new PropertyValueFactory<>("nisja"));
        arritja.setCellValueFactory(new PropertyValueFactory<>("arritja"));
        statusi.setCellValueFactory(new PropertyValueFactory<>("status"));
        vendi_nisjes.setCellValueFactory(new PropertyValueFactory<>("qyteti1"));
        vendi_arritjes.setCellValueFactory(new PropertyValueFactory<>("qyteti2"));

        tabela.setItems(data);
    }
}