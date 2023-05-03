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
import service.UserSevice;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    private Button btnLoginClick;



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
        // System.out.println("Login button clicked!");
        String usernamei = this.username.getText();
        String passwordi = this.password.getText();

        Alert alert;
        try {
            Perdoruesi perdoruesi = UserSevice.login(usernamei, passwordi);
            if (perdoruesi != null) {
                // System.out.println("User login successfully!");
                // alert = new Alert(Alert.AlertType.CONFIRMATION,"User login successfully!");
                // alert.show();
                Parent parenti = FXMLLoader.load(getClass().getResource("home.fxml"));
                Scene scene = new Scene(parenti);
                Stage primaryStage = (Stage) username.getScene().getWindow();
                primaryStage.setScene(scene);
                primaryStage.show();
            } else {
                System.out.println("Incorrect username/password!");
                alert = new Alert(Alert.AlertType.ERROR, "Incorrect username/password!");
                alert.show();
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


}
