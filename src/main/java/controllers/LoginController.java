package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import models.Perdoruesi;
import models.Rezervimi;
import service.UserSevice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginController extends  BaseController{

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    private Button btnLoginClick;

    @FXML
    private Button signIn;
    @FXML
    private Button signUp;



    @FXML
    private void goToSignUp(ActionEvent event) throws IOException {
        Parent parenti = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Scene scene = new Scene(parenti);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void loginClick(ActionEvent event) throws SQLException {
        String usernamei = this.username.getText();
        String passwordi = this.password.getText();

        Alert alert;
        try {
            Perdoruesi perdoruesi = UserSevice.login(usernamei, passwordi);
            Rezervimi.setPerdoruesi(perdoruesi);
            if (perdoruesi != null && perdoruesi.isAdmin()) {
                Parent parenti = FXMLLoader.load(getClass().getResource("fluturimet.fxml"));
                Scene scene = new Scene(parenti);
                Stage primaryStage = (Stage) username.getScene().getWindow();
                primaryStage.setScene(scene);
                primaryStage.show();
            } else if(perdoruesi != null && !perdoruesi.isAdmin()){
                Parent parenti = FXMLLoader.load(getClass().getResource("home.fxml"));
                Scene scene = new Scene(parenti);
                Stage primaryStage = (Stage) username.getScene().getWindow();
                primaryStage.setTitle("Home");
                primaryStage.setScene(scene);
                primaryStage.show();
            }else{
                alert = new Alert(Alert.AlertType.ERROR, "Incorrect username/password!");
                alert.show();
                password.setText("");
            }
        } catch (SQLException | IOException ex) {
            throw new RuntimeException(ex);
        }

    };


    @FXML
    public void login(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            try {
                loginClick(new ActionEvent());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    void translateEnglish() {
        Locale currentLocale = new Locale("en");

        ResourceBundle translate = ResourceBundle.getBundle("translation.content", currentLocale);
        signIn.setText(translate.getString("button.signIn"));
        signUp.setText(translate.getString("button.signUp"));

    }

    @Override
    void translateAlbanian() {
        Locale currentLocale = new Locale("sq");

        ResourceBundle translate = ResourceBundle.getBundle("translation.content", currentLocale);
        signIn.setText(translate.getString("button.signIn"));
        signUp.setText(translate.getString("button.signUp"));

    }
}