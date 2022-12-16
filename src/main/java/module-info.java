module com.example.demo {
    requires javafx.controls;
    requires java.sql;
    requires javafx.fxml;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;

    exports com.example.demo.Controller;
    opens com.example.demo.Controller to javafx.fxml;

    exports com.example.demo.Model;
    opens com.example.demo.Model to javafx.fxml;


}