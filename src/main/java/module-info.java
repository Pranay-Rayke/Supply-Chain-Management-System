module com.example.supplychain {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.supplychain to javafx.fxml;
    exports com.example.supplychain;
}