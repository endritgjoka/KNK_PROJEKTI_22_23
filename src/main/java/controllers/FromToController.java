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
import java.util.Locale;
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
    @FXML
    private Label nga;
    @FXML
    private Label ne;
    @FXML
    private Label dyDrejtimeshe;
    @FXML
    private RadioButton po;
    @FXML
    private RadioButton jo;
    @FXML
    private Label nisjaa;
    @FXML
    private Label kthimi_Label;
    @FXML
    private Button filtro;
    @FXML
    private Button cancell;
    @FXML
    private Button Rezervo;
    @FXML
    private ChoiceBox gjuha;

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
        Locale currentLocale = new Locale("en");


        ResourceBundle translate = ResourceBundle.getBundle("translation.content_en", currentLocale);
        nga.setText(translate.getString("label.nga"));
        ne.setText(translate.getString("label.ne"));
        dyDrejtimeshe.setText(translate.getString("label.dyDrejtimeshe"));
        po.setText(translate.getString("radiobutton.po"));
        jo.setText(translate.getString("radiobutton.jo"));
        nisjaa.setText(translate.getString("label.nisjaa"));
        kthimi_Label.setText(translate.getString("label.kthimi_Label"));
        filtro.setText(translate.getString("button.filtro"));
        cancell.setText(translate.getString("button.cancell"));
        Rezervo.setText(translate.getString("button.Rezervo"));


    }

    @Override
    void translateAlbanian() {
        Locale currentLocale = Locale.getDefault();

        ResourceBundle translate = ResourceBundle.getBundle("translation.content_sq", currentLocale);
        nga.setText(translate.getString("label.nga"));
        ne.setText(translate.getString("label.ne"));
        dyDrejtimeshe.setText(translate.getString("label.dyDrejtimeshe"));
        po.setText(translate.getString("radiobutton.po"));
        jo.setText(translate.getString("radiobutton.jo"));
        nisjaa.setText(translate.getString("label.nisjaa"));
        kthimi_Label.setText(translate.getString("label.kthimi_Label"));
        filtro.setText(translate.getString("button.filtro"));
        cancell.setText(translate.getString("button.cancell"));
        Rezervo.setText(translate.getString("button.Rezervo"));

    }

    @FXML
    void handleFilterAction(ActionEvent event) throws Exception {
        tabela.getItems().clear();

        String d = "";
        String dc = "";
        String rc = "";
        ObservableList<Fluturimet> list = null;
        if (dyDrejtimeshi){
            if (departureDatePicker.getValue()!= null && returnDatePicker.getValue() != null
                    && departingCityChoiceBox.getValue() != null && arrivalCityChoiceBox.getValue() != null && drejtimi.getSelectedToggle().isSelected()){

                d = departureDatePicker.getValue().toString();
                dc = departingCityChoiceBox.getValue().toString();
                rc = arrivalCityChoiceBox.getValue().toString();

                String r = returnDatePicker.getValue().toString();
                list = FluturimetRepository.getSearched(dyDrejtimeshi,dc, rc, d, r);
                setInTable(list);

            }
        }
        else {

            if (departureDatePicker.getValue() != null && departingCityChoiceBox.getValue() != null
                    && arrivalCityChoiceBox.getValue() != null) {
                d = departureDatePicker.getValue().toString();
                dc = departingCityChoiceBox.getValue().toString();
                rc = arrivalCityChoiceBox.getValue().toString();
                list = FluturimetRepository.getSearched(dyDrejtimeshi, dc, rc, d, "");
                setInTable(list);

            }
        }




    }

    @Override
    public void initialize(URL location, ResourceBundle resources){

        Locale.setDefault(new Locale("sq"));
        translateAlbanian();
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

        if (gjuha.getValue() != null){
           if (gjuha.getSelectionModel().equals("Shqip")){
               translateAlbanian();
           }else{
               translateEnglish();
           }
        }
        gjuha.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (newValue.equals("Shqip")) {
                    translateAlbanian();
                } else {
                    translateEnglish();
                }
            }
        });

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

    private void setInTable(ObservableList<Fluturimet> list){
        linja.setCellValueFactory(new PropertyValueFactory<>("linja"));
        nisja.setCellValueFactory(new PropertyValueFactory<>("nisja"));
        kthimi.setCellValueFactory(new PropertyValueFactory<>("kthimi"));
        statusi.setCellValueFactory(new PropertyValueFactory<>("status"));
        vendi_nisjes.setCellValueFactory(new PropertyValueFactory<>("qyteti1"));
        vendi_arritjes.setCellValueFactory(new PropertyValueFactory<>("qyteti2"));

        tabela.setItems(list);
    }


}
