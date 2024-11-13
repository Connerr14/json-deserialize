module com.example.jsonproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jsonproject to javafx.fxml;
    exports com.example.jsonproject;
}