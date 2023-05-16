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

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;
import java.util.ResourceBundle;

public class SignUpController extends BaseController{
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
    @FXML
    private Label emrii;
    @FXML
    private Label mbiemrii;
    @FXML
    private Label emaili;
    @FXML
    private Label gjinia;
    @FXML
    private Label ditelindjaa;
    @FXML
    private Label fjalekalimii;
    @FXML
    private Label RishkruajFjalekalimin;
    @FXML
    private Button sign_up;

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
        Date pditelindja = Date.valueOf(ditelindja.getValue());
        char pgjinia = this.getPgjinia();
        boolean isAdmin = false;

        if (pfjalekalimi.equals(prishkruajFjalekalimin)){
            if (UserSevice.validUsername(pusername, 0)){
                Perdoruesi user = UserSevice.signUp(pemri, pmbiemri, pusername,pfjalekalimi,
                        pgjinia,isAdmin,pditelindja);
                Parent parenti = FXMLLoader.load(getClass().getResource("login.fxml"));
                Scene scene = new Scene(parenti);
                Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                primaryStage.setScene(scene);
                primaryStage.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR,"Invalid username(taken)!");
                alert.show();
            }

        }else{
            Alert  alert = new Alert(Alert.AlertType.ERROR,"Passwords don't match!");
            alert.show();
        }



    }

//    private int kalkuloMoshen(){
//        LocalDate selectedDate = ditelindja.getValue();
//        LocalDate currentDate = LocalDate.now();
//
//        if (selectedDate != null) {
//            int mosha = Period.between(selectedDate, currentDate).getYears();
//            return mosha;
//        }
//        return 0;
//    }

    public void getGjinia(ActionEvent actionEvent) {
        if(mashkull.isSelected()){
            femer.disableProperty();
            setPgjinia(mashkull.getText().charAt(0));
        }else{
            mashkull.disableProperty();
            setPgjinia(femer.getText().charAt(0));
        }

    }

    @Override
    void translateEnglish() {
        Locale currentLocale = new Locale("en");

        ResourceBundle translate = ResourceBundle.getBundle("translation.content", currentLocale);
        emrii.setText(translate.getString("label.emrii"));
        mbiemrii.setText(translate.getString("label.mbiemrii"));
        emaili.setText(translate.getString("label.emaili"));
        gjinia.setText(translate.getString("label.gjinia"));
        ditelindjaa.setText(translate.getString("label.ditelindjaa"));
        fjalekalimii.setText(translate.getString("label.fjalekalimii"));
        RishkruajFjalekalimin.setText(translate.getString("label.RishkruajFjalekalimin"));
        sign_up.setText(translate.getString("button.sign_up"));

    }

    @Override
    void translateAlbanian() {
        Locale currentLocale = new Locale("sq");

        ResourceBundle translate = ResourceBundle.getBundle("translation.content", currentLocale);
        emrii.setText(translate.getString("label.emrii"));
        mbiemrii.setText(translate.getString("label.mbiemrii"));
        emaili.setText(translate.getString("label.emaili"));
        gjinia.setText(translate.getString("label.gjinia"));
        ditelindjaa.setText(translate.getString("label.ditelindjaa"));
        fjalekalimii.setText(translate.getString("label.fjalekalimii"));
        RishkruajFjalekalimin.setText(translate.getString("label.RishkruajFjalekalimin"));
        sign_up.setText(translate.getString("button.sign_up"));


    }
}