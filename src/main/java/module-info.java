module com.example.knk_projekti {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;



//    opens controllers to javafx.fxml;
    opens controllers to javafx.fxml;

    exports com.example.knk_projekti to javafx.graphics;
    opens com.example.knk_projekti to javafx.fxml;
    exports controllers to javafx.graphics;

    opens models;
    exports models;

}