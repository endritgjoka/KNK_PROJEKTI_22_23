package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.Perdoruesi;
import models.Rezervimi;
import service.UserSevice;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserProfileController extends HomeController implements Initializable {

    @FXML
    private DatePicker birthdayPicker;

    @FXML
    private ImageView changePass;

    @FXML
    private ImageView editBirth;

    @FXML
    private ImageView editName;

    @FXML
    private ImageView editSurname;

    @FXML
    private ImageView editUsername;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;


    @FXML
    private TextField surnameField;

    @FXML
    private TextField usernameField;
    private Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "");


    Perdoruesi perdoruesi = Rezervimi.getPerdoruesi();
    @Override
    void translateEnglish() {

    }

    @Override
    void translateAlbanian() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ChangePasswordController.setPerdoruesi(perdoruesi);
        this.nameField.setText(perdoruesi.getEmri());
        this.surnameField.setText(perdoruesi.getMbiemri());
        this.usernameField.setText(perdoruesi.getUsername());
        this.birthdayPicker.setValue(perdoruesi.getDitelindja().toLocalDate());
        editBirth.setOnMouseClicked(e->{
            disableAllNodes(nameField.getParent());
            this.birthdayPicker.setDisable(false);
            this.birthdayPicker.requestFocus();
        });
        editName.setOnMouseClicked(e->{
            disableAllNodes(nameField.getParent());
            this.nameField.setDisable(false);
            this.nameField.requestFocus();
        });
        editSurname.setOnMouseClicked(e->{
            disableAllNodes(nameField.getParent());
            this.surnameField.setDisable(false);
            this.surnameField.requestFocus();
        });
        editUsername.setOnMouseClicked(e->{
            disableAllNodes(nameField.getParent());
            this.usernameField.setDisable(false);
            this.usernameField.requestFocus();
        });
        changePass.setOnMouseClicked(e->{
            FXMLLoader fxmlLoader= new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("changePassword.fxml"));
            try {
                Parent root = fxmlLoader.load();
                ChangePasswordController changePasswordController = fxmlLoader.getController();
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();

            } catch (IOException e1) {
                throw new RuntimeException(e1);
            }
        });

    }
    public static void disableAllNodes(Parent parent) {
        for (Node node : parent.getChildrenUnmodifiable()) {
            node.setDisable(true);

            if (node instanceof Parent) {
                disableAllNodes((Parent) node);
            }
        }
    }

    @FXML
    void saveButton(ActionEvent event){
        boolean uf = usernameField.getText().equals("");
        boolean nf = nameField.getText().equals("");
        boolean sf = surnameField.getText().equals("");
        boolean bp = birthdayPicker.getValue().equals("");
        if(!uf && !nf && !sf && !bp) {
            try {
                if (UserSevice.validUsername(usernameField.getText(), perdoruesi.getId())){
                    perdoruesi = UserSevice.editProfile(perdoruesi,usernameField.getText(), nameField.getText(),
                            surnameField.getText(), Date.valueOf(birthdayPicker.getValue()));
                    alert.setAlertType(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Changes have been made!");
                    alert.show();

                }else{
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("Invalid username(taken)!");
                    alert.show();
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("These fields should be filled!");
            alert.show();
        }
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Parent parenti = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = new Scene(parenti);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @FXML
    private void cancel(ActionEvent event) throws IOException {
        Parent parenti = FXMLLoader.load(getClass().getResource("userProfile.fxml"));
        Scene scene = new Scene(parenti);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @FXML
    void saveButton1(ActionEvent event){

    }


}
