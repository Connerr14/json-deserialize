module com.example.jsonproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.jsonproject to javafx.fxml;
    exports com.example.jsonproject;
}