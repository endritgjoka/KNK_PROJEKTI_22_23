package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Fluturimet;
import models.Rezervimi;
import repository.FluturimetRepository;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class FromToController extends  BaseController implements Initializable {

    @FXML
    private ChoiceBox arrivalCityChoiceBox;

    @FXML
    private ChoiceBox departingCityChoiceBox;

    @FXML
    private DatePicker departureDatePicker;
    @FXML
    private Label kthimiLabel;

    @FXML
    private TableColumn kthimi;

    @FXML
    private TableColumn linja;

    @FXML
    private TableColumn nisja;

    @FXML
    private DatePicker returnDatePicker;

    @FXML
    private TableColumn rezervimi;

    @FXML
    private TableColumn statusi;

    @FXML
    private TableView tabela;

    @FXML
    private TableColumn vendi_arritjes;
    @FXML
    private ToggleGroup drejtimi;

    @FXML
    private TableColumn vendi_nisjes;
    private boolean dyDrejtimeshi = true;

    public static int fId;
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
    void handleFilterAction(ActionEvent event) throws Exception {
        tabela.getItems().clear();

        String d = departureDatePicker.getValue().toString();
        String dc = departingCityChoiceBox.getValue().toString();
        String rc = arrivalCityChoiceBox.getValue().toString();
        ObservableList<Fluturimet> list = null;
        if (dyDrejtimeshi){
            if (departureDatePicker.getValue()!= null && returnDatePicker.getValue() != null
                    && departingCityChoiceBox.getValue() != null && arrivalCityChoiceBox.getValue() != null && drejtimi.getSelectedToggle().isSelected()){

                String r = returnDatePicker.getValue().toString();
                list = FluturimetRepository.getSearched(dyDrejtimeshi,dc, rc, d, r);

            }
        }
        else {

            if (departureDatePicker.getValue() != null && departingCityChoiceBox.getValue() != null
                    && arrivalCityChoiceBox.getValue() != null) {
                list = FluturimetRepository.getSearched(dyDrejtimeshi, dc, rc, d, "");


            }
        }

            linja.setCellValueFactory(new PropertyValueFactory<>("linja"));
            nisja.setCellValueFactory(new PropertyValueFactory<>("nisja"));
            kthimi.setCellValueFactory(new PropertyValueFactory<>("kthimi"));
            statusi.setCellValueFactory(new PropertyValueFactory<>("status"));
            vendi_nisjes.setCellValueFactory(new PropertyValueFactory<>("qyteti1"));
            vendi_arritjes.setCellValueFactory(new PropertyValueFactory<>("qyteti2"));
            rezervimi.setSortNode(new Button("Rezervo"));

            tabela.setItems(list);


    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        try {
            ObservableList<Fluturimet> list = FluturimetRepository.getAll();
            Collections.sort(list, Comparator.comparing(Fluturimet::getQyteti1));
            for (Fluturimet fluturim: list ) {
                departingCityChoiceBox.getItems().add(fluturim.getQyteti1());
                arrivalCityChoiceBox.getItems().add(fluturim.getQyteti2());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    public void njeDrejtimesh(ActionEvent actionEvent) {
        this.dyDrejtimeshi = false;
        returnDatePicker.setVisible(false);
        kthimiLabel.setVisible(false);
    }

    @FXML
    public void dyDrejtimesh(ActionEvent actionEvent) {
        this.dyDrejtimeshi = true;
        returnDatePicker.setVisible(true);
        kthimiLabel.setVisible(true);
    }

    @FXML
    public void rezervo(ActionEvent actionEvent) {
//        tabela.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
//            if (newSelection != null) {
//                int id = newSelection.getId(); // Assuming your model class has an ID property
//                System.out.println("Selected row ID: " + id);
//            }
//        });

        // Get the selected row
        Fluturimet selectedObject = (Fluturimet) tabela.getSelectionModel().getSelectedItem();

       // Get the ID of the selected row
        if (selectedObject != null){
            fId = selectedObject.getId();
            FXMLLoader fxmlLoader= new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("pasagjer.fxml"));
            try {
                Parent root = fxmlLoader.load();
                PasagjerController pasagjerController = fxmlLoader.getController();
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();

            } catch (IOException e1) {
                throw new RuntimeException(e1);
            }
        }



    }
}
