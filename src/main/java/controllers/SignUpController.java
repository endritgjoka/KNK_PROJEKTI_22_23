package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.Perdoruesi;
import service.UserSevice;

import java.time.LocalDate;
import java.time.Period;

public class SignUpController {
    @FXML
    private TextField emri;
    @FXML
    private TextField mbiemri;
    @FXML
    private TextField username;

    @FXML
    private PasswordField fjalekalimi;
    @FXML
    private PasswordField rishkruajFjalekalimin;
    @FXML
    private DatePicker ditelindja;

    @FXML
    private RadioButton mashkull, femer;
    @FXML
    private char pgjinia;

    public char getPgjinia() {
        return pgjinia;
    }

    public void setPgjinia(char pgjinia) {
        this.pgjinia = pgjinia;
    }



    @FXML
    public void btnSignUp(ActionEvent actionEvent) throws Exception{
        String pemri = emri.getText();
        String pmbiemri = mbiemri.getText();
        String pusername = username.getText();
        String pfjalekalimi = fjalekalimi.getText();
        String prishkruajFjalekalimin = rishkruajFjalekalimin.getText();
        int pmosha = this.kalkuloMoshen();
        char pgjinia = this.getPgjinia();
        boolean isAdmin = false;

        if (pfjalekalimi.equals(prishkruajFjalekalimin)){
            Perdoruesi user = UserSevice.signUp(pemri, pmbiemri, pusername,pfjalekalimi,
                    pmosha,pgjinia,isAdmin);
            Parent parenti = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(parenti);
            Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            primaryStage.setScene(scene);
            primaryStage.show();
        }else{
            Alert  alert = new Alert(Alert.AlertType.ERROR,"Passwords don't match!");
        }



    }

    private int kalkuloMoshen(){
        LocalDate selectedDate = ditelindja.getValue();
        LocalDate currentDate = LocalDate.now();

        if (selectedDate != null) {
            int mosha = Period.between(selectedDate, currentDate).getYears();
            return mosha;
        }
        return 0;
    }

    public void getGjinia(ActionEvent actionEvent) {
        if(mashkull.isSelected()){
            femer.disableProperty();
            setPgjinia(mashkull.getText().charAt(0));
        }else{
            mashkull.disableProperty();
            setPgjinia(femer.getText().charAt(0));
        }

    }
}
