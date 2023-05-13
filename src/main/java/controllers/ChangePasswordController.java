package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import models.Perdoruesi;
import service.UserSevice;

import java.sql.SQLException;

public class ChangePasswordController {

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private PasswordField oldPasswordField;
    @FXML
    private PasswordField confirmNewPasswordField;
    private static Perdoruesi perdoruesi;

    @FXML
    void savePass(ActionEvent event) throws SQLException {
        Alert alert = new Alert(Alert.AlertType.ERROR,"");;
        if (!newPasswordField.getText().equals("") && !confirmNewPasswordField.getText().equals("")
                && !oldPasswordField.getText().equals("")
                && newPasswordField.getText().equals(confirmNewPasswordField.getText())){
            Perdoruesi perdoruesi1 = UserSevice.editPassword(getPerdoruesi(), oldPasswordField.getText(), newPasswordField.getText());
            if (perdoruesi1 != null ){
                alert.setAlertType(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Password has been changed!");
                alert.show();
            }else{
                alert.setContentText("Incorrect old password or passwords don't match!");
                alert.show();
            }
        }else{
            alert.setContentText("These fields should be filled!");
            alert.show();
        }
    }

    @FXML
    void cancel(ActionEvent event) throws SQLException {
        Stage stage =(Stage) oldPasswordField.getScene().getWindow();
        stage.close();
    }

    public static Perdoruesi getPerdoruesi() {
        return perdoruesi;
    }

    public static void setPerdoruesi(Perdoruesi perdoruesi1) {
        perdoruesi = perdoruesi1;
    }
}
