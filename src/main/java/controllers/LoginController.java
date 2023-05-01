package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button submit;
    @FXML
    private void loginClick(ActionEvent event){
        System.out.println("Login button clicked!");
        String username = this.username.getText();
        String password = this.password.getText();
//        System.out.printf("Username: %s, Password: %s \n", username,password);

        if (event.getSource() == submit) {

            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("home.fxml")));
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    };
    @FXML
    private void goToSignUp(ActionEvent event) throws IOException {
        Parent parenti = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Scene scene = new Scene(parenti);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void saveData() throws NoSuchAlgorithmException {

        try {

            String st = "INSERT INTO perdoruesit (emri, mbiemri, email, fjalekalimi, mosha, gjinia, adresa, numri_telefonit, admin) VALUES (?,?,?,?,?,?,?,?,?)";
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest((password.getText()).getBytes());
            String encodedHash =digest.toString();
            // ...

        }
        catch (Exception e){}
//        catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
    }
}

