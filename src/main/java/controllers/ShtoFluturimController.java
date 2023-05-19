package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import models.Aeroporti;
import models.Airoplani;
import models.Fluturimet;
import models.Rezervimi;
import service.FluturimService;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class ShtoFluturimController extends HomeController implements Initializable  {

    @FXML
    private TextField statusi;
    @FXML
    private TextField aeroportiArritjes;

    @FXML
    private TextField aeroportiNisjes;

    @FXML
    private DatePicker dataKthimit;

    @FXML
    private Label dataLabel;
    @FXML
    private DatePicker dataNisjes;
    @FXML
    private ToggleGroup drejtimi;
    @FXML
    private TextField kapaciteti;
    @FXML
    private TextField kompania;
    @FXML
    private TextField oraKthimit;
    @FXML
    private TextField oraNisjes;

    @FXML
    private TextField qytetiArritjes;

    @FXML
    private TextField qytetiNisjes;


    @FXML
    private TextField kohezgjatja;

    @FXML
    private TextField tipi;
    Alert alert = new Alert(Alert.AlertType.ERROR,"");
//dataKthimit.getValue() != null &&
//        && !oraKthimit.getText().isEmpty()
    @FXML
    public void shto(ActionEvent actionEvent) throws Exception {
        if (!statusi.getText().isEmpty() && !aeroportiArritjes.getText().isEmpty() && !aeroportiNisjes.getText().isEmpty()
                &&  dataNisjes.getValue() != null && !kapaciteti.getText().isEmpty() && !kompania.getText().isEmpty()
                 && !oraNisjes.getText().isEmpty() && !qytetiArritjes.getText().isEmpty()
                && !qytetiNisjes.getText().isEmpty() && !kohezgjatja.getText().isEmpty() && !tipi.getText().isEmpty()) {


            int k = Integer.parseInt(kapaciteti.getText());

            Airoplani airoplani = new Airoplani(0, kompania.getText(), k ,tipi.getText());
            Aeroporti aeroportiNisjes1 = new Aeroporti(0, aeroportiNisjes.getText(), qytetiNisjes.getText());
            Aeroporti aeroportiArritjes1 = new Aeroporti(0, aeroportiArritjes.getText(), qytetiArritjes.getText());

            FluturimService.shtoObjektetTjera(airoplani, aeroportiNisjes1, aeroportiArritjes1);

            String dataN = dataNisjes.getValue().toString();
            String oraN = oraNisjes.getText();
            String timestampN = dataN +" " + oraN;

            String timestampA = "";
            Timestamp timestamp;
            if (drejtimi.getSelectedToggle().equals("2 drejtime")){
                String dataA = dataKthimit.getValue().toString();
                String oraA = oraKthimit.getText();
                timestampA = dataA +" " + oraA;
                timestamp = Timestamp.valueOf(timestampA);
            }else{
                timestampA = null;
                timestamp = null;
            }

            int duration = Integer.parseInt(kohezgjatja.getText());
            boolean drejtimi = isDyDrejtimeshe();
            Fluturimet fluturim = new Fluturimet(0, FluturimService.aeroplaniId, FluturimService.aeroportiNisjesiId, Timestamp.valueOf(timestampN),
                    FluturimService.aeroportiArritjesiId,timestamp , statusi.getText(), drejtimi,duration);

            FluturimService.shtoFluturim(fluturim);
        } else {
            alert.setContentText("These fields should be filled!");
            alert.show();
        }


    }

    @FXML
    public void kthehu(ActionEvent event) throws Exception{
        Parent parenti = FXMLLoader.load(getClass().getResource("fluturimet.fxml"));
        Scene scene = new Scene(parenti);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        validateField(kapaciteti);
        validateField(kohezgjatja);
    }

    @FXML
    public void dyDrejtimesh(ActionEvent actionEvent) {
        dataLabel.setVisible(true);
        dataKthimit.setVisible(true);
        oraKthimit.setVisible(true);
    }

    @FXML
    public void njeDrejtimesh(ActionEvent actionEvent) {
        dataLabel.setVisible(false);
        dataKthimit.setVisible(false);
        oraKthimit.setVisible(false);
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

    boolean isDyDrejtimeshe(){
        if (drejtimi.getSelectedToggle().equals("PO")){
            return true;
        }
        return  false;
    }
}
