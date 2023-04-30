package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private void loginClick(ActionEvent event){
        System.out.println("Login button clicked!");
        String username = this.username.getText();
        String password = this.password.getText();
        System.out.printf("Username: %s, Password: %s \n", username,password);
    };

    @FXML
    private void goToSignUp(ActionEvent event) throws IOException {
        Parent parenti = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Scene scene = new Scene(parenti);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

