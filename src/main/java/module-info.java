module com.example.knk_projekti {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.knk_projekti to javafx.fxml;
    opens controllers to javafx.fxml;

//    exports com.example.knk_projekti;
    exports controllers to javafx.graphics;
}